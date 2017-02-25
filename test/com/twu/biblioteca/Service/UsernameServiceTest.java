package com.twu.biblioteca.Service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsernameServiceTest {

    UsernameService inputFormatter;

    @Before
    public void setup() {
        inputFormatter = new UsernameService();
    }

    @Test
    public void isCorrectLengthShouldReturnTrueIfInputIs7CharLong() {
        assertEquals(true, inputFormatter.isCorrectLength("1363361"));
    }

    @Test
    public void isCorrectLengthShouldReturnFalseIfInputTooShortOrLong() {
        assertEquals(false, inputFormatter.isCorrectLength("134"));
        assertEquals(false, inputFormatter.isCorrectLength("13488886"));
    }

    @Test
    public void isIntegerShouldReturnTrueOnAllIntInput() {
        assertEquals(true, inputFormatter.isInteger("1432532"));
    }

    @Test
    public void isIntegerShouldReturnFalseOnNonInteger() {
        assertEquals(false, inputFormatter.isInteger("ba4745q3"));
    }

    @Test
    public void isInvalidUsernameShouldReturnTrueForCorrectUsernameFormat() {
        assertEquals(false, inputFormatter.isInvalidUsername("1234567"));
    }

    @Test
    public void isInvalidUsernameShouldReturnFalseForIncorrectUsernameFormat() {
        assertEquals(true, inputFormatter.isInvalidUsername("123456"));
    }

    @Test
    public void getFormattedUsernameShouldProduceFormattedUserNameOnValidInput() {
        String usernameInCorrectFormat = "1234567";
        assertEquals("123-4567", inputFormatter.getFormattedUsername(usernameInCorrectFormat));
    }
}
