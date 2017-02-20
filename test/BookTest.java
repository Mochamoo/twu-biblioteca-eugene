import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book;

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
    public void getPublishedYearShouldReturnBooksPublishedYear() {
        assertEquals(2003, book.getPublishedYear());
    }

}