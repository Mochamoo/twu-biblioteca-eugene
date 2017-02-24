package com.twu.biblioteca.Service;

import com.twu.biblioteca.Service.Input;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class InputTest {
    private Input input;

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
        ByteArrayInputStream in = new ByteArrayInputStream("The day is hot.".getBytes());
        System.setIn(in);

        assertEquals("The day is hot.", input.getInput());
    }

}