package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User customer;

    @Before
    public void setUp() {
        customer = new User(new Name("Bojack", "Horseman"),
                "micro@Gmail.com", "04112628", "000-0001",
                "64 digit hash");
    }

    @Test
    public void getUserOptionsShouldReturnListOfOptionsForUser() {
        assertEquals("1) List Books\n" +
                     "2) Checkout Book\n" +
                     "3) Return Book\n" +
                     "4) List Movies\n" +
                     "5) Checkout Movie\n" +
                     "6) Return Movie\n" +
                     "7) View User Info\n" +
                     "8) Quit\n", customer.getUserOptions());
    }

}