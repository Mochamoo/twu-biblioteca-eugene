package com.twu.biblioteca;

public class Menu {

    public String generateWelcome() {
        return "===Welcome to Biblioteca!===";
    }

    public String generateMenu(User user) {
        String menuMessage = "Please make your selection (Enter one of the numbers below):\n";
        menuMessage += user.getUserOptions();

        return menuMessage;
    }

    public String checkoutBook(LibraryManagementSystem libSystem) {
        if(libSystem.getNumberOfAvailableBooks() == 0) {
            return "\nThere are currently no books available.\n";
        }

        Input input = new Input();

        System.out.println("Please type the name of the book (case/symbol sensitive):");

        return libSystem.checkoutBook(input.getInput());
    }

    public String returnBook(LibraryManagementSystem libSystem) {
        if(libSystem.getNumberOfBorrowedBooks() == 0) {
            return "\nThere are currently no books being borrowed.\n";
        }

        Input input = new Input();

        System.out.println("Please type the name of the book (case/symbol sensitive):");

        return libSystem.returnBook(input.getInput());
    }

    public void performOption(Options option, LibraryManagementSystem libSystem) {
        switch(option) {
            case LIST_BOOKS:
                System.out.println(libSystem.generateBooksDisplay());
                break;
            case CHECKOUT_BOOK:
                System.out.println(checkoutBook(libSystem));
                break;
            case RETURN_BOOK:
                System.out.println(returnBook(libSystem));
                break;
            case LIST_MOVIES:
                System.out.println(libSystem.generateMoviesDisplay());
                break;
            case VIEW_USER_INFO:
                System.out.println(libSystem.generateUserInfoDisplay() + "\n");
                break;
        }
    }

    public void loopMenu(LibraryManagementSystem libSystem) {
        MenuOptionsInput userInput = new MenuOptionsInput(libSystem.getCurrentUser());
        Options selectedOption = null;

        while(selectedOption != Options.QUIT) {
            selectedOption = userInput.getOption(this);
            performOption(selectedOption, libSystem);
        }
    }
}
