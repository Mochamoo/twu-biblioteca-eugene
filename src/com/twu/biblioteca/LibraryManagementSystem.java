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
        StringBuilder headerAndListOfBooks = new StringBuilder();
        headerAndListOfBooks.append(displayHeader() + "\n");

        for(Book book : availableBooks.getBooks().values()) {
            headerAndListOfBooks.append(book.getTitle() + " | ");
            headerAndListOfBooks.append(book.getAuthor() + " | ");
            headerAndListOfBooks.append(book.getYearPublished());
            headerAndListOfBooks.append("\n");
        }

        return headerAndListOfBooks.toString();
    }

    public boolean chooseBook() {
        CheckoutOptionsInput userInput = new CheckoutOptionsInput();
        String selectedOption = userInput.getUserInput();
        Book book;

        if((book = availableBooks.getBookByTitle(selectedOption)) != null) {
            borrowedBooks.addBook(book);
            availableBooks.removeBook(book.getTitle());
            return true;
        }

        return false;
    }

    public String checkoutBook() {
        System.out.println("Please type the name of the book (case/symbol sensitive):");
        if(chooseBook() == true) {
            return "Thank you! Enjoy the book.";
        }

        return "That book is not available.";
    }
}
