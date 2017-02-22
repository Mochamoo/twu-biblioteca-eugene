package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorTest {
    Author author;

    @Before
    public void setUp() throws Exception {
        author = new Author("Bojack", "Horseman");
    }

    @Test
    public void getFNameShouldReturnAuthorFirstName() {
        assertEquals("Bojack", author.getFirstName());
    }

    @Test
    public void getLNameShouldReturnAuthorLastName() {
        assertEquals("Horseman", author.getLastName());
    }

}