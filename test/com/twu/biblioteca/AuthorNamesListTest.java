package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorNamesListTest {
    AuthorNamesList authors;

    @Before
    public void setup() {
        authors = new AuthorNamesList();
    }

    @Test
    public void authorListVarArgsConstructorShouldAcceptMultipleAuthors() {
        authors = new AuthorNamesList(new Name("Diane","Nguyen"),
                                 new Name("Mister", "Peanutbutter"));
        assertEquals(2, authors.getNumberOfAuthors());
    }

    @Test
    public void getAuthorNamesShouldReturnFormattedStringOfAuthors() {
        authors.addNewAuthor(new Name("Diane", "Nguyen"));
        authors.addNewAuthor(new Name("Mister", "Peanutbutter"));
        authors.addNewAuthor(new Name("Margo", "Martindale"));

        assertEquals("Diane Nguyen, Mister Peanutbutter, Margo Martindale",
                authors.getAuthorNames());
    }

}