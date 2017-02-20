package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    protected ArrayList<Options> userOptions;

    public User() {
        userOptions = new ArrayList<Options>();

        userOptions.add(Options.DISPLAY_BOOKS);
        userOptions.add(Options.CHECKOUT_BOOK);
        userOptions.add(Options.RETURN_BOOK);
        userOptions.add(Options.QUIT);
    }

    public String getUserOptions() {
        StringBuilder availableOptionsToUser = new StringBuilder();
        int i = 1;

        for(Options option : userOptions) {
            availableOptionsToUser.append(i + ") ");
            availableOptionsToUser.append(option.getOption());
            availableOptionsToUser.append("\n");

            ++i;
        }

        return availableOptionsToUser.toString();
    }
}
