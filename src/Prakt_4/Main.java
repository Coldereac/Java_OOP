package Prakt_4;

/*
Розробити клас, похідний від класу Point. Протестувати поліморфне
зв'язування.
*/

import Prakt_1.Point;

public class Main {
    public static void main(String[] args) {
        //Тестування поліморфного звʼязування

        //Перевірка конструктора та toString
        Point p1 = new Point_3d(19, 3.7, -94.2);
        System.out.println("p1: " + p1);

        //Перевірка equals
        Point_3d p2 = new Point_3d(19, 3.7, -94.2);
        Point_3d p3 = new Point_3d(20, 3.7, -94.2);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        System.out.println("p1 equals p2: " + p1.equals(p2));
        System.out.println("p1 equals p3: " + p1.equals(p3));

        //Перевірка distance
        p2.setY(-5.6);
        p2.setZ(10);
        System.out.println("Distance between p1 and p2: " + ((Point_3d) p1).getDistance(p2));

        //Перевірка isInSphere
        double r = 10;
        System.out.println("p1 is in sphere with center " + p2 + " and radius " + r + ": " + ((Point_3d) p1).isInSphere(p2, r));
        System.out.println("p1 is in sphere with center " + p3 + " and radius " + r + ": " + ((Point_3d) p1).isInSphere(p3, r));

        //Перевірка scale
        double s = 3;
        p3.scale(s);
        System.out.println("p3 after scaling: " + p3);
    }
}
