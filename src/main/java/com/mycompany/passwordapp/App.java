package com.mycompany.passwordapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Daniel Cater
 * @version 2/4/2026
 * 
 * A GUI for the password generator and analyzer. It contains tabs for each 
 * function and allows for easy use and copying of the password generated.
 */
public class App extends Application {

    /**
     * Creates the window for the App and launches it.
     * 
     * @param stage The window to be launched
     */
    @Override
    public void start(Stage stage) {
        
        // --- Generator UI ---
        TextField inputLength = new TextField();
        Button generateBtn = new Button("Generate");
        TextField outputPassword = new TextField();
        outputPassword.setEditable(false);
        outputPassword.setFocusTraversable(false);
        
        
        inputLength.setPromptText("Enter a length");
        
        // Center output
        outputPassword.setAlignment(Pos.CENTER);
        
        // Generate password via "Enter" key or button press
        inputLength.setOnAction(event -> generateBtn.fire());
        generateBtn.setOnAction(event -> {
            String password = PasswordGenerator.generator(Integer.parseInt(inputLength.getText()));
            outputPassword.setText(password);
        });
        
        // Layout for generator tab with padding on edges
        VBox generatorLayout = new VBox(10, inputLength, generateBtn, outputPassword);
        generatorLayout.setPadding(new Insets(20));

        // --- Analyzer UI ---
        TextField inputPassword = new TextField();
        Button analyzeBtn = new Button("Analyze");
        Label outputAnalysis = new Label();

        inputPassword.setPromptText("Enter a password");
        
        // Analyze password on "Enter" key press or button press
        inputPassword.setOnAction(event -> analyzeBtn.fire());
        analyzeBtn.setOnAction(event -> {
            String results = PasswordAnalyzer.analyze(inputPassword.getText());
            outputAnalysis.setText(results);
        });

        // Analuzer tab layout, centered, with padding on edges
        VBox analyzerLayout = new VBox(10, inputPassword, analyzeBtn, outputAnalysis);
        analyzerLayout.setAlignment(Pos.TOP_CENTER);
        analyzerLayout.setPadding(new Insets(20));

        // --- Tabs ---
        Tab generatorTab = new Tab("Generator", generatorLayout);
        Tab analyzerTab = new Tab("Analyzer", analyzerLayout);
        generatorTab.setClosable(false);
        analyzerTab.setClosable(false);
        
        TabPane tabs = new TabPane(generatorTab, analyzerTab);
        
        Scene scene = new Scene(tabs, 400, 400);

        stage.setTitle("Password Tool");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches the GUI for the app
     * 
     * @param args None used
     */
    public static void main(String[] args) {
        launch();
    }
}