package com.twu.biblioteca;

import com.twu.biblioteca.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("Test-Driven Development", "Kent Beck", 2003);
    }

    @Test
    public void getTitleShouldReturnBooksTitle() {
        assertEquals("Test-Driven Development", book.getTitle());
    }

    @Test
    public void getAuthorShouldReturnBooksAuthor() {
        assertEquals("Kent Beck", book.getAuthor());
    }

    @Test
    public void getYearPublishedShouldReturnBooksPublishedYear() {
        assertEquals(2003, book.getYearPublished());
    }

}