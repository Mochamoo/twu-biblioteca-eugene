package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserListTest {
    private UserList users;

    @Before
    public void setup() {
       users = new UserList();
    }

    @Test
    public void addUserShouldAddAnExtraUserToUserList() {
        users.addUser(new User("123-4567", "Horse"));

        assertEquals(1, users.size());
    }

    @Test
    public void getUserByNameShouldReturnUserWithMatchingUsername() {
        users.addUser(new User("000-0001", "64 digit hash"));

        assertEquals("64 digit hash", users.getUserByUsername("000-0001").getHash());
    }

    @Test
    public void isValidUserShouldReturnTrueForUserWithMatchingUsernameAndHash() {
        users.addUser(new User("000-0001", "64 digit hash"));

        assertEquals(true, users.isValidUser("000-0001", "64 digit hash"));
    }

    @Test
    public void isValidUserShouldReturnFalseIfNoMatchingUser() {
        assertEquals(false, users.isValidUser("000-0001", "64 digit hash"));
    }

}