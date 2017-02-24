package com.twu.biblioteca.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameTest {
    Name name;

    @Before
    public void setup() {
        name = new Name("Bojack", "Horseman");
    }

    @Test
    public void getFirstNameShouldReturnFirstNameAsString() {
        assertEquals("Bojack", name.getFirstName());
    }

    @Test
    public void getLastNameShouldReturnLastNameAsString() {
        assertEquals("Horseman", name.getLastName());
    }

    @Test
    public void getFullNameShouldReturnFirstNameAndLastNameWithSpaceInBetween() {
        assertEquals("Bojack Horseman", name.getFullName());
    }
}