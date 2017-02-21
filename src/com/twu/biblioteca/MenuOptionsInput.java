package com.twu.biblioteca;

public class MenuOptionsInput extends Input {
    User user;

    public MenuOptionsInput(User user) {
        this.user = user;
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
            System.out.println(menu.displayMenu(user));
            input = validateUserInput(getUserInput(), user.getNumOptions());
        }

        return convertInputToOption(input);
    }
}
