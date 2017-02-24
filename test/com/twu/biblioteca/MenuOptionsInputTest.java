package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuOptionsInputTest {
    LibraryManagementSystem libSystem;
    private MenuOptionsInput input;

    @Before
    public void setUp() throws Exception {
        libSystem = new LibraryManagementSystem();
        input = new MenuOptionsInput(libSystem);
    }

    @Test
    public void validateAgainstOptionsShouldReturnFailMsgOnNonInteger() {
        assertEquals("Select a valid option!", input.validateAgainstOptions("..."));
    }

    @Test
    public void validateAgainstOptionsShouldReturnFailMsgOnOutOfBoundsInteger() {
        assertEquals("Select a valid option!", input.validateAgainstOptions("0"));
        assertEquals("Select a valid option!", input.validateAgainstOptions("9"));
    }

    @Test
    public void validateAgainstOptionsShouldReturnInputMinus1OnValidInput() {
        assertEquals("2", input.validateAgainstOptions("3"));
    }

    @Test
    public void convertInputToOptionShouldReturnOptionEnumOnValidInput() {
        assertEquals(Options.QUIT, input.convertInputToOption("7"));
    }

}