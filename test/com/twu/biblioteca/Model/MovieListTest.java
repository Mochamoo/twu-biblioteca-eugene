package com.twu.biblioteca.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieListTest {
    private MovieList movies;

    @Before
    public void setup() {
        movies = new MovieList();
        movies.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar","Wright"), Rating.ONE));
    }

    @Test
    public void addMovieShouldIncrementListSizeByOne() throws Exception {
        assertEquals(1, movies.size());
    }

    @Test
    public void getMovieByTitleShouldReturnSpecifiedMovie() throws Exception {
        assertEquals("The Bee Movie", movies.getMovieByTitle("The Bee Movie").getTitle());
    }

}