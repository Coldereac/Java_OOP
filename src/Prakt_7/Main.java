package Prakt_7;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        try {
            // a) Getting Class object in three different ways
            Class<?> stringClass1 = String.class;
            Class<?> stringClass2 = Class.forName("java.lang.String");
            String str = "test";
            Class<?> stringClass3 = str.getClass();
            
            System.out.println("a) Three ways to get Class object:");
            System.out.println("1. String.class: " + stringClass1.getName());
            System.out.println("2. Class.forName(): " + stringClass2.getName());
            System.out.println("3. getClass(): " + stringClass3.getName());
            System.out.println();

            // b) Printing class modifiers
            System.out.println("b) Class modifiers:");
            int modifiers = stringClass1.getModifiers();
            System.out.println("Modifiers: " + Modifier.toString(modifiers));
            System.out.println();

            // c) Printing public constructors
            System.out.println("c) Public constructors:");
            Constructor<?>[] constructors = stringClass1.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Constructor: " + constructor);
            }
            System.out.println();

            // d) Printing all fields
            System.out.println("d) All fields:");
            Field[] fields = stringClass1.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Field: " + field);
            }
            System.out.println();

            // e) Printing public methods
            System.out.println("e) Public methods:");
            Method[] methods = stringClass1.getMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method);
            }
            System.out.println();

            // f) Invoking a method and printing result
            System.out.println("f) Invoking method and printing result:");
            String testString = "Hello, Reflection!";
            Method toUpperCaseMethod = stringClass1.getMethod("toUpperCase");
            String result = (String) toUpperCaseMethod.invoke(testString);
            System.out.println("Original string: " + testString);
            System.out.println("Result of toUpperCase(): " + result);

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
