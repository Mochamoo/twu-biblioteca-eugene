package com.twu.biblioteca.Model;

public class Director {
    Name name;

    public Director(String firstName, String lastName) {
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
