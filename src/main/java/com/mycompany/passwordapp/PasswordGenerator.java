package com.mycompany.passwordapp;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Daniel Cater
 * @version 2/12/2026
 *
 * A simple password generator that creates random passwords containing
 * uppercase letters, lowercase letters, digits, and symbols.
 */
public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>?";

    private static final SecureRandom random = new SecureRandom();

    /**
     * Generates a random password of the specified length.
     *
     * @param length the desired length of the password
     * @param lower Whether to include lowercase letters
     * @param upper Whether to include uppercase letters
     * @param nums Whether to include digits
     * @param syms Whether to include special symbols
     * @return the generated password
     */
    public static String generator(int length, boolean lower, boolean upper, boolean nums, boolean syms) {
        int index;
        StringBuilder validChars = new StringBuilder();
        List<String> requiredPools = new ArrayList<>();

        
        if(!lower && !upper && !nums && !syms) return "Must select character type(s)";
        if(lower){
            validChars.append(LOWER);
            requiredPools.add(LOWER);
        }
        if(upper){
            validChars.append(UPPER);
            requiredPools.add(UPPER);
        }
        if(nums){
            validChars.append(DIGITS);
            requiredPools.add(DIGITS);
        }
        if(syms){
            validChars.append(SYMBOLS);
            requiredPools.add(SYMBOLS);
        }
        
        if(length < requiredPools.size()){
            return "Length must be at least the same as number of types selected!";
        }
        
        StringBuilder password = new StringBuilder(length);
        
        for (String pool : requiredPools) {
            password.append(pool.charAt(random.nextInt(pool.length())));
        }
        
        for (int i = requiredPools.size(); i < length; i++) {
            index = random.nextInt(validChars.length());
            password.append(validChars.charAt(index));
        }
        
        List<Character> chars = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars, random);

        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            result.append(c);
        }

        return result.toString();
    }
}
