package Indiv_3;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TicketViewer {

    private static final String INPUT_FILE = "tickets_input.txt";
    private static final String OUTPUT_FILE = "tickets_output.txt";

    public static void main(String[] args) {
        TreeMap<Ticket, String> tickets = new TreeMap<>();

        // 1. Зчитування даних з файлу та заповнення TreeMap
        readTicketsFromFile(tickets, INPUT_FILE);
        writeToOutputFile("--- Початковий вміст TreeMap ---", true); // Очищаємо файл перед записом
        printMap(tickets);

        // 2. Введення ключа з клавіатури, визначення наявності та друк значення
        Scanner scanner = new Scanner(System.in);
        writeToOutputFile("\n--- Пошук квитка ---");
        System.out.println("Введіть дату події (YYYY-MM-DD):");
        String dateStr = scanner.nextLine();
        System.out.println("Введіть номер ряду:");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.println("Введіть номер місця:");
        int seat = Integer.parseInt(scanner.nextLine());

        try {
            LocalDate searchDate = LocalDate.parse(dateStr);
            Ticket searchTicket = new Ticket(searchDate, row, seat);

            if (tickets.containsKey(searchTicket)) {
                String buyer = tickets.get(searchTicket);
                writeToOutputFile("Квиток знайдено! Покупець: " + buyer);
            } else {
                writeToOutputFile("Квиток не знайдено.");
            }
        } catch (DateTimeParseException e) {
            writeToOutputFile("Некоректний формат дати. Будь ласка, використовуйте YYYY-MM-DD.");
        } catch (NumberFormatException e) {
            writeToOutputFile("Некоректний формат для ряду або місця. Будь ласка, введіть число.");
        }


        // 3. Отримання та друк множини ключів TreeMap
        writeToOutputFile("\n--- Множина ключів TreeMap ---");
        Set<Ticket> keySet = tickets.keySet();
        printKeySet(keySet);

        // 4. Видалення значення за ключем (вводити з клавіатури)
        writeToOutputFile("\n--- Видалення квитка ---");
        System.out.println("Введіть дату події для видалення (YYYY-MM-DD):");
        dateStr = scanner.nextLine();
        System.out.println("Введіть номер ряду для видалення:");
        row = Integer.parseInt(scanner.nextLine());
        System.out.println("Введіть номер місця для видалення:");
        seat = Integer.parseInt(scanner.nextLine());

        try {
            LocalDate deleteDate = LocalDate.parse(dateStr);
            Ticket deleteTicket = new Ticket(deleteDate, row, seat);

            if (tickets.containsKey(deleteTicket)) {
                String removedBuyer = tickets.remove(deleteTicket);
                writeToOutputFile("Квиток видалено: " + deleteTicket + ", Покупець: " + removedBuyer);
            } else {
                writeToOutputFile("Квиток для видалення не знайдено.");
            }
        } catch (DateTimeParseException e) {
            writeToOutputFile("Некоректний формат дати. Будь ласка, використовуйте YYYY-MM-DD.");
        } catch (NumberFormatException e) {
            writeToOutputFile("Некоректний формат для ряду або місця. Будь ласка, введіть число.");
        }


        // Роздрукувати TreeMap після видалення та множину ключів
        writeToOutputFile("\n--- TreeMap після видалення ---");
        printMap(tickets);

        writeToOutputFile("\n--- Множина ключів після видалення (та сама, що пов'язана з TreeMap) ---");
        printKeySet(keySet); // Роздрукувати ту саму множину ключів, щоб побачити зміни

        scanner.close();
        System.out.println("Результати збережено у файл " + OUTPUT_FILE);
    }

    private static void readTicketsFromFile(TreeMap<Ticket, String> tickets, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        LocalDate eventDate = LocalDate.parse(parts[0].trim());
                        int row = Integer.parseInt(parts[1].trim());
                        int seat = Integer.parseInt(parts[2].trim());
                        String buyerName = parts[3].trim();

                        Ticket ticket = new Ticket(eventDate, row, seat);
                        tickets.put(ticket, buyerName);
                    } catch (DateTimeParseException e) {
                        writeToOutputFile("Помилка парсингу дати в рядку: " + line + " - " + e.getMessage());
                    } catch (NumberFormatException e) {
                        writeToOutputFile("Помилка парсингу числа в рядку: " + line + " - " + e.getMessage());
                    }
                } else {
                    writeToOutputFile("Некоректний формат рядка у файлі: " + line);
                }
            }
        } catch (IOException e) {
            writeToOutputFile("Помилка читання файлу " + filename + ": " + e.getMessage());
        }
    }

    private static void printMap(TreeMap<Ticket, String> tickets) {
        if (tickets.isEmpty()) {
            writeToOutputFile("TreeMap порожній.");
            return;
        }
        for (Map.Entry<Ticket, String> entry : tickets.entrySet()) {
            writeToOutputFile(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static void printKeySet(Set<Ticket> keySet) {
        if (keySet.isEmpty()) {
            writeToOutputFile("Множина ключів порожня.");
            return;
        }
        for (Ticket ticket : keySet) {
            writeToOutputFile(ticket.toString());
        }
    }

    private static void writeToOutputFile(String content) {
        writeToOutputFile(content, false);
    }

    private static void writeToOutputFile(String content, boolean clearFile) {
        try (FileWriter fw = new FileWriter(OUTPUT_FILE, !clearFile);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(content);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Помилка запису у файл " + OUTPUT_FILE + ": " + e.getMessage());
        }
    }
}