package Prakt_9.Ver_1;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    private String title;
    private List<Author> authors;
    private int year;
    private int editionNumber;@Serial
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
        return "\nBook{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", year=" + year +
                ", editionNumber=" + editionNumber +
                "}";
    }
} 