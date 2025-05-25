package Indiv_4;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(2); // Готель на 2 місця для наочної демонстрації очікування

        // Створюємо та запускаємо заявки з проміжками часу
        AccommodationRequest request1 = new AccommodationRequest("Олександр", 3000, hotel);
        request1.startAccommodation(); // Запуск першої заявки

        try {
            Thread.sleep(500); // Невеликий проміжок
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        AccommodationRequest request2 = new AccommodationRequest("Марія", 4000, hotel);
        request2.startAccommodation(); // Запуск другої заявки

        try {
            Thread.sleep(1000); // Ще один проміжок, щоб показати очікування
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        AccommodationRequest request3 = new AccommodationRequest("Іван", 2000, hotel);
        request3.startAccommodation(); // Ця заявка буде чекати

        try {
            Thread.sleep(500); // Ще один проміжок
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        AccommodationRequest request4 = new AccommodationRequest("Олена", 3500, hotel);
        request4.startAccommodation(); // Ця заявка також буде чекати
    }
}
