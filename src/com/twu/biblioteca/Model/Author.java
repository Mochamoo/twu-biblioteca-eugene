package com.twu.biblioteca.Model;

public class Author {
    Name name;

    public Author(String firstName, String lastName) {
        name = new Name(firstName, lastName);
    }

    public String getFirstName() {
        return name.getFirstName();
    }

    public String getLastName() {
        return name.getLastName();
    }

    public String getFullName() {
        return name.getFullName();
    }
}
