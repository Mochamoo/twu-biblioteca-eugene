package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        LibraryManagementSystem libSystem = new LibraryManagementSystem();
        Menu menu = new Menu();

        menu.loopMenu(new User(), libSystem);
    }
}
