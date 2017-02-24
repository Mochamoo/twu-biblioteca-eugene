package com.twu.biblioteca.Model;

import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.MoviesManager;
import com.twu.biblioteca.Model.Name;
import com.twu.biblioteca.Model.Rating;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoviesManagerTest {
    private MoviesManager moviesManager;

    @Before
    public void setup() {
        moviesManager = new MoviesManager();
    }

    @Test
    public void addMovieShouldPutNewMovieIntoAvailableMoviesList() {
        moviesManager.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        assertEquals(1, moviesManager.getNumberOfAvailableMovies());
    }

    @Test
    public void generateMoviesDisplayShouldReturnHeaderAndListOfMovies() {
        moviesManager.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        assertEquals("Name | Year | Director | Rating\n" +
                        "The Bee Movie | 1998 | Edgar Wright | 1\n",
                moviesManager.generateMoviesDisplay());
    }

    @Test
    public void checkoutMovieShouldReturnTrueOnSuccessfulRent() {
        moviesManager.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        assertEquals(true, moviesManager.checkoutMovie("The Bee Movie"));
    }

    @Test
    public void checkoutMovieShouldReturnFalseOnUnsuccessfulRent() {
        moviesManager.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        assertEquals(false, moviesManager.checkoutMovie("The Bee "));
    }

    @Test
    public void returnMovieShouldReturnTrueOnSuccessfulReturn() {
        moviesManager.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        moviesManager.checkoutMovie("The Bee Movie");

        assertEquals(true, moviesManager.returnMovie("The Bee Movie"));
    }

    @Test
    public void returnMovieShouldReturnFalseOnUnsuccessfulReturn() {
        moviesManager.addMovie(new Movie("The Bee Movie", 1998,
                new Name("Edgar", "Wright"), Rating.ONE));

        moviesManager.checkoutMovie("The Bee Movie");

        assertEquals(false, moviesManager.returnMovie("The Bee"));
    }

}