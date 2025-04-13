package Prakt_9.Ver_1;

import java.io.Serial;
import java.io.Serializable;

public class Author implements Serializable {
    private String firstName;
    private String lastName;@Serial
    private static final long serialVersionUID = 1L;

    public Author() {
        this("", "");
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
} 