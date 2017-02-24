package com.twu.biblioteca;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class AuthorNamesList {
    private ArrayList<Name> authorList;

    public AuthorNamesList() {
        authorList = new ArrayList<Name>();
    }

    public AuthorNamesList(Name... name) {
        authorList = new ArrayList<Name>();

        for(Name nameOfAuthor : name) {
            authorList.add(nameOfAuthor);
        }
    }

    public void addNewAuthor(Name name) {
        authorList.add(name);
    }

    public String getAuthorNames() {
        ArrayList<String> authorNames = new ArrayList<String>();

        for(Name nameOfAuthor : authorList) {
            authorNames.add(nameOfAuthor.getFullName());
        }

        return StringUtils.join(authorNames, ", ");
    }

    public int getNumberOfAuthors() {
        return authorList.size();
    }
}
