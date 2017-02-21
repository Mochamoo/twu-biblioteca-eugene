package com.twu.biblioteca;

import java.util.Scanner;

public class Input {
    User user;

    public Input(User user) {
        this.user = user;
    }

    public String getUserInput() {
        Scanner input = new Scanner(System.in);

        return input.next();
    }

    public String validateUserInput(String input) {
        int userSelection;

        try {
            userSelection = Integer.parseInt(input);
            if(userSelection <= 0 || userSelection > user.userOptions.size()) {
                throw new NumberFormatException();
            }

        } catch(NumberFormatException nfe) {
            return "Select a valid option!";
        }

        //Will be using this number to access array, so - 1
        //is needed to get correct index in userOptions
        return Integer.toString(userSelection - 1);
    }

    public Options convertInputToOption(String input) {
        return user.userOptions.get(Integer.parseInt(input));
    }

    public Options getOption(Menu menu) {
        String input = null;

        while(input == null || input == "Select a valid option!") {
            if(input == "Select a valid option!") {
                System.out.println("Select a valid option!");
            }
            System.out.println(menu.displayMenu(user));
            input = validateUserInput(getUserInput());
        }

        return convertInputToOption(input);
    }
}
