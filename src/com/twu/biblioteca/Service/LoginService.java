package com.twu.biblioteca.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginService {

    public static String hashPassword(String password) {
        MessageDigest md;
        final String algorithm = "SHA-256";
        final String encoding = "UTF-8";

        try {
            md = MessageDigest.getInstance(algorithm);
            md.update(password.getBytes("UTF-8"));

        } catch(NoSuchAlgorithmException nsae) {
            System.err.println(algorithm + " is not a known algorithm.");
            nsae.printStackTrace();
            return "";
        } catch(UnsupportedEncodingException uee) {
            System.err.println(encoding + " is not a supported encoding scheme.");
            uee.printStackTrace();
            return "";
        }

        return String.format("%064x", new java.math.BigInteger(1, md.digest()));
    }

    public boolean validateLoginDetails(LibraryService system,
                                        String username, String password) {
        String hash = hashPassword(password);

        return system.isValidUser(username, hash);
    }

}
