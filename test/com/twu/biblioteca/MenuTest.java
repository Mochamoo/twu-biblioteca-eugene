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
    public void generateWelcomeShouldPrintWelcomeMessage() {
        assertEquals("===Welcome to Biblioteca!===", menu.generateWelcome());
    }

    @Test
    public void generateMenuShouldShowHeaderAndAllUsersOptions() {
        assertEquals("Please make your selection (Enter one of the numbers below):\n" +
                     "1) List Books\n" +
                     "2) Checkout Book\n" +
                     "3) Return Book\n" +
                     "4) Quit\n", menu.generateMenu(customer));
    }

}