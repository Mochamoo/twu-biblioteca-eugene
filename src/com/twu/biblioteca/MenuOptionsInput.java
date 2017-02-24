package com.twu.biblioteca;

public class MenuOptionsInput extends Input {
    LibraryManagementSystem libSystem;

    public MenuOptionsInput(LibraryManagementSystem libSystem) {
        this.libSystem = libSystem;
    }

    public String validateAgainstOptions(String input) {
        int userSelection;

        try {
            userSelection = Integer.parseInt(input);
            if(userSelection <= 0 || userSelection > libSystem.getNumOptions()) {
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
        return libSystem.getOption(Integer.parseInt(input));
    }

    public Options getOption(Menu menu) {
        String input = null;

        while(input == null || input == "Select a valid option!") {
            if(input == "Select a valid option!") {
                System.out.println("Select a valid option!");
            }
            System.out.println(menu.generateMenu(libSystem));
            input = validateAgainstOptions(getInput());
        }

        return convertInputToOption(input);
    }
}
