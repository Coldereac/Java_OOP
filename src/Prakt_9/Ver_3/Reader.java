package Prakt_9.Ver_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader implements Externalizable {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(firstName);
        out.writeUTF(lastName);
        out.writeUTF(registrationNumber);
        out.writeInt(borrowedBooks.size());
        for (Book book : borrowedBooks) {
            out.writeObject(book);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        firstName = in.readUTF();
        lastName = in.readUTF();
        registrationNumber = in.readUTF();
        int size = in.readInt();
        borrowedBooks = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            borrowedBooks.add((Book) in.readObject());
        }
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
        return "\nReader{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", registrationNumber='" + registrationNumber + '\'' + ", borrowedBooks=" + borrowedBooks + "}";
    }
} 