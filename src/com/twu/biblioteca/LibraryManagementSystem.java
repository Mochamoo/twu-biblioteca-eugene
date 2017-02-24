package com.twu.biblioteca;

public class LibraryManagementSystem {
    private BookList availableBooks;
    private BookList borrowedBooks;
    private MovieList availableMovies;
    private MovieList borrowedMovies;
    private User currentUser;
    private UserList users;

    public LibraryManagementSystem() {
        availableBooks = new BookList();
        borrowedBooks = new BookList();
        availableMovies = new MovieList();
        borrowedMovies = new MovieList();
        users = new UserList();
        currentUser = null;
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

    public String checkoutBook(String bookTitle) {
        Book book;

        if((book = availableBooks.getBookByTitle(bookTitle)) != null) {
            borrowedBooks.addBook(book);
            availableBooks.removeBook(book.getTitle());
            return "\nThank you! Enjoy the book.\n";
        }

        return "\nThat book is not available.\n";
    }

    public String returnBook(String bookTitle) {
        Book book;

        if((book = borrowedBooks.getBookByTitle(bookTitle)) != null) {
            availableBooks.addBook(book);
            borrowedBooks.removeBook(book.getTitle());
            return "\nThank you for returning the book.\n";
        }

        return "\nThat is not a valid book to return.\n";
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

    public User getCurrentUser() {
        return currentUser;
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

    public String checkoutMovie(String movieTitle) {
        Movie movie;

        if((movie = availableMovies.getMovieByTitle(movieTitle)) != null) {
            borrowedMovies.addMovie(movie);
            availableMovies.removeMovie(movie.getTitle());
            return "\nThank you! Enjoy the movie.\n";
        }

        return "\nThat movie is not available.\n";
    }
}
