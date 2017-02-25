package com.twu.biblioteca.View;

import com.twu.biblioteca.Service.LibraryService;
import com.twu.biblioteca.Model.Options;
import com.twu.biblioteca.Service.LoginService;
import com.twu.biblioteca.Service.MenuOptionsService;
import com.twu.biblioteca.Service.UsernameService;

import java.util.ArrayList;

public class Menu {

    public String generateWelcome() {
        return "===Welcome to Biblioteca!===";
    }

    public ArrayList<String> generateMenu(LibraryService libSystem) {
        ArrayList<String> linesOfMenu = new ArrayList<String>();
        linesOfMenu.add("Please make your selection (Enter one of the numbers below):");

        for(String lineOfUserOptions : libSystem.generateUserOptionsString()) {
            linesOfMenu.add(lineOfUserOptions);
        }

        return linesOfMenu;
    }

    public String checkoutBook(LibraryService libSystem) {
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

    public String returnBook(LibraryService libSystem) {
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

    public String checkoutMovie(LibraryService libSystem) {
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

    public String returnMovie(LibraryService libSystem) {
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

    public void performOption(Options option, LibraryService libSystem) {
        switch(option) {
            case LIST_BOOKS:
                loopThroughAndDisplay(libSystem.generateBooksDisplay());
                break;
            case CHECKOUT_BOOK:
                System.out.println(checkoutBook(libSystem));
                break;
            case RETURN_BOOK:
                System.out.println(returnBook(libSystem));
                break;
            case LIST_MOVIES:
                loopThroughAndDisplay(libSystem.generateMoviesDisplay());
                break;
            case CHECKOUT_MOVIE:
                System.out.println(checkoutMovie(libSystem));
                break;
            case RETURN_MOVIE:
                System.out.println(returnMovie(libSystem));
                break;
            case VIEW_USER_INFO:
                loopThroughAndDisplay(libSystem.generateUserInfoDisplay());
                break;
        }
    }

    public Options getOptionFromUser(LibraryService libSystem) {
        MenuOptionsService optionsFormatter = new MenuOptionsService(libSystem);
        Input inputHandler = new Input();
        String input = inputHandler.getInput();

        while((optionsFormatter.isValidInteger(input)) == false) {
            System.out.println("Select a valid option!");
            loopThroughAndDisplay(generateMenu(libSystem));
            input = inputHandler.getInput();
        }

        return optionsFormatter.convertInputToOption(input);
    }

    public void loopMenu(LibraryService libSystem) {
        Options selectedOption = null;

        while(selectedOption != Options.QUIT) {
            loopThroughAndDisplay(generateMenu(libSystem));
            selectedOption = getOptionFromUser(libSystem);
            performOption(selectedOption, libSystem);
        }
    }

    public String requestUsername() {
        UsernameService usernameFormatter = new UsernameService();
        Input input = new Input();

        System.out.println("Please enter the 7 digits of your username:");
        String username = input.getInput();
        while(usernameFormatter.isInvalidUsername(username)) {
            System.out.println("Username entered is not in correct format.");
            System.out.println("Please enter the 7 digits of your username:");
            username = input.getInput();
        }
        username = usernameFormatter.getFormattedUsername(username);

        return username;
    }

    public String requestPassword() {
        Input input = new Input();

        System.out.println("Please enter your password.");
        return input.getInput();
    }

    public boolean verifyUser(LibraryService libSystem,
                              String username, String password) {
        LoginService handler = new LoginService();

        return handler.validateLoginDetails(libSystem, username, password);
    }

    public void loopThroughAndDisplay(ArrayList<String> arrayOfLines) {
        for(String singleLine : arrayOfLines) {
            System.out.println(singleLine);
        }
    }
}
