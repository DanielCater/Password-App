package com.mycompany.passwordapp;

import java.security.SecureRandom;

/**
 * @author Daniel Cater
 * @version 2/4/2026
 *
 * A simple password generator that creates random passwords containing
 * uppercase letters, lowercase letters, digits, and symbols.
 */
public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>?";

    private static final String ALL_CHARACTERS = UPPER + LOWER + DIGITS + SYMBOLS;

    private static final SecureRandom random = new SecureRandom();

    /**
     * Generates a random password of the specified length.
     *
     * @param length the desired length of the password
     * @return the generated password
     */
    public static String generator(int length) {
        int index;
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            index = random.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(index));
        }
        return password.toString();
    }
}
