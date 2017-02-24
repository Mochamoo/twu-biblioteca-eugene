package com.twu.biblioteca.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooksManagerTest {
    private BooksManager booksManager;

    @Before
    public void setUp() {
        booksManager = new BooksManager();
        ;
        booksManager.addBook(new Book("Test-Driven Development",
                new AuthorList(new Author("Kent", "Beck")),
                2003));
        booksManager.addBook(new Book("Gears of War: Anvil Gate",
                new AuthorList(new Author("Karen", "Travis")),
                2010));
        booksManager.addBook(new Book("Artificial Intelligence: A Modern Approach",
                new AuthorList(new Author("Peter", "Norvig")),
                2010));
        booksManager.addBook(new Book("Introduction to the Design & Analysis of Algorithm",
                new AuthorList(new Author("Anany", "Levitin")),
                2012));
    }

    @Test
    public void addBookShouldPutNewBookIntoAvailableBookList() {
        assertEquals(4, booksManager.getNumberOfAvailableBooks());
    }

    @Test
    public void generateBooksDisplayShouldShowAllTitlesAuthorsAndPublishYear() {
        assertEquals("Title | Author | Year Published\n" +
                     "Test-Driven Development | Kent Beck | 2003\n" +
                     "Gears of War: Anvil Gate | Karen Travis | 2010\n" +
                     "Artificial Intelligence: A Modern Approach | Peter Norvig | 2010\n" +
                     "Introduction to the Design & Analysis of Algorithm | Anany Levitin | 2012\n",
                booksManager.generateBooksDisplay());
    }

    @Test
    public void checkoutBookShouldReturnTrueOnSuccessfulCheckout() {
        assertEquals(true, booksManager.checkoutBook("Gears of War: Anvil Gate"));
    }

    @Test
    public void checkoutBookShouldReturnFalseOnUnsuccessfulCheckout() {
        assertEquals(false, booksManager.checkoutBook("Non-existent book"));
    }

    @Test
    public void returnBookShouldReturnTrueOnSuccessfulReturn() {
        booksManager.checkoutBook("Gears of War: Anvil Gate");

        assertEquals(true, booksManager.returnBook("Gears of War: Anvil Gate"));
    }

    @Test
    public void returnBookShouldReturnFalseOnInvalidBookName() {
        booksManager.checkoutBook("Gears of War: Anvil Gate");

        assertEquals(false, booksManager.returnBook("Goats of War: Manvil Grate"));
    }
}