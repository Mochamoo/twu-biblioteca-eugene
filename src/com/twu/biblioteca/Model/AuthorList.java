package com.twu.biblioteca.Model;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class AuthorList {
    private ArrayList<Author> authorList;

    public AuthorList() {
        authorList = new ArrayList<Author>();
    }

    public void addNewAuthor(Author author) {
        authorList.add(author);
    }

    public AuthorList(Author... author) {
        authorList = new ArrayList<Author>();

        for(Author eachAuthor : author) {
            authorList.add(eachAuthor);
        }
    }

    public String getAuthorNames() {
        ArrayList<String> authorNames = new ArrayList<String>();

        for(Author eachAuthor : authorList) {
            authorNames.add(eachAuthor.getFullName());
        }

        return StringUtils.join(authorNames, ", ");
    }

    public int getNumberOfAuthors() {
        return authorList.size();
    }
}
