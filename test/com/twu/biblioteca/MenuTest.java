package com.twu.biblioteca;

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
    public void generateMenuShouldShowHeaderAndAllUsersOptions() {
        assertEquals("Please make your selection (Enter one of the numbers below):\n" +
                     "1) List Books\n" +
                     "2) Checkout Book\n" +
                     "3) Return Book\n" +
                     "4) List Movies\n" +
                     "5) Checkout Movie\n" +
                     "6) Return Movie\n" +
                     "7) View User Info\n" +
                     "8) Quit\n", menu.generateMenu(customer));
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

        assertEquals("\nThere are currently no books available.\n",
                menu.checkoutBook(libSystem));
    }

    @Test
    public void returnBookShouldDeclareNoBooksToReturnIfNoneAreBorrowed() {
        assertEquals("\nThere are currently no books being borrowed.\n",
                menu.returnBook(libSystem));
    }
}