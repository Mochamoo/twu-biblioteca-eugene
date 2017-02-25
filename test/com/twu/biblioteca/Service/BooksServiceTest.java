package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.Author;
import com.twu.biblioteca.Model.AuthorList;
import com.twu.biblioteca.Model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooksServiceTest {
    private BooksService booksService;

    @Before
    public void setUp() {
        booksService = new BooksService();
        ;
        booksService.addBook(new Book("Test-Driven Development",
                new AuthorList(new Author("Kent", "Beck")),
                2003));
        booksService.addBook(new Book("Gears of War: Anvil Gate",
                new AuthorList(new Author("Karen", "Travis")),
                2010));
        booksService.addBook(new Book("Artificial Intelligence: A Modern Approach",
                new AuthorList(new Author("Peter", "Norvig")),
                2010));
        booksService.addBook(new Book("Introduction to the Design & Analysis of Algorithm",
                new AuthorList(new Author("Anany", "Levitin")),
                2012));
    }

    @Test
    public void addBookShouldPutNewBookIntoAvailableBookList() {
        assertEquals(4, booksService.getNumberOfAvailableBooks());
    }

    @Test
    public void generateBooksDisplayShouldAddHeaderFourBookRecordsAndNewlineIntoArray() {
        assertEquals(6, booksService.generateBooksDisplay().size());
    }

    @Test
    public void checkoutBookShouldReturnTrueOnSuccessfulCheckout() {
        assertEquals(true, booksService.checkoutBook("Gears of War: Anvil Gate"));
    }

    @Test
    public void checkoutBookShouldReturnFalseOnUnsuccessfulCheckout() {
        assertEquals(false, booksService.checkoutBook("Non-existent book"));
    }

    @Test
    public void returnBookShouldReturnTrueOnSuccessfulReturn() {
        booksService.checkoutBook("Gears of War: Anvil Gate");

        assertEquals(true, booksService.returnBook("Gears of War: Anvil Gate"));
    }

    @Test
    public void returnBookShouldReturnFalseOnInvalidBookName() {
        booksService.checkoutBook("Gears of War: Anvil Gate");

        assertEquals(false, booksService.returnBook("Goats of War: Manvil Grate"));
    }
}