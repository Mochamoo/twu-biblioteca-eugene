package com.twu.biblioteca;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

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

    public AuthorList(ArrayList<Author> authorList) {
        this.authorList = authorList;
    }

    public void addNewAuthor(Author author) {
        authorList.add(author);
    }

    public String getAuthorNames() {
        ArrayList<String> authorNames = new ArrayList<String>();

        for(Author author : authorList) {
            authorNames.add(author.getFullName());
        }

        return StringUtils.join(authorNames, ", ");
    }

    public int getNumberOfAuthors() {
        return authorList.size();
    }
}
