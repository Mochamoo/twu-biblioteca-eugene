package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.MovieList;

import java.util.ArrayList;

public class MoviesService {
    private MovieList availableMovies;
    private MovieList borrowedMovies;

    public MoviesService() {
        availableMovies = new MovieList();
        borrowedMovies = new MovieList();
    }

    private String generateMovieHeader() {
        return "Name | Year | Director | Rating";
    }

    public ArrayList<String> generateMoviesDisplay() {
        ArrayList<String> headerAndListOfMovies = new ArrayList<String>();
        headerAndListOfMovies.add(generateMovieHeader());


        for(Movie movie : availableMovies.getMovies().values()) {
            headerAndListOfMovies.add(String.format("%s | %d | %s | %s",
                    movie.getTitle(),
                    movie.getYearReleased(),
                    movie.getDirectorName(),
                    movie.getRatingInString()));
        }
        headerAndListOfMovies.add(String.format("%n"));

        return headerAndListOfMovies;
    }

    public int getNumberOfAvailableMovies() {
        return availableMovies.size();
    }

    public void addMovie(Movie movie) {
        availableMovies.addMovie(movie);
    }

    public boolean checkoutMovie(String movieTitle) {
        Movie movie;

        if(availableMovies.doesMovieExist(movieTitle) == true) {
            movie = availableMovies.getMovieByTitle(movieTitle);
            borrowedMovies.addMovie(movie);
            availableMovies.removeMovie(movie.getTitle());
            return true;
        }

        return false;
    }

    public boolean returnMovie(String movieTitle) {
        Movie movie;

        if(borrowedMovies.doesMovieExist(movieTitle) == true) {
            movie = borrowedMovies.getMovieByTitle(movieTitle);
            borrowedMovies.removeMovie(movie.getTitle());
            availableMovies.addMovie(movie);
            return true;
        }

        return false;
    }

    public int getNumberOfBorrowedMovies() {
        return borrowedMovies.size();
    }
}
