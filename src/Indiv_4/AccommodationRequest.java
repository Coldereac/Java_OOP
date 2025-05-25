package Indiv_4;

/**
 * Клас, що представляє заявку на проживання в готелі.
 * Кожна заявка працює як окремий потік, який намагається поселитися,
 * проживає певний час і потім виселяється.
 */
public class AccommodationRequest implements Runnable {
    /**
     * Прізвище постояльця.
     */
    private final String guestName;
    /**
     * Тривалість проживання в мілісекундах.
     */
    private final long durationMillis;
    /**
     * Посилання на об'єкт готелю, в який подається заявка.
     */
    private final Hotel hotel;
    /**
     * Посилання на потік, в якому виконується ця заявка.
     */
    private Thread thread;

    /**
     * Конструктор класу AccommodationRequest.
     * Ініціалізує заявку з прізвищем постояльця, тривалістю проживання
     * та посиланням на готель.
     *
     * @param guestName      Прізвище постояльця.
     * @param durationMillis Тривалість проживання в мілісекундах.
     * @param hotel          Об'єкт готелю, до якого подається заявка.
     */
    public AccommodationRequest(String guestName, long durationMillis, Hotel hotel) {
        this.guestName = guestName;
        this.durationMillis = durationMillis;
        this.hotel = hotel;
        // Створюємо потік для цієї заявки. Запуск відбувається через startAccommodation().
        this.thread = new Thread(this);
        this.thread.setName(guestName + "_Thread"); // Встановлюємо ім'я потоку для зручності налагодження
    }

    /**
     * Повертає прізвище постояльця.
     *
     * @return Прізвище постояльця.
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Запускає потік для цієї заявки на проживання.
     * Якщо потік вже запущено або не існує, створює новий і запускає його.
     */
    public void startAccommodation() {
        if (thread != null && !thread.isAlive()) {
            thread.start();
        } else if (thread == null) {
            this.thread = new Thread(this);
            this.thread.setName(guestName + "_Thread");
            this.thread.start();
        }
    }

    /**
     * Метод, який виконується в окремому потоці для обробки заявки на проживання.
     * Він намагається поселитися в готель. Якщо немає вільних місць,
     * переходить в режим очікування, доки місце не з'явиться.
     * Після успішного поселення "спить" заданий час і потім виселяється.
     */
    @Override
    public void run() {
        // Синхронізуємось на моніторі готелю, щоб керувати доступом до місць
        synchronized (hotel.getOccupancyMonitor()) {
            // Цикл продовжується, доки заявка не буде успішно поселена
            while (!hotel.checkIn(this)) {
                try {
                    long currentTime = System.currentTimeMillis();
                    System.out.printf("[%s] %s чекає на вільне місце...%n", currentTime, guestName);
                    // Якщо немає місць, потік переходить у стан очікування
                    hotel.getOccupancyMonitor().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Відновлюємо статус переривання
                    System.out.printf("[%s] %s перервано під час очікування.%n", System.currentTimeMillis(), guestName);
                    return; // Завершуємо виконання потоку
                }
            }
        }

        // Якщо поселення успішне, потік "спить" задану кількість мілісекунд, імітуючи проживання
        try {
            long currentTime = System.currentTimeMillis();
            System.out.printf("[%s] %s успішно поселився і буде проживати %d мс.%n",
                    currentTime, guestName, durationMillis);
            Thread.sleep(durationMillis);
        } catch (InterruptedException e) {
            // Обробка переривання потоку під час проживання
            Thread.currentThread().interrupt();
            System.out.printf("[%s] %s перервано під час проживання.%n", System.currentTimeMillis(), guestName);
        } finally {
            // Незалежно від того, чи було переривання чи ні, заявка повинна виселитися
            hotel.checkOut(this);
        }
    }
}