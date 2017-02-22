package com.twu.biblioteca;

public class LibraryManagementSystem {
    private BookList availableBooks;
    private BookList borrowedBooks;

    public LibraryManagementSystem() {
        availableBooks = new BookList();
        availableBooks.populateBookList();
        borrowedBooks = new BookList();
    }

    private String generateHeader() {
        return "Title | Author | Year Published";
    }

    public String displayBooks() {
        StringBuilder headerAndListOfBooks = new StringBuilder();
        headerAndListOfBooks.append(generateHeader() + "\n");

        for(Book book : availableBooks.getBooks().values()) {
            headerAndListOfBooks.append(book.getTitle() + " | ");
            headerAndListOfBooks.append(book.getAuthorNames() + " | ");
            headerAndListOfBooks.append(book.getYearPublished());
            headerAndListOfBooks.append("\n");
        }

        return headerAndListOfBooks.toString();
    }

    public boolean chooseBookToCheckout() {
        Input userInput = new Input();
        String selectedOption = userInput.getInput();
        Book book;

        if((book = availableBooks.getBookByTitle(selectedOption)) != null) {
            borrowedBooks.addBook(book);
            availableBooks.removeBook(book.getTitle());
            return true;
        }

        return false;
    }

    public String checkoutBook() {
        if(availableBooks.size() == 0) {
            return "\nThere are currently no books available.\n";
        }

        System.out.println("Please type the name of the book (case/symbol sensitive):");
        if(chooseBookToCheckout() == true) {
            return "\nThank you! Enjoy the book.\n";
        }

        return "\nThat book is not available.\n";
    }

    public boolean chooseBookToReturn() {
        Input userInput = new Input();
        String selectedOption = userInput.getInput();
        Book book;

        if((book = borrowedBooks.getBookByTitle(selectedOption)) != null) {
            availableBooks.addBook(book);
            borrowedBooks.removeBook(book.getTitle());
            return true;
        }

        return false;
    }

    public String returnBook() {
        if(borrowedBooks.size() == 0) {
            return "\nThere are currently no books being borrowed.\n";
        }

        System.out.println("Please type the name of the book (case/symbol sensitive):");
        if(chooseBookToReturn() == true) {
            return "\nThank you for returning the book.\n";
        }

        return "\nThat is not a valid book to return.\n";
    }
}
