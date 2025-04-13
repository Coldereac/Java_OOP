package Prakt_9.Ver_1;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Reader implements Serializable {
    private String firstName;
    private String lastName;
    private String registrationNumber;
    private List<Book> borrowedBooks;
    @Serial
    private static final long serialVersionUID = 1L;

    public Reader() {
        this("", "", "", new ArrayList<>());
    }

    public Reader(String firstName, String lastName, String registrationNumber, List<Book> borrowedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationNumber = registrationNumber;
        this.borrowedBooks = borrowedBooks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "\nReader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                "}";
    }
} 