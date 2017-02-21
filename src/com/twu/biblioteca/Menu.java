package com.twu.biblioteca;

public class Menu {
    public String welcome() {
        return "===Welcome to Biblioteca!===";
    }

    public String displayMenu(User user) {
        String menuMessage = "Please make your selection (Enter one of the numbers below):\n";
        menuMessage += user.getUserOptions();

        return menuMessage;
    }

    public void performOption(Options option, LibraryManagementSystem libSystem) {
        switch(option) {
            case LIST_BOOKS:
                System.out.println(libSystem.displayBooks());
                break;
            case CHECKOUT_BOOK:
                break;
            case RETURN_BOOK:
                break;
        }
    }

    public void loopMenu(User user, LibraryManagementSystem libSystem) {
        Input userInput = new Input(user);
        Options selectedOption = null;

        while(selectedOption != Options.QUIT) {
            selectedOption = userInput.getOption(this);
            performOption(selectedOption, libSystem);
        }
    }
}
