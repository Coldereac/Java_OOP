package Prakt_9.Ver_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library implements Serializable {
    private String name;
    private transient List<Book> books;
    private transient List<Reader> readers;
    @Serial
    private static final long serialVersionUID = 1L;

    public Library() {
        this("", new ArrayList<>(), new ArrayList<>());
    }

    public Library(String name, List<Book> books, List<Reader> readers) {
        this.name = name;
        this.books = books;
        this.readers = readers;
    }

    @Serial
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(books.size());
        writeBooks(out, books);
        out.writeInt(readers.size());
        for (Reader reader : readers) {
            out.writeUTF(reader.getFirstName());
            out.writeUTF(reader.getLastName());
            out.writeUTF(reader.getRegistrationNumber());
            out.writeInt(reader.getBorrowedBooks().size());
            writeBooks(out, reader.getBorrowedBooks());
        }
    }

    private void writeBooks(ObjectOutputStream out, List<Book> books) throws IOException {
        for (Book book : books) {
            out.writeUTF(book.getTitle());
            out.writeInt(book.getAuthors().size());
            for (Author author : book.getAuthors()) {
                out.writeUTF(author.getFirstName());
                out.writeUTF(author.getLastName());
            }
            out.writeInt(book.getYear());
            out.writeInt(book.getEditionNumber());
        }
    }

    @Serial
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int bookSize = in.readInt();
        books = new ArrayList<>(bookSize);
        readBooks(in, bookSize, books);
        int readersSize = in.readInt();
        readers = new ArrayList<>(readersSize);
        for (int i = 0; i < readersSize; i++) {
            String firstName = in.readUTF();
            String lastName = in.readUTF();
            String registrationNumber = in.readUTF();
            int borrowedBooksSize = in.readInt();
            List<Book> borrowedBooks = new ArrayList<>(borrowedBooksSize);
            readBooks(in, borrowedBooksSize, borrowedBooks);
            readers.add(new Reader(firstName, lastName, registrationNumber, borrowedBooks));
        }
    }

    private void readBooks(ObjectInputStream in, int bookSize, List<Book> books) throws IOException {
        for (int i = 0; i < bookSize; i++) {
            String title = in.readUTF();
            int authorsSize = in.readInt();
            List<Author> authors = new ArrayList<>(authorsSize);
            for (int j = 0; j < authorsSize; j++) {
                String firstName = in.readUTF();
                String lastName = in.readUTF();
                authors.add(new Author(firstName, lastName));
            }
            int year = in.readInt();
            int editionNumber = in.readInt();
            books.add(new Book(title, authors, year, editionNumber));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public void addBooks(Book... booksToAdd) {
        Collections.addAll(books, booksToAdd);
    }

    public void removeBooks(Book... booksToRemove) {
        books.removeAll(List.of(booksToRemove));
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void removeReader(Reader reader) {
        readers.remove(reader);
    }

    public void lendBook(Reader reader, Book book) {
        if (books.contains(book) && readers.contains(reader)) {
            reader.borrowBook(book);
        }
    }

    public void returnBook(Reader reader, Book book) {
        if (readers.contains(reader) && reader.getBorrowedBooks().contains(book)) {
            reader.returnBook(book);
        }
    }

    @Override
    public String toString() {
        return "Library{" + "name='" + name + '\'' + ", books=" + books + ", readers=" + readers + '}';
    }
} 