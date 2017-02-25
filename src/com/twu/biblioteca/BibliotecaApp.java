package com.twu.biblioteca;

import com.twu.biblioteca.Model.*;
import com.twu.biblioteca.Service.LibraryService;
import com.twu.biblioteca.Service.LoginService;
import com.twu.biblioteca.View.Menu;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        LibraryService libSystem = app.initialiseDatabase();

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

    LibraryService initialiseDatabase() {
        LibraryService libSystem = new LibraryService();
        libSystem.addUser(new User(new Name("Bojack", "Horseman"),
                "micro@Gmail.com", "04112628", "000-0001",
                LoginService.hashPassword("64 digit hash")));
        libSystem.addBook(new Book("Test-Driven Development",
                new AuthorList(new Author("Kent", "Beck")),
                2003));
        libSystem.addBook(new Book("Gears of War: Anvil Gate",
                new AuthorList(new Author("Karen", "Travis")),
                2010));
        libSystem.addBook(new Book("Artificial Intelligence: A Modern Approach",
                new AuthorList(new Author("Peter", "Norvig")),
                2010));
        libSystem.addBook(new Book("Introduction to the Design & Analysis of Algorithm",
                new AuthorList(new Author("Anany", "Levitin")),
                2012));
        libSystem.addMovie(new Movie("Mad Max: Fury Road", 2015,
                new Director("George", "Miller"), Rating.TEN));

        return libSystem;
    }

}
