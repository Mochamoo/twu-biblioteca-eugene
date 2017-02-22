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
    public void getFirstNameShouldReturnAuthorFirstName() {
        assertEquals("Bojack", author.getFirstName());
    }

    @Test
    public void getLastNameShouldReturnAuthorLastName() {
        assertEquals("Horseman", author.getLastName());
    }

    @Test
    public void getFullNameShouldReturnFirstNameAndLastNameWithSpaceInBetween() {
        assertEquals("Bojack Horseman", author.getFullName());
    }

}