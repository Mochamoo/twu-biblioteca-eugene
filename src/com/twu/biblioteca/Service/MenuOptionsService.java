package com.twu.biblioteca.Service;

import com.twu.biblioteca.Model.Options;

public class MenuOptionsService {
    LibraryService libSystem;

    public MenuOptionsService(LibraryService libSystem) {
        this.libSystem = libSystem;
    }

    public boolean isValidInteger(String input) {
        int userSelection;

        try {
            userSelection = Integer.parseInt(input);
            if(userSelection <= 0 || userSelection > libSystem.getNumOptions()) {
                throw new NumberFormatException();
            }

        } catch(NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public Options convertInputToOption(String input) {
        //Will be using this number to access array, so - 1
        //is needed to get correct index in userOptions
        return libSystem.getOption(Integer.parseInt(input) - 1);
    }

}
