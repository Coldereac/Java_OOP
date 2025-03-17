package Prakt_5;
/*
Розробити абстрактний клас Figure з двома абстрактними методами –
підрахунок площі фігури та периметру. Успадкувати від нього класи
Rectangle (прямокутник), Circle (коло) та Triangle (трикутник). У класі
Rectangle створити додатковий метод обчислення довжини діагоналі.
В main створити масив різних фігур та забезпечити обчислення
периметра та площі кожної фігури залежно від її типу. А для фігур
типу Rectangle також вивести довжину діагоналі.
 */

public class Main {
    public static void main(String[] args) {
        //перевірка викидування exceptions у конструкторах
        System.out.println("Testing throwing exceptions in constructors:");
        System.out.println("Circle: ");
        try {
            Circle circle = new Circle(-5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTriangle: ");
        try {
            Triangle triangle = new Triangle(-5, 10, -5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Triangle triangle = new Triangle(1, 1, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nRectangle: ");
        try {
            Rectangle rectangle = new Rectangle(-5, -4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nSquare: ");
        try {
            Square square = new Square(-5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        Figure[] figures = {new Circle(20), new Triangle(7, 3, 9), new Rectangle(5, 10), new Square(9), new RectangularPrism(7, 2, 9), new Cube(6)};
        //Перевірка методів периметра та площі для кожного, а також діагоналі для прямокутника

        for (Figure figure : figures) {
            figure.print();
        }
    }
}
