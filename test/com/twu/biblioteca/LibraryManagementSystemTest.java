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
                     "1) Introduction to the Design & Analysis of Algorithm | Anany Levitin | 2012\n" +
                     "2) Gears of War: Anvil Gate | Karen Travis | 2010\n" +
                     "3) Artificial Intelligence: A Modern Approach | Peter Norvig | 2010\n" +
                     "4) Test-Driven Development | Kent Beck | 2003\n", libSystem.displayBooks());
    }

    @Test
    public void checkoutBookShouldDisplayThankYouMessageOnSuccessfulCheckout() {
        assertEquals("Thank you! Enjoy the book.", libSystem.checkoutBook());
    }
}