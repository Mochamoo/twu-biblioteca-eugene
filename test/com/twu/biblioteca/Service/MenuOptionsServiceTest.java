package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.Options;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuOptionsServiceTest {
    LibraryService libSystem;
    private MenuOptionsService input;

    @Before
    public void setUp() throws Exception {
        libSystem = new LibraryService();
        input = new MenuOptionsService(libSystem);
    }

    @Test
    public void validateAgainstOptionsShouldReturnNullOnNonInteger() {
        assertEquals(null, input.validateAgainstOptions("..."));
    }

    @Test
    public void validateAgainstOptionsShouldReturnNullOnOutOfBoundsInteger() {
        assertEquals(null, input.validateAgainstOptions("0"));
        assertEquals(null, input.validateAgainstOptions("9"));
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