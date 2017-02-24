package com.twu.biblioteca.View;

import com.twu.biblioteca.Model.LibraryManagementSystem;
import com.twu.biblioteca.Model.Options;
import com.twu.biblioteca.Service.Input;
import com.twu.biblioteca.Service.LoginHandler;
import com.twu.biblioteca.Service.MenuOptionsService;
import com.twu.biblioteca.Service.UsernameService;

public class Menu {

    public String generateWelcome() {
        return "===Welcome to Biblioteca!===";
    }

    public String generateMenu(LibraryManagementSystem libSystem) {
        String menuMessage = "Please make your selection (Enter one of the numbers below):\n";
        menuMessage += libSystem.generateUserOptionsString();

        return menuMessage;
    }

    public String checkoutBook(LibraryManagementSystem libSystem) {
        if(libSystem.getNumberOfAvailableBooks() == 0) {
            return "There are currently no books available.";
        }

        Input input = new Input();

        System.out.println("Please type the name of the book (case/symbol sensitive):");

        if(libSystem.checkoutBook(input.getInput()) == true) {
            return "Thank you! Enjoy the book.";
        }

        return "That book is not available.";
    }

    public String returnBook(LibraryManagementSystem libSystem) {
        if(libSystem.getNumberOfBorrowedBooks() == 0) {
            return "There are currently no books being borrowed.";
        }

        Input input = new Input();

        System.out.println("Please type the name of the book (case/symbol sensitive):");

        if(libSystem.returnBook(input.getInput()) == true) {
            return "Thank you for returning the book.";
        }
        return "That is not a valid book to return.";
    }

    public String checkoutMovie(LibraryManagementSystem libSystem) {
        if(libSystem.getNumberOfAvailableMovies() == 0) {
            return "There are currently no movies available.";
        }

        Input input = new Input();

        System.out.println("Please type the name of the movie (case/symbol sensitive):");

        if(libSystem.checkoutMovie(input.getInput())) {
            return "Thank you! Enjoy the movie.";
        }

        return "That movie is unavailable.";
    }

    public String returnMovie(LibraryManagementSystem libSystem) {
        if(libSystem.getNumberOfBorrowedMovies() == 0) {
            return "There are currently no movies being borrowed.";
        }

        Input input = new Input();

        System.out.println("Please type the name of the movie (case/symbol sensitive):");

        if(libSystem.returnMovie(input.getInput()) == true) {
            return "Thank you for returning the movie.";
        }
        return "That is not a valid movie to return.";
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
            case CHECKOUT_MOVIE:
                System.out.println(checkoutMovie(libSystem));
                break;
            case RETURN_MOVIE:
                System.out.println(returnMovie(libSystem));
                break;
            case VIEW_USER_INFO:
                System.out.println(libSystem.generateUserInfoDisplay() + "\n");
                break;
        }
    }

    public Options getOptionFromUser(LibraryManagementSystem libSystem) {
        MenuOptionsService optionsFormatter = new MenuOptionsService(libSystem);
        Input inputHandler = new Input();
        String input = inputHandler.getInput();

        while((input = optionsFormatter.validateAgainstOptions(input)) == null) {
            System.out.println("Select a valid option!");
            System.out.println(generateMenu(libSystem));
            input = inputHandler.getInput();
        }

        return optionsFormatter.convertInputToOption(input);
    }

    public void loopMenu(LibraryManagementSystem libSystem) {
        Options selectedOption = null;

        while(selectedOption != Options.QUIT) {
            System.out.println(generateMenu(libSystem));
            selectedOption = getOptionFromUser(libSystem);
            performOption(selectedOption, libSystem);
        }
    }

    public String requestUsername() {
        UsernameService usernameFormatter = new UsernameService();
        Input input = new Input();

        System.out.println("Please enter the 7 digits of your username:");
        String username = input.getInput();
        while((username = usernameFormatter.getFormattedUsername(username)) == null) {
            System.out.println("Username entered is not in correct format.");
            System.out.println("Please enter the 7 digits of your username:");
            username = input.getInput();
        }

        return username;
    }

    public String requestPassword() {
        Input input = new Input();

        System.out.println("Please enter your password.");
        return input.getInput();
    }

    public boolean verifyUser(LibraryManagementSystem libSystem,
                              String username, String password) {
        LoginHandler handler = new LoginHandler();

        return handler.validateLoginDetails(libSystem, username, password);
    }
}
