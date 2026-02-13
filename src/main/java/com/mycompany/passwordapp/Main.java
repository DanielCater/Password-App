package com.mycompany.passwordapp;

/**
 * @author Daniel Cater
 * @version 2/12/2026
 * 
 * This class allows for the testing of the generator and analyzer classes,
 * which are the backend of the password generator app.
 */
public class Main {

    public static void main(String[] args) {
        // Example usage of PasswordGenerator
        String password = PasswordGenerator.generator(20, true, true, true, true);
        System.out.println("Generated Password: " + password);

        // Example usage of PasswordAnalyzer
        String analysis = PasswordAnalyzer.analyze(password);
        System.out.println(analysis);
    }
}
