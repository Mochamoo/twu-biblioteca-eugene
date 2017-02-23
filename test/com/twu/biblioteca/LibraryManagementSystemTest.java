package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class LibraryManagementSystemTest {
    private LibraryManagementSystem libSystem;
    private ByteArrayInputStream in;

    @Before
    public void setup() {
        libSystem = new LibraryManagementSystem();
        libSystem.addBook(new Book("Test-Driven Development",
                new AuthorList(new Author("Kent", "Beck")),
                2003));

        libSystem.addBook(new Book("Gears of War: Anvil Gate",
                new AuthorList(new Author("Karen", "Travis")),
                2010));
        libSystem.addBook(new Book("Artificial Intelligence: A Modern Approach",
                new AuthorList(new Author("Peter", "Norvig")),
                2010));
        libSystem.addBook(new Book("Introduction to the Design & Analysis of Algorithm",
                new AuthorList(new Author("Anany", "Levitin")),
                2012));
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void addBookShouldPutNewBookIntoAvailableBookList() {
        assertEquals(4, libSystem.getNumberOfAvailableBooks());
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
        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        assertEquals(true, libSystem.chooseBookToCheckout());
    }

    @Test
    public void chooseBookToCheckoutShouldReturnFalseIfBookDoesNotExist() {
        in = new ByteArrayInputStream("Non-existent book".getBytes());
        System.setIn(in);
        assertEquals(false, libSystem.chooseBookToCheckout());
    }

    @Test
    public void checkoutBookShouldDisplayThereAreNoBooksIfAllBooksAreBorrowed() {
        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
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

        assertEquals("\nThere are currently no books available.\n", libSystem.checkoutBook());
    }

    @Test
    public void checkoutBookShouldDisplayThankYouMessageOnSuccessfulCheckout() {
        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        assertEquals("\nThank you! Enjoy the book.\n", libSystem.checkoutBook());
    }

    @Test
    public void checkoutBookShouldDisplayBookNotFoundMsgOnUnsuccessfulCheckout() {
        in = new ByteArrayInputStream("Non-existent book".getBytes());
        System.setIn(in);
        assertEquals("\nThat book is not available.\n", libSystem.checkoutBook());
    }

    @Test
    public void chooseBookToReturnShouldReturnTrueIfBookExists() {
        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        assertEquals(true, libSystem.chooseBookToReturn());
    }

    @Test
    public void chooseBookToReturnShouldReturnFalseIfBookDoesNotExists() {
        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Goats of War: Manvil Grate".getBytes());
        System.setIn(in);
        assertEquals(false, libSystem.chooseBookToReturn());
    }

    @Test
    public void returnBookShouldDisplayThankYouMsgOnSuccessfulReturn() {
        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        assertEquals("\nThank you for returning the book.\n", libSystem.returnBook());
    }

    @Test
    public void returnBookShouldDisplayBookNotValidOnUnsuccessfulReturn() {
        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        libSystem.chooseBookToCheckout();

        in = new ByteArrayInputStream("Goats of War: Manvil Grate".getBytes());
        System.setIn(in);
        assertEquals("\nThat is not a valid book to return.\n", libSystem.returnBook());
    }

    @Test
    public void returnBookShouldDeclareNoBooksToReturnIfNoneAreBorrowed() {
        assertEquals("\nThere are currently no books being borrowed.\n", libSystem.returnBook());
    }

}