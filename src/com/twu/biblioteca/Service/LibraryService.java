package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.*;

import java.util.ArrayList;

public class LibraryService {
    BooksService booksService;
    MoviesService moviesService;
    private User currentUser;
    private ArrayList<Options> userOptions;
    private UserList users;

    public LibraryService() {
        booksService = new BooksService();
        moviesService = new MoviesService();
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
        booksService.addBook(book);
    }

    public ArrayList<String> generateBooksDisplay() {
        return booksService.generateBooksDisplay();
    }

    public boolean checkoutBook(String bookTitle) {
        return booksService.checkoutBook(bookTitle);
    }

    public boolean returnBook(String bookTitle) {
        return booksService.returnBook(bookTitle);
    }

    public int getNumberOfAvailableBooks() {
        return booksService.getNumberOfAvailableBooks();
    }

    public int getNumberOfBorrowedBooks() {
        return booksService.getNumberOfBorrowedBooks();
    }

    public ArrayList<String> generateMoviesDisplay() {
        return moviesService.generateMoviesDisplay();
    }

    public int getNumberOfAvailableMovies() {
        return moviesService.getNumberOfAvailableMovies();
    }

    public int getNumberOfBorrowedMovies() {
        return moviesService.getNumberOfBorrowedMovies();
    }

    public void addMovie(Movie movie) {
        moviesService.addMovie(movie);
    }

    public boolean checkoutMovie(String movieTitle) {
        return moviesService.checkoutMovie(movieTitle);
    }

    public boolean returnMovie(String movieTitle) {
        return moviesService.returnMovie(movieTitle);
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

    public ArrayList<String> generateUserInfoDisplay() {
        ArrayList<String> linesOfUserInfo = new ArrayList<String>();

        linesOfUserInfo.add("Name: " + currentUser.getFullName());
        linesOfUserInfo.add("E-mail: " + currentUser.getEmail());
        linesOfUserInfo.add("Phone: " + currentUser.getPhoneNumber());
        linesOfUserInfo.add(String.format("%n"));

        return linesOfUserInfo;
    }

    public ArrayList<String> generateUserOptionsString() {
        ArrayList<String> linesOfUserOptions = new ArrayList<String>();
        int i = 1;

        for(Options option : userOptions) {
            linesOfUserOptions.add(String.format("%d) %s",
                    i, option.getOptionString()));

            ++i;
        }

        return linesOfUserOptions;
    }

    public int getNumOptions() {
        return userOptions.size();
    }

    public Options getOption(int index) {
        return userOptions.get(index);
    }

}
