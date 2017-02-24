package com.twu.biblioteca.Service;

public class UsernameInput extends Input {

    public boolean isCorrectLength(String username) {
        if(username.length() == 7) {
            return true;
        }

        return false;
    }

    public boolean isInteger(String username) {
        try {
            Integer.parseInt(username);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public String getFormattedUsername(String username) {
        if(isCorrectLength(username) && isInteger(username)) {
            String firstThreeDigits = username.substring(0, 3);
            String lastFourDigits = username.substring(3, 7);
            return String.format("%s-%s", firstThreeDigits, lastFourDigits);
        }

        return null;
    }
}
