package com.twu.biblioteca.Service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsernameServiceTest {
    UsernameService input;

    @Before
    public void setup() {
        input = new UsernameService();
    }

    @Test
    public void isCorrectLengthShouldReturnTrueIfInputIs7CharLong() {
        assertEquals(true, input.isCorrectLength("1363361"));
    }

    @Test
    public void isCorrectLengthShouldReturnFalseIfInputTooShortOrLong() {
        assertEquals(false, input.isCorrectLength("134"));
        assertEquals(false, input.isCorrectLength("13488886"));
    }

    @Test
    public void isIntegerShouldReturnTrueOnAllIntInput() {
        assertEquals(true, input.isInteger("1432532"));
    }

    @Test
    public void isIntegerShouldReturnFalseOnNonInteger() {
        assertEquals(false, input.isInteger("ba4745q3"));
    }

    @Test
    public void getFormattedUsernameShouldProduceFormattedUserNameOnValidInput() {
        String usernameInCorrectFormat = "1234567";
        assertEquals("123-4567", input.getFormattedUsername(usernameInCorrectFormat));
    }
}