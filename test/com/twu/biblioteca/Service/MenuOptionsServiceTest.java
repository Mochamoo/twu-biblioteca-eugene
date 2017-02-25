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
    public void validateAgainstOptionsShouldReturnFalseOnNonInteger() {
        assertEquals(false, input.isValidInteger("..."));
    }

    @Test
    public void validateAgainstOptionsShouldReturnFalseOnOutOfBoundsInteger() {
        assertEquals(false, input.isValidInteger("0"));
        assertEquals(false, input.isValidInteger("9"));
    }

    @Test
    public void validateAgainstOptionsShouldReturnTrueOnValidInput() {
        assertEquals(true, input.isValidInteger("3"));
    }

    @Test
    public void convertInputToOptionShouldReturnOptionEnumOnValidInput() {
        assertEquals(Options.QUIT, input.convertInputToOption("8"));
    }

}