package Prakt_8;

import Prakt_1.Point;

import java.util.*;

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

public class ArrayList_Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ArrayList
        //a) Заповнити колекцію випадковими даними (забезпечити
        //наявність однакових елементів).
        ArrayList<Point> list = generateRandomList(10);
        System.out.println("ArrayList before removal: ");
        //b) Вивести вміст колекції за допомогою foreach.
        printCollection(list);

        //c) Обійти колекцію за допомогою ітератора і при обході видалити
        //всі елементи (задати з клавіатури, бажано ті які повторюються).
        System.out.println("Enter x coordinate to remove from ArrayList: ");
        double xToRemove = scanner.nextDouble();
        System.out.println("Enter y coordinate to remove from ArrayList: ");
        double yToRemove = scanner.nextDouble();
        removeElementsWithIterator(list, new Point(xToRemove, yToRemove));
        System.out.println("ArrayList after removal: ");
        printCollection(list);

        //d) Протестувати методи колекції (будь-які на ваш розсуд і в
        //залежності від конкретної колекції).
        System.out.println("Does Arraylist contains Point(2, -3)?: " + (list.contains(new Point(2, -3))));
        java.util.ArrayList<Point> list2 = new ArrayList<>();
        Collections.copy(list, list2);
        list2.clear();
        System.out.println("Is list2 empty?: " + list2.isEmpty());

        //e) Протестувати алгоритми сортування та пошуку класу Collections.
        //Binary search in not sorted ArrayList
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

        //Sort
        Collections.sort(list);
        System.out.println("ArrayList after sorting: ");
        printCollection(list);

        // Binary search in sorted ArrayList
        System.out.println("Enter x coordinate to search: ");
        xToSearch = scanner.nextDouble();
        System.out.println("Enter y coordinate to search: ");
        yToSearch = scanner.nextDouble();
        pointToSearch = new Point(xToSearch, yToSearch);
        searchResult = Collections.binarySearch(list, pointToSearch);
        if (searchResult >= 0) {
            System.out.println("Point found at index: " + searchResult);
        } else {
            System.out.println("Point not found. Insertion point would be: " + (-searchResult - 1));
        }
    }

    public static java.util.ArrayList<Point> generateRandomList(int size) {
        java.util.ArrayList<Point> list = new ArrayList<>(size);
        Random rand = new Random();
        for (int i = 0; i < size - 1; i++) {
            list.add(new Point(rand.nextInt(-10, 10), rand.nextInt(-10, 10)));
        }
        // Впевнимося що є дублікат
        list.add(list.get(1));
        return list;
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
