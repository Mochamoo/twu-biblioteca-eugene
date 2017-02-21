package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryManagementSystemTest {
    private LibraryManagementSystem libSystem;

    @Before
    public void setup() {
        libSystem = new LibraryManagementSystem();
    }

    @Test
    public void displayBookListShouldShowAllTitlesAuthorsAndPublishYear() {
        assertEquals("Title | Author | Year Published\n" +
                     "Introduction to the Design & Analysis of Algorithm | Anany Levitin | 2012\n" +
                     "Gears of War: Anvil Gate | Karen Travis | 2010\n" +
                     "Artificial Intelligence: A Modern Approach | Peter Norvig | 2010\n" +
                     "Test-Driven Development | Kent Beck | 2003\n", libSystem.displayBooks());
    }

    @Test
    public void checkoutBookShouldDisplayThankYouMessageOnSuccessfulCheckout() {
        assertEquals("Thank you! Enjoy the book.", libSystem.checkoutBook());
    }
}