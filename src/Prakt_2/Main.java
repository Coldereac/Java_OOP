package Prakt_2;

/*
Розробити клас для роботи з n-вимірним вектором (задається як масив
координат типу double), забезпечити розумну поведінку (обчислення
довжини (норми) вектора, отримання установка елементів, виведення
на екран, нормалізація вектора, ...), конструктор копії. Протестувати клас на об'єктах.
*/

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(10, 20);
        System.out.println("Новий вектор: ");
        System.out.println(vector);
        Vector vector2 = new Vector(vector);
        System.out.println("Тестування конструктора копії: ");
        System.out.println(vector2);
        vector.setCoords(90, 9.3, -4);
        System.out.println("Встановлення нових координат до старого вектора: ");
        System.out.println(vector);
        System.out.println("Перевірка, що створенний через копіювання вектор не змінився: ");
        System.out.println(vector2);
        System.out.println("Норма вектора: ");
        System.out.println(vector.norm());
        System.out.println("Нормалізований вектор: ");
        Vector normalizedVecor = vector.normalize();
        System.out.println(normalizedVecor);
        System.out.println("Норма нормалізованого вектора: ");
        System.out.println(normalizedVecor.norm());
        System.out.println("Зміна одної координати по індексу 1 на 10: ");
        vector2.setCoords(1, 10);
        System.out.println(vector2);
        System.out.println("Перевірка, що отримується помилка при індексі за межами: ");
        try{
            vector2.setCoords(10, 10);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        Vector vector3 = new Vector();
        System.out.println("Перевірка конструктора без параметрів: ");
        System.out.println(vector3);
        System.out.println("Норма нового вектора: ");
        System.out.println(vector3.norm());
        System.out.println("Перевірка, що отримується помилка при нормалізції при нульовій нормі: ");
        try{
            vector3.normalize();
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
