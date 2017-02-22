package com.twu.biblioteca;

public class MenuOptionsInput extends Input {
    User user;

    public MenuOptionsInput(User user) {
        this.user = user;
    }

    public String validateAgainstOptions(String input) {
        int userSelection;

        try {
            userSelection = Integer.parseInt(input);
            if(userSelection <= 0 || userSelection > user.getNumOptions()) {
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
        return user.getOption(Integer.parseInt(input));
    }

    public Options getOption(Menu menu) {
        String input = null;

        while(input == null || input == "Select a valid option!") {
            if(input == "Select a valid option!") {
                System.out.println("Select a valid option!");
            }
            System.out.println(menu.generateMenu(user));
            input = validateAgainstOptions(getInput());
        }

        return convertInputToOption(input);
    }
}