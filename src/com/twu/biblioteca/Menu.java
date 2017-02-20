package com.twu.biblioteca;

public class Menu {
    public String welcome() {
        return "===Welcome to Biblioteca!===";
    }

    public String displayMenu(User user) {
        String menuMessage = "Please make your selection:\n";
        menuMessage += user.getUserOptions();

        return menuMessage;
    }
}
