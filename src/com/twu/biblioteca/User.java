package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String username;
    private String hash;
    private ArrayList<Options> userOptions;

    public User(String username, String password) {
        this.username = username;
        this.hash = password;

        userOptions = new ArrayList<Options>();

        userOptions.add(Options.LIST_BOOKS);
        userOptions.add(Options.CHECKOUT_BOOK);
        userOptions.add(Options.RETURN_BOOK);
        userOptions.add(Options.LIST_MOVIES);
        userOptions.add(Options.CHECKOUT_MOVIE);
        userOptions.add(Options.RETURN_MOVIE);
        userOptions.add(Options.VIEW_USER_INFO);
        userOptions.add(Options.QUIT);
    }

    public String getUserOptions() {
        StringBuilder availableOptionsToUser = new StringBuilder();
        int i = 1;

        for(Options option : userOptions) {
            availableOptionsToUser.append(
                    String.format("%d) %s\n", i, option.getOptionString()));

            ++i;
        }

        return availableOptionsToUser.toString();
    }

    public int getNumOptions() {
        return userOptions.size();
    }

    public Options getOption(int index) {
        return userOptions.get(index);
    }

    public String getUsername() {
        return username;
    }

    public String getHash() {
        return hash;
    }
}
