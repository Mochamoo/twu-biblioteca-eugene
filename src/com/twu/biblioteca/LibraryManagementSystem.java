package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryManagementSystem {
    private BookList availableBooks;
    private BookList borrowedBooks;
    private MovieList availableMovies;
    private MovieList borrowedMovies;
    private User currentUser;
    private ArrayList<Options> userOptions;
    private UserList users;

    public LibraryManagementSystem() {
        availableBooks = new BookList();
        borrowedBooks = new BookList();
        availableMovies = new MovieList();
        borrowedMovies = new MovieList();
        users = new UserList();
        currentUser = null;

        userOptions = new ArrayList<Options>();
        userOptions.add(Options.LIST_BOOKS);
        userOptions.add(Options.CHECKOUT_BOOK);
        userOptions.add(Options.RETURN_BOOK);
        userOptions.add(Options.LIST_MOVIES);
        userOptions.add(Options.CHECKOUT_MOVIE);
        userOptions.add(Options.RETURN_MOVIE);
        userOptions.add(Options.VIEW_USER_INFO);
        userOptions.add(Options.QUIT);
    }

    public void addBook(Book book) {
        availableBooks.addBook(book);
    }

    private String generateBookHeader() {
        return "Title | Author | Year Published";
    }

    public String generateBooksDisplay() {
        StringBuilder headerAndListOfBooks = new StringBuilder();
        headerAndListOfBooks.append(generateBookHeader());
        headerAndListOfBooks.append("\n");

        for(Book book : availableBooks.getBooks().values()) {
            headerAndListOfBooks.append(String.format("%s | %s | %d\n",
                    book.getTitle(),
                    book.getAuthorNames(),
                    book.getYearPublished()));
        }

        return headerAndListOfBooks.toString();
    }

    public boolean checkoutBook(String bookTitle) {
        Book book;

        if((book = availableBooks.getBookByTitle(bookTitle)) != null) {
            borrowedBooks.addBook(book);
            availableBooks.removeBook(book.getTitle());
            return true;
        }

        return false;
    }

    public boolean returnBook(String bookTitle) {
        Book book;

        if((book = borrowedBooks.getBookByTitle(bookTitle)) != null) {
            availableBooks.addBook(book);
            borrowedBooks.removeBook(book.getTitle());
            return true;
        }

        return false;
    }

    public int getNumberOfAvailableBooks() {
        return availableBooks.size();
    }

    public int getNumberOfBorrowedBooks() {
        return borrowedBooks.size();
    }

    public void addUser(User user) {
        users.addUser(user);
    }

    public int getNumberOfUsers() {
        return users.size();
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public boolean isValidUser(String username, String hash) {
        if(users.isValidUser(username, hash)) {
            setCurrentUser(users.getUserByUsername(username));
            return true;
        }

        return false;
    }

    public String generateUserInfoDisplay() {
        String userInfo = "Name: " + currentUser.getFullName() + "\n";
        userInfo += "E-mail: " + currentUser.getEmail() + "\n";
        userInfo += "Phone: " + currentUser.getPhoneNumber();

        return userInfo;
    }

    public String generateUserOptionsString() {
        StringBuilder availableOptionsToUser = new StringBuilder();
        int i = 1;

        for(Options option : userOptions) {
            availableOptionsToUser.append(
                    String.format("%d) %s\n", i, option.getOptionString()));

            ++i;
        }

        return availableOptionsToUser.toString();
    }

    public int getNumOptions() {
        return userOptions.size();
    }

    public Options getOption(int index) {
        return userOptions.get(index);
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
