package Prakt_9.Ver_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryDriver {
    public static void serializeLibrary(Library library, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(library);
            System.out.println("Library serialized successfully to " + filename);
        } catch (IOException e) {
            System.err.println("Error serializing library: " + e.getMessage());
        }
    }

    public static Library deserializeLibrary(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Library library = (Library) in.readObject();
            System.out.println("Library deserialized successfully from " + filename);
            return library;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing library: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.setName("Central Library");

        Author author1 = new Author("Danylo", "Smith");
        Author author2 = new Author("Jane", "Doe");

        Book book1 = new Book("Java Programming", List.of(author1), 2014, 1);

        Book book2 = new Book("Python Basics", List.of(author2), 2019, 2);

        Book book3 = new Book("Scala for Beginners", List.of(author1, author2), 2023, 6);

        library.addBooks(book1, book2, book3);

        Reader reader1 = new Reader("Alice", "Johnson", "R001", new ArrayList<>());
        Reader reader2 = new Reader("Bob", "Williams", "R002", new ArrayList<>());

        library.addReader(reader1);
        library.addReader(reader2);

        library.lendBook(reader1, library.getBooks().getFirst());
        library.lendBook(reader2, library.getBooks().get(1));
        library.lendBook(reader2, library.getBooks().getLast());
        System.out.println("Library before serialization: " + library);

        serializeLibrary(library, "library.save");

        Library deserializedLibrary = deserializeLibrary("library.save");

        if (deserializedLibrary != null) {
            System.out.println("Deserialized Library:");
            System.out.println(deserializedLibrary);
        }
    }
} 