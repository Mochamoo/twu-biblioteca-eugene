package com.twu.biblioteca;

public class LibraryManagementSystem {
    private BookList availableBooks;
    private BookList borrowedBooks;

    public LibraryManagementSystem() {
        availableBooks = new BookList();
        borrowedBooks = new BookList();
    }

    public void addBook(Book book) {
        availableBooks.addBook(book);
    }

    private String generateHeader() {
        return "Title | Author | Year Published";
    }

    public String displayBooks() {
        StringBuilder headerAndListOfBooks = new StringBuilder();
        headerAndListOfBooks.append(generateHeader());
        headerAndListOfBooks.append("\n");

        for(Book book : availableBooks.getBooks().values()) {
            headerAndListOfBooks.append(book.getTitle() + " | ");
            headerAndListOfBooks.append(book.getAuthorNames() + " | ");
            headerAndListOfBooks.append(book.getYearPublished());
            headerAndListOfBooks.append("\n");
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
}
