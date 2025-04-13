package Prakt_9.Ver_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Book implements Externalizable {
    private String title;
    private List<Author> authors;
    private int year;
    private int editionNumber;
    @Serial
    private static final long serialVersionUID = 1L;

    public Book() {
        this("", new ArrayList<>(), 0, 0);
    }

    public Book(String title, List<Author> authors, int year, int editionNumber) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.editionNumber = editionNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    @Override
    public String toString() {
        return "\nBook{" + "title='" + title + '\'' + ", authors=" + authors + ", year=" + year + ", editionNumber=" + editionNumber + "}";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(title);
        out.writeInt(authors.size());
        for (Author author : authors) {
            out.writeObject(author);
        }
        out.writeInt(year);
        out.writeInt(editionNumber);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = in.readUTF();
        int size = in.readInt();
        authors = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            authors.add((Author) in.readObject());
        }
        year = in.readInt();
        editionNumber = in.readInt();
    }
}