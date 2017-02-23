package com.twu.biblioteca;

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
    public void requestUsernameShouldReturnUsernameIfFormatIsSevenIntegers() {
        in = new ByteArrayInputStream("1235678".getBytes());
        System.setIn(in);

        assertEquals("123-5678", loginHandler.requestUsername());
    }

    @Test
    public void requestUsernameShouldReturnEmptyStringOnIncorrectFormatting() {
        in = new ByteArrayInputStream("123567".getBytes());
        System.setIn(in);

        assertEquals("", loginHandler.requestUsername());
    }

    @Test
    public void requestPasswordShouldReturnEnteredPassword() {
        in = new ByteArrayInputStream("Amanda".getBytes());
        System.setIn(in);

        assertEquals("Amanda", loginHandler.requestPassword());
    }

    @Test
    public void validateLoginDetailsShouldReturnTrueOnSuccessfulLogin() {
        LibraryManagementSystem libSystem = new LibraryManagementSystem();
        String hash = "fe0c55384313c0194d318c5eb17a864a19a56873d7427c4671976d70f7d4a2c5";
        libSystem.addUser(new User(new Name("Bojack", "Horseman"),
                "micro@Gmail.com", "04112628", "123-4567",
                hash));

        in = new ByteArrayInputStream("1234567".getBytes());
        System.setIn(in);
        String username = loginHandler.requestUsername();

        in = new ByteArrayInputStream("Horseman".getBytes());
        System.setIn(in);
        String password = loginHandler.requestPassword();

        assertEquals(true, loginHandler.validateLoginDetails(libSystem, username, password));
    }
}