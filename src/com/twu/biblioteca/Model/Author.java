package com.twu.biblioteca.Model;

public class Author {
    Name name;

    public Author(String firstName, String lastName) {
        name = new Name(firstName, lastName);
    }

    public String getFullNameInString() {
        return name.getFullName();
    }
}
