package com.mycompany.passwordapp;

public class Main {

    public static void main(String[] args) {
        // Example usage of PasswordGenerator
        String password = PasswordGenerator.generator(20);
        System.out.println("Generated Password: " + password);

        // Example usage of PasswordAnalyzer
        String analysis = PasswordAnalyzer.analyze(password);
        System.out.println(analysis);
    }
}
