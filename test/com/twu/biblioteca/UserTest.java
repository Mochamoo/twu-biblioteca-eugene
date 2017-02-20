package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User customer;

    @Before
    public void setUp() {
        customer = new User();
    }

    @Test
    public void getUserOptionsShouldReturnListOfOptionsForUser() {
        assertEquals("1) Display Books\n" +
                     "2) Checkout Book\n" +
                     "3) Return Book\n" +
                     "4) Quit\n", customer.getUserOptions());
    }

}