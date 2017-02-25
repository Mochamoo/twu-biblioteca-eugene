package com.twu.biblioteca.Model;

import java.util.HashMap;
import java.util.Map;

public class MovieList {
    private Map<String, Movie> movies;

    public MovieList() {
        movies = new HashMap<String, Movie>();
    }

    public int size() {
        return movies.size();
    }

    public Movie getMovieByTitle(String title) {
        return movies.get(title);
    }

    public boolean doesMovieExist(String title) {
        if(getMovieByTitle(title) == null) {
            return false;
        }

        return true;
    }

    public Map<String, Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getTitle(), movie);
    }

    public void removeMovie(String title) {
        movies.remove(title);
    }


}
