package com.twu.biblioteca;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginHandler {
    public static String hashPassword(String password) {
        MessageDigest md;
        final String algorithm = "SHA-256";
        final String encoding = "UTF-8";

        try {
            md = MessageDigest.getInstance(algorithm);
            md.update(password.getBytes("UTF-8"));

        } catch(NoSuchAlgorithmException nsae) {
            System.err.println(algorithm + " is not a known algorithm.");
            return "";
        } catch(UnsupportedEncodingException uee) {
            System.err.println(encoding + " is not a supported encoding scheme.");
            return "";
        }

        return String.format("%064x", new java.math.BigInteger(1, md.digest()));
    }

    public String requestUsername() {
        UsernameInput input = new UsernameInput();

        System.out.println("Please enter the 7 digits of your username:");
        String username = input.getInput();
        if((username = input.getFormattedUsername(username)) == null) {
            System.out.println("Username entered is not in correct format.");
            return "";
        }

        return username;
    }

    public String requestPassword() {
        Input input = new Input();

        System.out.println("Please enter your password.");
        return input.getInput();
    }

    public boolean validateLoginDetails(LibraryManagementSystem system,
                                        String username, String password) {
        String hash = hashPassword(password);

        return system.isValidUser(username, hash);
    }

}
