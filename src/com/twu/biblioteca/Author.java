package com.twu.biblioteca;

public class Author {
    private String fname;
    private String lname;

    public Author(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
}
