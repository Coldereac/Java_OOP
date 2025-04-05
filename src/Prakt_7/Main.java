package Prakt_7;

/*
Протестувати методи рефлексії на типі String:
a) отримати об'єкт Class трьома різними способами;
b) вивести усі модифікатори класу String;
c) вивести інформацію про всіх public конструктори класу String;
d) вивести інформацію про всі поля класу String;
e) вивести інформацію про всі public методи класу String;
f) викликати будь-який із методів та роздрукувати результат.
 */

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //отримати об'єкт Class трьома різними способами
        Class<?> string1 = String.class;
        Class<?> string2 = "Hallo".getClass();
        Class<?> string3 = Class.forName("java.lang.String");

        //вивести усі модифікатори класу String
        System.out.println("Модифікатори String: " + Modifier.toString(string1.getModifiers()) + "\n");

        // вивести інформацію про всіх public конструктори класу String
        System.out.println("Усі public конструктори String: ");
        Constructor<?>[] constructors = string1.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();

        //вивести інформацію про всі поля класу String;
        System.out.println("Усі поля  String: ");
        Field[] fields = string1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();

        //вивести інформацію про всі public методи класу String
        System.out.println("Усі public методи String: ");
        Method[] methods = string1.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();

        //викликати будь-який із методів та роздрукувати результат
        String str = "          Hello, World!               ";
        System.out.println("str = " + str);
        System.out.println("Спробуем метод trim:");
        System.out.println("str = " + str.trim());

        System.out.println();

        Class<?> clazz = ClassWithPrivateMethod.class;
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Field field = clazz.getDeclaredField("message");
        field.setAccessible(true);
        field.set(obj, "Modified message");

        Method method = clazz.getDeclaredMethod("printMessage");
        method.setAccessible(true);
        method.invoke(obj);
    }
}