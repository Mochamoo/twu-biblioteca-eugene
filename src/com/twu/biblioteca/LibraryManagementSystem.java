package com.twu.biblioteca;

public class LibraryManagementSystem {
    private BookList availableBooks;
    private BookList borrowedBooks;

    public LibraryManagementSystem() {
        availableBooks = new BookList();
        availableBooks.populateBookList();
        borrowedBooks = new BookList();
    }

    private String displayHeader() {
        return "Title | Author | Year Published";
    }

    public String displayBooks() {
        String headerAndListOfBooks = displayHeader() + "\n";
        int bookNumber = 1;

        for(Book book : availableBooks.getBooks()) {
            headerAndListOfBooks += bookNumber + ") " + book.getTitle() + " | " +
                                  book.getAuthor() + " | " +
                                  book.getYearPublished() +
                                  "\n";
            ++bookNumber;
        }

        return headerAndListOfBooks;
    }

    public String chooseBook() {
        return "";
    }

    public String checkoutBook() {
        return "";
    }
}
