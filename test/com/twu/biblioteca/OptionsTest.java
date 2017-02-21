package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionsTest {

    @Test
    public void getOptionShouldReturnOptionInString() {
        Options quitOption = Options.QUIT;

        assertEquals("Quit", quitOption.getOption());
    }
}