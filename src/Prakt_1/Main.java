package Prakt_1;

/*
Розробити та протестувати клас Point. Реалізувати метод перевірки
належності точки колу з центром в заданій точці та заданого радіусу.
Перевизначити методи toString та equals.
В main створити масив об'єктів цього класу, задати довільно
координати (зробити так, щоб координати повторювалися) та вивести
ті з них, які потрапили всередину кола з центром у точці (1, 2) та
радіусом 5.
З клавіатури ввести довільну точку та підрахувати кількість точок у
масиві рівних заданій.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Point[] points = {
                new Point(10, 20),
                new Point(2.3, 4.5),
                new Point(1, 1),
                new Point(2.3, 6),
                new Point(10, 5),
                new Point(1, 1)
        };
        System.out.println("All points: "); //Show all points
        for (Point point : points) {
            System.out.println(point);
        }
        System.out.println();

        Point center = new Point(1, 2);
        double radius = 5;
        System.out.println("Points in circle: "); //Show points only in circle
        for (Point point : points) {
            if (point.isInCircle(center, radius)) {
                System.out.println(point);
            }
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter point coordinates: ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        Point pointScanned = new Point(x, y);
        System.out.println("Point scanned: " + pointScanned); //Points in array equal to scanned point
        int count = 0;
        for (Point point : points) {
            if (point.equals(pointScanned)) {
                count++;
            }
        }
        System.out.println("Count of points equal scanned point: " + count);
        System.out.println();
    }
}
