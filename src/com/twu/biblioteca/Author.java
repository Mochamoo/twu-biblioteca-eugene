package com.twu.biblioteca;

public class Author {
    private Name authorName;

    public Author(String firstName, String lastName) {
        authorName = new Name(firstName, lastName);
    }

    public String getFirstName() {
        return authorName.getFirstName();
    }

    public String getLastName() {
        return authorName.getLastName();
    }

    public String getFullName() {
        return authorName.getFullName();
    }
}
