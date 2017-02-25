package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.BookList;

import java.util.ArrayList;

public class BooksService {
    private BookList availableBooks;
    private BookList borrowedBooks;

    public BooksService() {
        availableBooks = new BookList();
        borrowedBooks = new BookList();
    }

    public void addBook(Book book) {
        availableBooks.addBook(book);
    }

    private String generateBookHeader() {
        return "Title | Author | Year Published";
    }

    public ArrayList<String> generateBooksDisplay() {
        ArrayList<String> headerAndListOfBooks = new ArrayList<String>();
        headerAndListOfBooks.add(generateBookHeader());

        for(Book book : availableBooks.getBooks().values()) {
            headerAndListOfBooks.add(String.format("%s | %s | %d",
                    book.getTitle(),
                    book.getAuthorNames(),
                    book.getYearPublished()));
        }
        headerAndListOfBooks.add(String.format("%n"));

        return headerAndListOfBooks;
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
}
