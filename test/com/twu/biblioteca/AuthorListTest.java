package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AuthorListTest {
    AuthorList authors;

    @Before
    public void setup() {
        authors = new AuthorList();
    }

    @Test
    public void authorListVarArgsConstructorShouldAcceptMultipleAuthors() {
        authors = new AuthorList(new Author("Diane","Nguyen"),
                                 new Author("Mister", "Peanutbutter"));
        assertEquals(2, authors.getNumberOfAuthors());
    }

    @Test
    public void getAuthorNamesShouldReturnFormattedStringOfAuthors() {
        authors.addNewAuthor(new Author("Diane", "Nguyen"));
        authors.addNewAuthor(new Author("Mister", "Peanutbutter"));
        authors.addNewAuthor(new Author("Margo", "Martindale"));

        assertEquals("Diane Nguyen, Mister Peanutbutter, Margo Martindale",
                authors.getAuthorNames());
    }

}