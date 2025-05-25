package Indiv_4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Клас, що представляє готель, керуючий поселенням та виселенням постояльців.
 * Готель має обмежену місткість і поточний список проживаючих осіб.
 */
public class Hotel {
    /**
     * Максимальна місткість готелю.
     */
    private final int capacity;
    /**
     * Поточний список постояльців, що проживають у готелі.
     * Використання CopyOnWriteArrayList забезпечує потокобезпеку для операцій додавання/видалення
     * при одночасному читанні з багатьох потоків.
     */
    private final List<AccommodationRequest> currentOccupants;
    /**
     * Об'єкт-монітор для синхронізації доступу до ресурсів готелю (місць)
     * та для реалізації механізму wait()/notifyAll() для очікуючих заявок.
     */
    private final Object occupancyMonitor = new Object();

    /**
     * Конструктор класу Hotel.
     *
     * @param capacity Максимальна кількість постояльців, яку може прийняти готель.
     */
    public Hotel(int capacity) {
        this.capacity = capacity;
        this.currentOccupants = new CopyOnWriteArrayList<>();
        System.out.printf("[%s] Готель створено з місткістю: %d%n",
                System.currentTimeMillis(), capacity);
    }

    /**
     * Спроба поселити заявку на проживання в готелі.
     * Ця операція синхронізована для забезпечення потокобезпеки.
     * Якщо є вільні місця, заявка поселяється, і всі очікуючі потоки повідомляються.
     *
     * @param request Об'єкт AccommodationRequest, що представляє заявку на проживання.
     * @return true, якщо поселення успішне; false, якщо немає вільних місць.
     */
    public boolean checkIn(AccommodationRequest request) {
        synchronized (occupancyMonitor) {
            long currentTime = System.currentTimeMillis();
            if (currentOccupants.size() < capacity) {
                currentOccupants.add(request);
                System.out.printf("[%s] УСПІШНЕ ПОСЕЛЕННЯ: %s. Залишилось місць: %d/%d%n",
                        currentTime, request.getGuestName(), capacity - currentOccupants.size(), capacity);
                occupancyMonitor.notifyAll(); // Повідомляємо всім, хто чекає, що місце звільнилося
                return true;
            } else {
                System.out.printf("[%s] БЕЗУСПІШНЕ ПОСЕЛЕННЯ: %s. Немає вільних місць. Зайнято: %d/%d%n",
                        currentTime, request.getGuestName(), currentOccupants.size(), capacity);
                return false;
            }
        }
    }

    /**
     * Виселення заданої заявки на проживання з готелю.
     * Ця операція синхронізована. Після виселення всі очікуючі потоки повідомляються.
     *
     * @param request Об'єкт AccommodationRequest, що представляє заявку на виселення.
     */
    public void checkOut(AccommodationRequest request) {
        synchronized (occupancyMonitor) {
            long currentTime = System.currentTimeMillis();
            if (currentOccupants.remove(request)) {
                System.out.printf("[%s] ВИСЕЛЕННЯ: %s. Залишилось місць: %d/%d%n",
                        currentTime, request.getGuestName(), capacity - currentOccupants.size(), capacity);
                occupancyMonitor.notifyAll(); // Повідомляємо всім, хто чекає, що місце звільнилося
            } else {
                System.out.printf("[%s] ПОМИЛКА ВИСЕЛЕННЯ: %s не знайдено в готелі.%n",
                        currentTime, request.getGuestName());
            }
        }
    }

    /**
     * Повертає об'єкт-монітор, який використовується для синхронізації доступу до готелю
     * та для реалізації wait()/notifyAll().
     *
     * @return Об'єкт, який є монітором для синхронізації готелю.
     */
    public Object getOccupancyMonitor() {
        return occupancyMonitor;
    }
}