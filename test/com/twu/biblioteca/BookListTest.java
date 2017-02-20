package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookListTest {
    BookList bookList;

    @Before
    public void setUp() throws Exception {
        bookList = new BookList();
    }

    @Test
    public void bookListShouldHaveFourBooksAtInit() {
        assertEquals(4, bookList.size());
    }

}