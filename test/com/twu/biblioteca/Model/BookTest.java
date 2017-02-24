package com.twu.biblioteca.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("Test-Driven Development",
               new AuthorList(new Author("Kent", "Beck")), 2003);
    }

    @Test
    public void getTitleShouldReturnBooksTitle() {
        assertEquals("Test-Driven Development", book.getTitle());
    }

    @Test
    public void getAuthorNamesShouldReturnBooksAuthor() {
        assertEquals("Kent Beck", book.getAuthorNames());
    }

    @Test
    public void getYearPublishedShouldReturnBooksPublishedYear() {
        assertEquals(2003, book.getYearPublished());
    }

}