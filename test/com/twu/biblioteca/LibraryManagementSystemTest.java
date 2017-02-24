package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryManagementSystemTest {
    private LibraryManagementSystem libSystem;

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

    @Test
    public void addBookShouldPutNewBookIntoAvailableBookList() {
        assertEquals(4, libSystem.getNumberOfAvailableBooks());
    }

    @Test
    public void generateBooksDisplayShouldShowAllTitlesAuthorsAndPublishYear() {
        assertEquals("Title | Author | Year Published\n" +
                     "Test-Driven Development | Kent Beck | 2003\n" +
                     "Gears of War: Anvil Gate | Karen Travis | 2010\n" +
                     "Artificial Intelligence: A Modern Approach | Peter Norvig | 2010\n" +
                     "Introduction to the Design & Analysis of Algorithm | Anany Levitin | 2012\n",
                     libSystem.generateBooksDisplay());
    }

    @Test
    public void checkoutBookShouldReturnTrueOnSuccessfulCheckout() {
        assertEquals(true, libSystem.checkoutBook("Gears of War: Anvil Gate"));
    }

    @Test
    public void checkoutBookShouldReturnFalseOnUnsuccessfulCheckout() {
        assertEquals(false, libSystem.checkoutBook("Non-existent book"));
    }

    @Test
    public void returnBookShouldReturnTrueOnSuccessfulReturn() {
        libSystem.checkoutBook("Gears of War: Anvil Gate");

        assertEquals(true, libSystem.returnBook("Gears of War: Anvil Gate"));
    }

    @Test
    public void returnBookShouldReturnFalseOnInvalidBookName() {
        libSystem.checkoutBook("Gears of War: Anvil Gate");

        assertEquals(false, libSystem.returnBook("Goats of War: Manvil Grate"));
    }

    @Test
    public void addUserShouldIncrementUserListSizeByOneOnSuccessfulAdd() {
        libSystem.addUser(new User(new Name("Bojack", "Horseman"),
                "micro@Gmail.com", "04112628", "000-0001",
                "64 digit hash"));

        assertEquals(1, libSystem.getNumberOfUsers());
    }

    @Test
    public void generateUserInfoDisplayShouldReturnCurrentUserInformation() {
        User currentUser = new User(new Name("Bojack", "Horseman"),
                "micro@Gmail.com", "0411262811", "000-0001",
                "64 digit hash");
        libSystem.addUser(currentUser);
        libSystem.setCurrentUser(currentUser);

        assertEquals("Name: Bojack Horseman\n" +
                     "E-mail: micro@Gmail.com\n" +
                     "Phone: 0411262811", libSystem.generateUserInfoDisplay());
    }

    @Test
    public void addMovieShouldPutNewMovieIntoAvailableMoviesList() {
        libSystem.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        assertEquals(1, libSystem.getNumberOfAvailableMovies());
    }

    @Test
    public void generateMoviesDisplayShouldReturnHeaderAndListOfMovies() {
        libSystem.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        assertEquals("Name | Year | Director | Rating\n" +
                     "The Bee Movie | 1998 | Edgar Wright | 1\n",
                     libSystem.generateMoviesDisplay());
    }

    @Test
    public void checkoutMovieShouldReturnTrueOnSuccessfulRent() {
        libSystem.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        assertEquals(true, libSystem.checkoutMovie("The Bee Movie"));
    }

    @Test
    public void checkoutMovieShouldReturnFalseOnUnsuccessfulRent() {
        libSystem.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        assertEquals(false, libSystem.checkoutMovie("The Bee "));
    }

    @Test
    public void returnMovieShouldReturnTrueOnSuccessfulReturn() {
        libSystem.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        libSystem.checkoutMovie("The Bee Movie");

        assertEquals(true, libSystem.returnMovie("The Bee Movie"));
    }

    @Test
    public void returnMovieShouldReturnFalseOnUnsuccessfulReturn() {
        libSystem.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        libSystem.checkoutMovie("The Bee Movie");

        assertEquals(false, libSystem.returnMovie("The Bee"));
    }
}