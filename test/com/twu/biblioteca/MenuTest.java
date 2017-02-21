package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    private Menu menu;
    private User customer;

    @Before
    public void setUp() {
        menu = new Menu();
        customer = new User();
    }

    @Test
    public void welcomeShouldPrintWelcomeMessage() {
        assertEquals("===Welcome to Biblioteca!===", menu.welcome());
    }

    @Test
    public void displayMenuShouldShowHeaderAndAllUsersOptions() {
        assertEquals("Please make your selection (Enter one of the numbers below):\n" +
                     "1) List Books\n" +
                     "2) Checkout Book\n" +
                     "3) Return Book\n" +
                     "4) Quit\n", menu.displayMenu(customer));
    }

    /*@Test
    public void validateUserInputShouldReturnErrorMessageWhenEnteringChar() {
        assertEquals("Enter a valid option!", menu.validateUserInput("x", customer));
    }

    @Test
    public void validateUserInputShouldReturnErrorMessageWhenEnteringNumOutOfRange() {
        assertEquals("Enter a valid option!", menu.validateUserInput("0", customer));
        assertEquals("Enter a valid option!", menu.validateUserInput("5", customer));
    }*/

}