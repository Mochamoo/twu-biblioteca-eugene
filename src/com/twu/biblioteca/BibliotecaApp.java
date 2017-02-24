package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        LibraryManagementSystem libSystem = new LibraryManagementSystem();
        libSystem.addUser(new User(new Name("Bojack", "Horseman"),
                        "micro@Gmail.com", "04112628", "000-0001",
                LoginHandler.hashPassword("64 digit hash")));

        Menu menu = new Menu();
        System.out.println(menu.generateWelcome());

        LoginHandler loginHandler = new LoginHandler();
        String username = loginHandler.requestUsername();
        if(username.equals("")) {
            return;
        }
        String password = loginHandler.requestPassword();

        if(loginHandler.validateLoginDetails(libSystem, username, password)) {
            libSystem.addBook(new Book("Test-Driven Development",
                    new AuthorNamesList(new Name("Kent", "Beck")),
                    2003));
            libSystem.addBook(new Book("Gears of War: Anvil Gate",
                    new AuthorNamesList(new Name("Karen", "Travis")),
                    2010));
            libSystem.addBook(new Book("Artificial Intelligence: A Modern Approach",
                    new AuthorNamesList(new Name("Peter", "Norvig")),
                    2010));
            libSystem.addBook(new Book("Introduction to the Design & Analysis of Algorithm",
                    new AuthorNamesList(new Name("Anany", "Levitin")),
                    2012));
            libSystem.addMovie(new Movie("Mad Max: Fury Road", 2015,
                    new Name("George", "Miller"), Rating.TEN));

            menu.loopMenu(libSystem);
        }

    }
}
