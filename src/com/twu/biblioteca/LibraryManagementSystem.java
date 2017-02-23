package com.twu.biblioteca;

public class LibraryManagementSystem {
    private BookList availableBooks;
    private BookList borrowedBooks;
    private User currentUser;
    private UserList users;

    public LibraryManagementSystem() {
        availableBooks = new BookList();
        borrowedBooks = new BookList();
        users = new UserList();
        currentUser = null;
    }

    public void addBook(Book book) {
        availableBooks.addBook(book);
    }

    private String generateHeader() {
        return "Title | Author | Year Published";
    }

    public String generateBooksDisplay() {
        StringBuilder headerAndListOfBooks = new StringBuilder();
        headerAndListOfBooks.append(generateHeader());
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

}
