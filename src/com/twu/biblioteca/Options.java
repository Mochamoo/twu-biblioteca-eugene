package com.twu.biblioteca;

public enum Options {
    LIST_BOOKS("List Books"), CHECKOUT_BOOK("Checkout Book"),
    RETURN_BOOK("Return Book"), QUIT("Quit");

    private String option;

    Options(String option) {
        this.option = option;
    }

    public String getOptionString() {
        return option;
    }

}
