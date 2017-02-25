package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.Name;
import com.twu.biblioteca.Model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class LoginHandlerTest {
    private LoginHandler loginHandler;
    private ByteArrayInputStream in;

    @Before
    public void setup() {
        loginHandler = new LoginHandler();
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void getPasswordHashShouldReturnDigestOfUserEnteredString() {
        assertEquals("7d9b0460c4d96860da53c3e29da77a82edd879fcbadba8a00587776df0b99794",
                LoginHandler.hashPassword("Esteemed character-actress"));
    }

    @Test
    public void validateLoginDetailsShouldReturnTrueOnSuccessfulLogin() {
        LibraryService libSystem = new LibraryService();
        String hash = "fdb8534840de9c6d46d6004697249a74c1730abfc3a2c090f940c91b388b66db";
        libSystem.addUser(new User(new Name("Bojack", "Horseman"),
                "micro@Gmail.com", "04112628", "123-4567",
                hash));

        String username = "123-4567";
        String password = "64 digit hash";

        assertEquals(true, loginHandler.validateLoginDetails(libSystem, username, password));
    }
}