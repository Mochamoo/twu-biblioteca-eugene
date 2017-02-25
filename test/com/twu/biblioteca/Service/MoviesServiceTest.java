package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.Director;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.Rating;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoviesServiceTest {
    private MoviesService moviesService;

    @Before
    public void setup() {
        moviesService = new MoviesService();
    }

    @Test
    public void addMovieShouldPutNewMovieIntoAvailableMoviesList() {
        moviesService.addMovie(new Movie("The Bee Movie", 1998,
                new Director("Edgar", "Wright"), Rating.ONE));

        assertEquals(1, moviesService.getNumberOfAvailableMovies());
    }

    @Test
    public void generateMoviesDisplayShouldReturnHeaderOneMovieAndNewlineToArray() {
        moviesService.addMovie(new Movie("The Bee Movie", 1998,
                new Director("Edgar", "Wright"), Rating.ONE));

        assertEquals(3, moviesService.generateMoviesDisplay().size());
    }

    @Test
    public void checkoutMovieShouldReturnTrueOnSuccessfulRent() {
        moviesService.addMovie(new Movie("The Bee Movie", 1998,
                new Director("Edgar", "Wright"), Rating.ONE));

        assertEquals(true, moviesService.checkoutMovie("The Bee Movie"));
    }

    @Test
    public void checkoutMovieShouldReturnFalseOnUnsuccessfulRent() {
        moviesService.addMovie(new Movie("The Bee Movie", 1998,
                new Director("Edgar", "Wright"), Rating.ONE));

        assertEquals(false, moviesService.checkoutMovie("The Bee "));
    }

    @Test
    public void returnMovieShouldReturnTrueOnSuccessfulReturn() {
        moviesService.addMovie(new Movie("The Bee Movie", 1998,
                new Director("Edgar", "Wright"), Rating.ONE));

        moviesService.checkoutMovie("The Bee Movie");

        assertEquals(true, moviesService.returnMovie("The Bee Movie"));
    }

    @Test
    public void returnMovieShouldReturnFalseOnUnsuccessfulReturn() {
        moviesService.addMovie(new Movie("The Bee Movie", 1998,
                new Director("Edgar", "Wright"), Rating.ONE));

        moviesService.checkoutMovie("The Bee Movie");

        assertEquals(false, moviesService.returnMovie("The Bee"));
    }

}