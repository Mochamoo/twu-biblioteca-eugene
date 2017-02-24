package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RatingTest {

    @Test
    public void getRating() {
        Rating sevenStars = Rating.SEVEN;

        assertEquals("7", sevenStars.getRating());
    }

}