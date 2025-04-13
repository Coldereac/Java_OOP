package Prakt_9.Ver_1;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Library implements Serializable {
    private String name;
    private List<Book> books;
    private List<Reader> readers;
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