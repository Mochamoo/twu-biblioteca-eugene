package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class InputTest {
    Input input;
    ByteArrayInputStream in;

    @Before
    public void setUp() throws Exception {
        input = new Input();
    }

    @After
    public void tearDown() throws Exception {
        System.setIn(System.in);
    }

    @Test
    public void getUserInputShouldReturnWhatUserEnters() throws Exception {
        in = new ByteArrayInputStream("The day is hot.".getBytes());
        System.setIn(in);

        assertEquals("The day is hot.", input.getInput());
    }

    @Test
    public void validateUserInput() throws Exception {

    }

}