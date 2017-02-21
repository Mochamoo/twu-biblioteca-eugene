package com.twu.biblioteca;

import java.util.Scanner;

public class Input {

    public String getUserInput() {
        Scanner input = new Scanner(System.in);

        return input.nextLine();
    }

    public String validateUserInput(String input, int listSize) {
        int userSelection;

        try {
            userSelection = Integer.parseInt(input);
            if(userSelection <= 0 || userSelection > listSize) {
                throw new NumberFormatException();
            }

        } catch(NumberFormatException nfe) {
            return "Select a valid option!";
        }

        //Will be using this number to access array, so - 1
        //is needed to get correct index in userOptions
        return Integer.toString(userSelection - 1);
    }

}
