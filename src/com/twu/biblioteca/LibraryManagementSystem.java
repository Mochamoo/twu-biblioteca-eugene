package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryManagementSystem {
    BooksManager booksManager;
    MoviesManager moviesManager;
    private User currentUser;
    private ArrayList<Options> userOptions;
    private UserList users;

    public LibraryManagementSystem() {
        booksManager = new BooksManager();
        moviesManager = new MoviesManager();
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
        booksManager.addBook(book);
    }

    public String generateBooksDisplay() {
        return booksManager.generateBooksDisplay();
    }

    public boolean checkoutBook(String bookTitle) {
        return booksManager.checkoutBook(bookTitle);
    }

    public boolean returnBook(String bookTitle) {
        return booksManager.returnBook(bookTitle);
    }

    public int getNumberOfAvailableBooks() {
        return booksManager.getNumberOfAvailableBooks();
    }

    public int getNumberOfBorrowedBooks() {
        return booksManager.getNumberOfBorrowedBooks();
    }

    public String generateMoviesDisplay() {
        return moviesManager.generateMoviesDisplay();
    }

    public int getNumberOfAvailableMovies() {
        return moviesManager.getNumberOfAvailableMovies();
    }

    public int getNumberOfBorrowedMovies() {
        return moviesManager.getNumberOfBorrowedMovies();
    }

    public void addMovie(Movie movie) {
        moviesManager.addMovie(movie);
    }

    public boolean checkoutMovie(String movieTitle) {
        return moviesManager.checkoutMovie(movieTitle);
    }

    public boolean returnMovie(String movieTitle) {
        return moviesManager.returnMovie(movieTitle);
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

}
