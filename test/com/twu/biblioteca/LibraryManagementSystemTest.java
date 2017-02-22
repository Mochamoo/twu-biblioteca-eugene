package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class LibraryManagementSystemTest {
    private LibraryManagementSystem libSystem;
    ByteArrayInputStream in;

    @Before
    public void setup() {
        libSystem = new LibraryManagementSystem();
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void displayBookListShouldShowAllTitlesAuthorsAndPublishYear() {
        assertEquals("Title | Author | Year Published\n" +
                     "Test-Driven Development | Kent Beck | 2003\n" +
                     "Gears of War: Anvil Gate | Karen Travis | 2010\n" +
                     "Artificial Intelligence: A Modern Approach | Peter Norvig | 2010\n" +
                     "Introduction to the Design & Analysis of Algorithm | Anany Levitin | 2012\n",
                     libSystem.displayBooks());
    }

    @Test
    public void chooseBookToCheckoutShouldReturnTrueIfBookExists() {
        ByteArrayInputStream in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        assertEquals(true, libSystem.chooseBookToCheckout());
    }

    @Test
    public void chooseBookToCheckoutShouldReturnFalseIfBookDoesNotExist() {
        ByteArrayInputStream in = new ByteArrayInputStream("Non-existent book".getBytes());
        System.setIn(in);
        assertEquals(false, libSystem.chooseBookToCheckout());
    }

    @Test
    public void checkoutBookShouldDisplayThereAreNoBooksIfAllBooksAreBorrowed() {
        ByteArrayInputStream in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Introduction to the Design & Analysis of Algorithm".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Artificial Intelligence: A Modern Approach".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Test-Driven Development".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        assertEquals("There are currently no books available.\n", libSystem.checkoutBook());
    }

    @Test
    public void checkoutBookShouldDisplayThankYouMessageOnSuccessfulCheckout() {
        ByteArrayInputStream in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        assertEquals("Thank you! Enjoy the book.\n", libSystem.checkoutBook());
    }

    @Test
    public void checkoutBookShouldDisplayBookNotFoundMsgOnUnsuccessfulCheckout() {
        ByteArrayInputStream in = new ByteArrayInputStream("Non-existent book".getBytes());
        System.setIn(in);
        assertEquals("That book is not available.\n", libSystem.checkoutBook());
    }

    @Test
    public void chooseBookToReturnShouldReturnTrueIfBookExists() {
        ByteArrayInputStream in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        assertEquals(true, libSystem.chooseBookToReturn());
    }

    @Test
    public void chooseBookToReturnShouldReturnFalseIfBookDoesNotExists() {
        ByteArrayInputStream in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Goats of War: Manvil Grate".getBytes());
        System.setIn(in);
        assertEquals(false, libSystem.chooseBookToReturn());
    }

    @Test
    public void returnBookShouldDisplayThankYouMsgOnSuccessfulReturn() {
        ByteArrayInputStream in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        assertEquals("Thank you for returning the book.\n", libSystem.returnBook());
    }

    @Test
    public void returnBookShouldDisplayBookNotValidOnUnsuccessfulReturn() {
        ByteArrayInputStream in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Goats of War: Manvil Grate".getBytes());
        System.setIn(in);
        assertEquals("That is not a valid book to return.\n", libSystem.returnBook());
    }

    @Test
    public void returnBookShouldDeclareNoBooksToReturnIfNoneAreBorrowed() {
        assertEquals("There are currently no books being borrowed.\n", libSystem.returnBook());
    }

}