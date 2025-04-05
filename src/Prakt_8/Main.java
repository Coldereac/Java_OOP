package Prakt_8;

import Prakt_1.Point;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
/*
8. Протестувати ArrayList та TreeSet на задачі зберігання об'єктів класу
Point. Для кожної колекції виконати таке:
a) Заповнити колекцію випадковими даними (забезпечити
наявність однакових елементів).
b) Вивести вміст колекції за допомогою foreach.
c) Обійти колекцію за допомогою ітератора і при обході видалити
всі елементи (задати з клавіатури, бажано ті які повторюються).
d) Протестувати методи колекції (будь-які на ваш розсуд і в
залежності від конкретної колекції).
e) Протестувати алгоритми сортування та пошуку класу Collections.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ArrayList
        ArrayList<Point> list = generateRandomList(10);
        System.out.println("ArrayList before removal: ");
        printCollection(list);

        System.out.println("Enter x coordinate to remove from ArrayList: ");
        double xToRemove = scanner.nextDouble();
        System.out.println("Enter y coordinate to remove from ArrayList: ");
        double yToRemove = scanner.nextDouble();
        removeElementsWithIterator(list, new Point(xToRemove, yToRemove));
        System.out.println("ArrayList after removal: ");
        printCollection(list);

        System.out.println("Does Arraylist contains Point(2, -3)?: " + (list.contains(new Point(2, -3))));
        ArrayList<Point> list2 = new ArrayList<>();
        Collections.copy(list, list2);
        list2.clear();
        System.out.println("Is list2 empty?: " + list2.isEmpty());

        // Sort the ArrayList
        Collections.sort(list);
        System.out.println("ArrayList after sorting: ");
        printCollection(list);

        // Binary search in sorted ArrayList
        System.out.println("Enter x coordinate to search: ");
        double xToSearch = scanner.nextDouble();
        System.out.println("Enter y coordinate to search: ");
        double yToSearch = scanner.nextDouble();
        Point pointToSearch = new Point(xToSearch, yToSearch);

        int searchResult = Collections.binarySearch(list, pointToSearch);
        if (searchResult >= 0) {
            System.out.println("Point found at index: " + searchResult);
        } else {
            System.out.println("Point not found. Insertion point would be: " + (-searchResult - 1));
        }

        // TreeSet
        TreeSet<Point> set = generateRandomSet(20);
        System.out.println("\nTreeSet before removal: ");
        printCollection(set);

        System.out.println("Enter x coordinate to remove from TreeSet: ");
        xToRemove = scanner.nextDouble();
        System.out.println("Enter y coordinate to remove from TreeSet: ");
        yToRemove = scanner.nextDouble();
        removeElementsWithIterator(set, new Point(xToRemove, yToRemove));
        System.out.println("TreeSet after removal: ");
        printCollection(set);

        TreeSet<Point> set3 = new TreeSet<>(set);
        TreeSet<Point> set2 = generateRandomSet(20);
        System.out.println("\nTreeSet2: ");
        printCollection(set3);
        set3.retainAll(set2);
        System.out.println("\nAll retain components in two TreeSets: " + set3);

        //Методи sort та binarySearch лише для List, тому конвертуємо Set в List
        ArrayList<Point> setAsList = new ArrayList<>(set);

        Collections.sort(setAsList);
        System.out.println("TreeSet after sorting: ");
        printCollection(setAsList);

        System.out.println("Enter x coordinate to search in TreeSet: ");
        xToSearch = scanner.nextDouble();
        System.out.println("Enter y coordinate to search in TreeSet: ");
        yToSearch = scanner.nextDouble();
        pointToSearch = new Point(xToSearch, yToSearch);


        searchResult = Collections.binarySearch(setAsList, pointToSearch);
        if (searchResult >= 0) {
            System.out.println("Point found at index: " + searchResult);
        } else {
            System.out.println("Point not found. Insertion point would be: " + (-searchResult - 1));
        }

        scanner.close();
    }

    public static ArrayList<Point> generateRandomList(int size) {
        ArrayList<Point> list = new ArrayList<>(size);
        Random rand = new Random();
        for (int i = 0; i < size - 1; i++) {
            list.add(new Point(rand.nextInt(-10, 10), rand.nextInt(-10, 10)));
        }
        // Впевнимося що є дублікат
        list.add(list.get(1));
        return list;
    }

    public static TreeSet<Point> generateRandomSet(int size) {
        TreeSet<Point> set = new TreeSet<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            set.add(new Point(rand.nextInt(-10, 10), rand.nextInt(-10, 10)));
        }
        // Set не дозволяє мати однакові елементи, тому дублікатів не буде
        return set;
    }

    public static void printCollection(Collection<?> collection) {
        for (Object object : collection) {
            System.out.println(object);
        }
    }

    public static <T> void removeElementsWithIterator(Collection<T> collection, T elementToRemove) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(elementToRemove)) {
                iterator.remove();
            }
        }
    }
}
