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
                new Director("Edgar","Wright"), Rating.ONE));
    }

    @Test
    public void addMovieShouldIncrementListSizeByOne() {
        assertEquals(1, movies.size());
    }

    @Test
    public void getMovieByTitleShouldReturnSpecifiedMovie() {
        assertEquals("The Bee Movie", movies.getMovieByTitle("The Bee Movie").getTitle());
    }

    @Test
    public void doesMovieExistShouldReturnTrueIfMovieIsInList() {
        assertEquals(true, movies.doesMovieExist("The Bee Movie"));
    }

    @Test
    public void doesMovieExistShouldReturnFalseIfMovieIsInList() {
        assertEquals(false, movies.doesMovieExist("The Movie"));
    }

}