package com.twu.biblioteca;

public enum Options {
    DISPLAY_BOOKS("Display Books"), CHECKOUT_BOOK("Checkout Book"),
    RETURN_BOOK("Return Book"), QUIT("Quit");

    private String option;

    Options(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

}
