package Prakt_6;

/*
Розробити інтерфейс Iterator (два методи hasNext та next) по масиву
будь якого типу (можна тип вказати явно, а можна створити
шаблонний інтерфейс).
Для класу n-вимірного вектора із завдання 2, реалізувати інтерфейс
Iterator різними способами, зокрема з допомогою внутрішніх класів,
anonymous внутрішніх класів, локальних внутрішніх класів. Порівняти
реалізації інтерфейсу та вибрати найбільш підходящий спосіб. Вибір
обґрунтувати.
 */

import Prakt_2.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Inner realisation");
        Vector_Inner v = new Vector_Inner(2.0, 3.0, 3.9, -7.2);
        Iterator<Double> i = v.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println("Testing Anonymous realisation");
        Vector_Anonymous v2 = new Vector_Anonymous(2.0, 3.0, 3.9, -7.2);
        Iterator<Double> i2 = v2.iterator();
        while (i2.hasNext()) {
            System.out.println(i2.next());
        }

        System.out.println("Testing Local realisation");
        Vector_Local v3 = new Vector_Local(2.0, 3.0, 3.9, -7.2);
        Iterator<Double> i3 = v3.iterator();
        while (i3.hasNext()) {
            System.out.println(i3.next());
        }
    }
}
