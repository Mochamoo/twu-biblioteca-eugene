package com.twu.biblioteca.Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionsTest {

    @Test
    public void getOptionStringShouldReturnOptionInString() {
        Options quitOption = Options.QUIT;

        assertEquals("Quit", quitOption.getOptionString());
    }
}