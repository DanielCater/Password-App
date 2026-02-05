package com.mycompany.passwordapp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Daniel Cater
 * @version 2/4/2026
 *
 * A simple password analyzer that evaluates the strength of a given password
 * based on its length and character variety.
 */
public class PasswordAnalyzer {

    private static final Set<Character> UPPERCASE = new HashSet<>();
    private static final Set<Character> LOWERCASE = new HashSet<>();
    private static final Set<Character> DIGITS = new HashSet<>();
    private static final Set<Character> SYMBOLS = new HashSet<>();

    static {
        for (char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
            UPPERCASE.add(c);
        }
        for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            LOWERCASE.add(c);
        }
        for (char c : "0123456789".toCharArray()) {
            DIGITS.add(c);
        }
        for (char c : "!@#$%^&*()-_=+[]{};:,.<>?".toCharArray()) {
            SYMBOLS.add(c);
        }
    }

    /**
     * Analyzes the strength of the given password. Total score is out of 40
     * points: - Length: up to 20 points (1 point per character, max 20) -
     * Character Variety: up to 20 points (5 points per unique character type)
     *
     * @param password Password to be analyzed
     * @return A string describing the password's strength and score
     */
    public static String analyze(String password) {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        for (char c : password.toCharArray()) {
            if (hasUpper && hasLower && hasDigit && hasSymbol) {
                break;
            }
            if (UPPERCASE.contains(c)) {
                hasUpper = true;
            } else if (LOWERCASE.contains(c)) {
                hasLower = true;
            } else if (DIGITS.contains(c)) {
                hasDigit = true;
            } else if (SYMBOLS.contains(c)) {
                hasSymbol = true;
            }
        }

        int lengthScore = Math.min(password.length(), 20);

        int totalScore = lengthScore;
        if (hasUpper) {
            totalScore += 5;
        }
        if (hasLower) {
            totalScore += 5;
        }
        if (hasDigit) {
            totalScore += 5;
        }
        if (hasSymbol) {
            totalScore += 5;
        }

        String result = "Password Analysis:\n";
        result += "Length Score: " + lengthScore + "/20\n";
        result += "Contains Uppercase: " + (hasUpper ? "Yes" : "No") + "\n";
        result += "Contains Lowercase: " + (hasLower ? "Yes" : "No") + "\n";
        result += "Contains Digit: " + (hasDigit ? "Yes" : "No") + "\n";
        result += "Contains Symbol: " + (hasSymbol ? "Yes" : "No") + "\n";

        return result + "Password Score: " + totalScore + "\n";
    }
}
