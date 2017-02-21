package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        User customer = new User();
        Menu menu = new Menu();

        menu.loopMenu(customer);
    }
}
