package com.twu.biblioteca.View;

import com.twu.biblioteca.Model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    private LibraryManagementSystem libSystem;
    private Menu menu;
    private User customer;
    private ByteArrayInputStream in;

    @Before
    public void setUp() {
        libSystem = new LibraryManagementSystem();
        menu = new Menu();
        customer = new User(new Name("Bojack", "Horseman"), "micro@Gmail.com",
                "04112628", "123-4567", "64 digit hash");

        libSystem.addBook(new Book("Test-Driven Development",
                new AuthorNamesList(new Name("Kent", "Beck")),
                2003));
        libSystem.addBook(new Book("Gears of War: Anvil Gate",
                new AuthorNamesList(new Name("Karen", "Travis")),
                2010));
        libSystem.addBook(new Book("Artificial Intelligence: A Modern Approach",
                new AuthorNamesList(new Name("Peter", "Norvig")),
                2010));
        libSystem.addBook(new Book("Introduction to the Design & Analysis of Algorithm",
                new AuthorNamesList(new Name("Anany", "Levitin")),
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
    public void generateMenuShouldShowHeaderAndAllUsersOptions() {
        assertEquals("Please make your selection (Enter one of the numbers below):\n" +
                     "1) List Books\n" +
                     "2) Checkout Book\n" +
                     "3) Return Book\n" +
                     "4) List Movies\n" +
                     "5) Checkout Movie\n" +
                     "6) Return Movie\n" +
                     "7) View User Info\n" +
                     "8) Quit\n", menu.generateMenu(libSystem));
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
                new Name("George", "Miller"), Rating.TEN));

        in = new ByteArrayInputStream("Mad Max: Fury Road".getBytes());
        System.setIn(in);
        assertEquals("Thank you! Enjoy the movie.", menu.checkoutMovie(libSystem));
    }

    @Test
    public void checkoutMovieShouldReturnBookUnavailableMessageIfBookDoesNotMatch() {
        libSystem.addMovie(new Movie("Mad Max: Fury Road", 2015,
                new Name("George", "Miller"), Rating.TEN));

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
                new Name("George", "Miller"), Rating.TEN));

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
                new Name("George", "Miller"), Rating.TEN));

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
        LibraryManagementSystem libSystem = new LibraryManagementSystem();
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
        LibraryManagementSystem libSystem = new LibraryManagementSystem();
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