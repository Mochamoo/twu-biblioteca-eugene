package com.twu.biblioteca;

public class LibraryManagementSystem {
    private BookList bookList;

    public LibraryManagementSystem() {
        bookList = new BookList();
    }

    private String displayHeader() {
        return "Title | Author | Year Published";
    }

    public String displayBooks() {
        String headerAndListOfBooks = displayHeader() + "\n";

        for(Book book : bookList.getBooks()) {
            headerAndListOfBooks += book.getTitle() + " | " +
                                  book.getAuthor() + " | " +
                                  book.getYearPublished() +
                                  "\n";
        }

        return headerAndListOfBooks;
    }
}
