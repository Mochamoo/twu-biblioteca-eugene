package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    public String welcome() {
        return "===Welcome to Biblioteca!===";
    }

    public String displayMenu(User user) {
        String menuMessage = "Please make your selection (Enter one of the numbers below):\n";
        menuMessage += user.getUserOptions();

        return menuMessage;
    }

    public void loopMenu(User user) {
        Input userInput = new Input(user);
        Options selectedOption = userInput.getOption(this);

        while(selectedOption != Options.QUIT) {
            selectedOption = userInput.getOption(this);
        }
    }
}
