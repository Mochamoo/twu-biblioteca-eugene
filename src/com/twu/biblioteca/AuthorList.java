package com.twu.biblioteca;

import java.util.ArrayList;

public class AuthorList {
    private ArrayList<Author> authorList;

    public AuthorList() {
        authorList = new ArrayList<Author>();
    }

    public AuthorList(Author... author) {
        authorList = new ArrayList<Author>();

        for(Author newAuthor : author) {
            authorList.add(newAuthor);
        }
    }

    public void addNewAuthor(Author author) {
        authorList.add(author);
    }

    public String getAuthorNames() {
        StringBuilder authorNames = new StringBuilder();

        for(Author author : authorList) {
            authorNames.append(author.getFirstName());
            authorNames.append(" ");
            authorNames.append(author.getLastName());
            authorNames.append(", ");
        }
        authorNames.deleteCharAt(authorNames.length() - 1);
        authorNames.deleteCharAt(authorNames.length() - 1);

        return authorNames.toString();
    }
}
