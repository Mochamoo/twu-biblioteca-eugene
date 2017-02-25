package com.twu.biblioteca.View;

import com.twu.biblioteca.Model.*;
import com.twu.biblioteca.Service.LibraryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    private LibraryService libSystem;
    private Menu menu;
    private User customer;
    private ByteArrayInputStream in;

    @Before
    public void setUp() {
        libSystem = new LibraryService();
        menu = new Menu();
        customer = new User(new Name("Bojack", "Horseman"), "micro@Gmail.com",
                "04112628", "123-4567", "64 digit hash");

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
    public void teardown() {
        System.setIn(System.in);
    }

    @Test
    public void generateWelcomeShouldPrintWelcomeMessage() {
        assertEquals("===Welcome to Biblioteca!===", menu.generateWelcome());
    }

    @Test
    public void generateMenuShouldPutNineLinesOfMenuIntoLineArray() {
        assertEquals(9, menu.generateMenu(libSystem).size());
    }

    @Test
    public void checkoutBookShouldDeclareNoBooksAvailableIfAllAreBorrowed() {
        in = new ByteArrayInputStream("Test-Driven Development".getBytes());
        System.setIn(in);
        menu.checkoutBook(libSystem);

        in = new ByteArrayInputStream("Gears of War: Anvil Gate".getBytes());
        System.setIn(in);
        menu.checkoutBook(libSystem);

        in = new ByteArrayInputStream("Artificial Intelligence: A Modern Approach".getBytes());
        System.setIn(in);
        menu.checkoutBook(libSystem);

        in = new ByteArrayInputStream("Introduction to the Design & Analysis of Algorithm".getBytes());
        System.setIn(in);
        menu.checkoutBook(libSystem);

        assertEquals("There are currently no books available.",
                menu.checkoutBook(libSystem));
    }

    @Test
    public void checkoutBookShouldReturnThankYouMessageOnSuccessfulCheckout() {
        in = new ByteArrayInputStream("Test-Driven Development".getBytes());
        System.setIn(in);

        assertEquals("Thank you! Enjoy the book.", menu.checkoutBook(libSystem));
    }

    @Test
    public void returnBookShouldDeclareNoBooksToReturnIfNoneAreBorrowed() {
        assertEquals("There are currently no books being borrowed.",
                menu.returnBook(libSystem));
    }

    @Test
    public void checkoutMovieShouldDeclareNoAvailableMoviesIfAllAreBorrowed() {
        assertEquals("There are currently no movies available.",
                menu.checkoutMovie(libSystem));
    }

    @Test
    public void checkoutMovieShouldReturnThankYouMsgOnSuccessfulRental() {
        libSystem.addMovie(new Movie("Mad Max: Fury Road", 2015,
                new Director("George", "Miller"), Rating.TEN));

        in = new ByteArrayInputStream("Mad Max: Fury Road".getBytes());
        System.setIn(in);
        assertEquals("Thank you! Enjoy the movie.", menu.checkoutMovie(libSystem));
    }

    @Test
    public void checkoutMovieShouldReturnBookUnavailableMessageIfBookDoesNotMatch() {
        libSystem.addMovie(new Movie("Mad Max: Fury Road", 2015,
                new Director("George", "Miller"), Rating.TEN));

        in = new ByteArrayInputStream("Mad Max: Furiosa Road".getBytes());
        System.setIn(in);
        assertEquals("That movie is unavailable.", menu.checkoutMovie(libSystem));
    }

    @Test
    public void returnMovieShouldReturnNoMoviesBeingBorrowedMsgIfNoAvailableMovies() {
        in = new ByteArrayInputStream("Mad Max: Furiosa Road".getBytes());
        System.setIn(in);
        assertEquals("There are currently no movies being borrowed.",
                menu.returnMovie(libSystem));
    }

    @Test
    public void returnMovieShouldReturnThankYouMsgOnSuccessfulReturn() {
        libSystem.addMovie(new Movie("Mad Max: Fury Road", 2015,
                new Director("George", "Miller"), Rating.TEN));

        in = new ByteArrayInputStream("Mad Max: Fury Road".getBytes());
        System.setIn(in);
        menu.checkoutMovie(libSystem);

        in = new ByteArrayInputStream("Mad Max: Fury Road".getBytes());
        System.setIn(in);
        assertEquals("Thank you for returning the movie.", menu.returnMovie(libSystem));
    }

    @Test
    public void returnMovieShouldReturnInvalidMovieMsgIfEnteredMovieNotFound() {
        libSystem.addMovie(new Movie("Mad Max: Fury Road", 2015,
                new Director("George", "Miller"), Rating.TEN));

        in = new ByteArrayInputStream("Mad Max: Fury Road".getBytes());
        System.setIn(in);
        menu.checkoutMovie(libSystem);

        in = new ByteArrayInputStream("Mad Max: Furiosa Road".getBytes());
        System.setIn(in);
        assertEquals("That is not a valid movie to return.", menu.returnMovie(libSystem));
    }

    @Test
    public void requestUsernameShouldReturnUsernameIfFormatIsSevenIntegers() {
        in = new ByteArrayInputStream("1235678".getBytes());
        System.setIn(in);

        assertEquals("123-5678", menu.requestUsername());
    }

    @Test
    public void requestPasswordShouldReturnEnteredPassword() {
        in = new ByteArrayInputStream("Amanda".getBytes());
        System.setIn(in);

        assertEquals("Amanda", menu.requestPassword());
    }

    @Test
    public void verifyUserShouldReturnTrueIfUserCredentialsAreCorrect() {
        LibraryService libSystem = new LibraryService();
        String hash = "fdb8534840de9c6d46d6004697249a74c1730abfc3a2c090f940c91b388b66db";
        libSystem.addUser(new User(new Name("Bojack", "Horseman"),
                "micro@Gmail.com", "04112628", "123-4567",
                hash));

        in = new ByteArrayInputStream("1234567".getBytes());
        System.setIn(in);
        String username = menu.requestUsername();

        in = new ByteArrayInputStream("64 digit hash".getBytes());
        System.setIn(in);
        String password = menu.requestPassword();

        assertEquals(true, menu.verifyUser(libSystem, username, password));
    }

    @Test
    public void verifyUserShouldReturnFalseIfUserCredentialsIncorrect() {
        LibraryService libSystem = new LibraryService();
        String hash = "fdb8534840de9c6d46d6004697249a74c1730abfc3a2c090f940c91b388b66db";
        libSystem.addUser(new User(new Name("Bojack", "Horseman"),
                "micro@Gmail.com", "04112628", "123-4567",
                hash));

        in = new ByteArrayInputStream("1234567".getBytes());
        System.setIn(in);
        String username = menu.requestUsername();

        in = new ByteArrayInputStream("64 digit has".getBytes());
        System.setIn(in);
        String password = menu.requestPassword();

        assertEquals(false, menu.verifyUser(libSystem, username, password));
    }

    @Test
    public void getOptionFromUserShouldReturnAnOptionEnumFromValidInput() {
        in = new ByteArrayInputStream("4".getBytes());
        System.setIn(in);

        assertEquals(Options.LIST_MOVIES, menu.getOptionFromUser(libSystem));
    }
}