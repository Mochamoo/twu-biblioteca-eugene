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

        for(Book book : availableBooks.getBooks()) {
            headerAndListOfBooks += book.getTitle() + " | " +
                                  book.getAuthor() + " | " +
                                  book.getYearPublished() +
                                  "\n";
        }

        return headerAndListOfBooks;
    }

    public String checkoutBook() {
        return "";
    }
}
