package Prakt_8;
import Prakt_1.Point;
import java.util.*;

import static Prakt_8.ArrayList_Test.printCollection;
import static Prakt_8.ArrayList_Test.removeElementsWithIterator;

public class TreeSet_Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //a) Заповнити колекцію випадковими даними (забезпечити
        //наявність однакових елементів).
        java.util.TreeSet<Point> set = generateRandomSet(20);
        System.out.println("\nTreeSet before removal: ");
        //b) Вивести вміст колекції за допомогою foreach.
        printCollection(set);

        //c) Обійти колекцію за допомогою ітератора і при обході видалити
        //всі елементи (задати з клавіатури, бажано ті які повторюються).
        System.out.println("Enter x coordinate to remove from TreeSet: ");
        double xToRemove = scanner.nextDouble();
        System.out.println("Enter y coordinate to remove from TreeSet: ");
        double yToRemove = scanner.nextDouble();
        removeElementsWithIterator(set, new Point(xToRemove, yToRemove));
        System.out.println("TreeSet after removal: ");
        printCollection(set);

        //d) Протестувати методи колекції (будь-які на ваш розсуд і в
        //залежності від конкретної колекції).
        java.util.TreeSet<Point> set2 = generateRandomSet(20);
        System.out.println("\nTreeSet2: ");
        printCollection(set2);
        set2.retainAll(set);
        System.out.println("\nAll retain components in two TreeSets: " + set2);

        //Сортування в TreeSet непотрібно, так як Point імплементує інтерфейс Comparable і сам TreeSet додає елементи так,
        //що зберігається сортуваність
        //Binary Search є лише для List, тому для пошуку можна використовувати contains
        System.out.println("Enter x coordinate to search: ");
        double xToSearch = scanner.nextDouble();
        System.out.println("Enter y coordinate to search: ");
        double yToSearch = scanner.nextDouble();
        Point pointToSearch = new Point(xToSearch, yToSearch);
        System.out.println("Does Set contains this point?: " + set.contains(pointToSearch));

        //Якщо ж необхідно використовувати саме метод BinarySearch(наприклад нам потрібен індекс або місце куди б вставився цей елемент)
        //або дуже хочеться використати sort, то можна перетворити Set на List
        java.util.ArrayList<Point> setAsList = new ArrayList<>(set);

        Collections.sort(setAsList);
        System.out.println("TreeSet after sorting: ");
        //Нічого не зміниться
        printCollection(setAsList);

        System.out.println("Enter x coordinate to search in TreeSet: ");
        xToSearch = scanner.nextDouble();
        System.out.println("Enter y coordinate to search in TreeSet: ");
        yToSearch = scanner.nextDouble();
        pointToSearch = new Point(xToSearch, yToSearch);


        int searchResult = Collections.binarySearch(setAsList, pointToSearch);
        if (searchResult >= 0) {
            System.out.println("Point found at index: " + searchResult);
        } else {
            System.out.println("Point not found. Insertion point would be: " + (-searchResult - 1));
        }

        scanner.close();
    }

    public static java.util.TreeSet<Point> generateRandomSet(int size) {
        java.util.TreeSet<Point> set = new TreeSet<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            set.add(new Point(rand.nextInt(-10, 10), rand.nextInt(-10, 10)));
        }
        // Set не дозволяє мати однакові елементи, тому дублікатів не буде
        return set;
    }
}
