package com.twu.biblioteca;

public enum Options {
    LIST_BOOKS("List Books"), CHECKOUT_BOOK("Checkout Book"),
    RETURN_BOOK("Return Book"), LIST_MOVIES("List Movies"),
    CHECKOUT_MOVIE("Checkout Movie"), RETURN_MOVIE("Return Movie"),
    VIEW_USER_INFO("View User Info"), QUIT("Quit");

    private String option;

    Options(String option) {
        this.option = option;
    }

    public String getOptionString() {
        return option;
    }

}
