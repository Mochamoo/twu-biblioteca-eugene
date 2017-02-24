package com.twu.biblioteca;

public class MoviesManager {
    private MovieList availableMovies;
    private MovieList borrowedMovies;

    public MoviesManager() {
        availableMovies = new MovieList();
        borrowedMovies = new MovieList();
    }

    private String generateMovieHeader() {
        return "Name | Year | Director | Rating";
    }

    public String generateMoviesDisplay() {
        StringBuilder headerAndListOfMovies = new StringBuilder();
        headerAndListOfMovies.append(generateMovieHeader());
        headerAndListOfMovies.append("\n");

        for(Movie movie : availableMovies.getMovies().values()) {
            headerAndListOfMovies.append(String.format("%s | %d | %s | %s\n",
                    movie.getTitle(),
                    movie.getYearReleased(),
                    movie.getDirectorName(),
                    movie.getRatingInString()));
        }

        return headerAndListOfMovies.toString();
    }

    public int getNumberOfAvailableMovies() {
        return availableMovies.size();
    }

    public void addMovie(Movie movie) {
        availableMovies.addMovie(movie);
    }

    public boolean checkoutMovie(String movieTitle) {
        Movie movie;

        if((movie = availableMovies.getMovieByTitle(movieTitle)) != null) {
            borrowedMovies.addMovie(movie);
            availableMovies.removeMovie(movie.getTitle());
            return true;
        }

        return false;
    }

    public boolean returnMovie(String movieTitle) {
        Movie movie;

        if((movie = borrowedMovies.getMovieByTitle(movieTitle)) != null) {
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
