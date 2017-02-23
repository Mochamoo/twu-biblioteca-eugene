package com.twu.biblioteca;

import java.util.HashMap;

public class UserList {
    HashMap<String, User> users;

    public UserList() {
        users = new HashMap<String, User>();
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public int size() {
        return users.size();
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }


    public boolean isValidUser(String username, String hash) {
        User user;

        if((user = getUserByUsername(username)) != null &&
           user.getHash().equals(hash)) {
            return true;
        }

        return false;
    }
}
