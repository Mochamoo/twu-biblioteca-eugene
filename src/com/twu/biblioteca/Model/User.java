package com.twu.biblioteca.Model;

public class User {
    private Name name;
    private String email;
    private String phoneNumber;
    private String username;
    private String hash;

    public User(Name name, String email, String phoneNumber,
                String username, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.hash = password;
    }

    public String getUsername() {
        return username;
    }

    public String getHash() {
        return hash;
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
