package com.twu.biblioteca;

public class BooksManager {
    private BookList availableBooks;
    private BookList borrowedBooks;

    public BooksManager() {
        availableBooks = new BookList();
        borrowedBooks = new BookList();
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
}
