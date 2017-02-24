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
    public void initialiseDatabaseShouldPopulateLibraryManagementSystemWithData() {
        LibraryManagementSystem newLibSystem = new LibraryManagementSystem();
        newLibSystem.initialiseDatabase();

        assertEquals(4, newLibSystem.getNumberOfAvailableBooks());
        assertEquals(1, newLibSystem.getNumberOfAvailableMovies());
        assertEquals(1, newLibSystem.getNumberOfUsers());
    }

}