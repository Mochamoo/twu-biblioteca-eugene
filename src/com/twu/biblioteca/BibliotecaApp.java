package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        LibraryManagementSystem libSystem = new LibraryManagementSystem();
        libSystem.initialiseDatabase();

        Menu menu = new Menu();
        System.out.println(menu.generateWelcome());

        String username = menu.requestUsername();
        String password = menu.requestPassword();

        if(menu.verifyUser(libSystem, username, password)) {
            menu.loopMenu(libSystem);
        }
        else {
            System.out.println("A user with those credentials do not exist.");
        }

    }

}
