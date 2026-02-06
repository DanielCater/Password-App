package com.mycompany.passwordapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Daniel Cater
 * @version 2/4/2026
 * 
 * A GUI for the password generator and analyzer. It contains tabs for each 
 * function and allows for easy use and copying of the password generated.
 * There is also a history tab to see past generated and analyzed passwords.
 */
public class App extends Application {

    /**
     * Creates the window for the App and launches it.
     * 
     * @param stage The window to be launched
     */
    @Override
    public void start(Stage stage) {
        
        // Initialize history to be used by processes
        TextArea history = new TextArea("History is currently empty");
        history.setEditable(false);
        history.setWrapText(true);
        
        // --- Generator UI ---
        TextField inputLength = new TextField();
        Button generateBtn = new Button("Generate");
        TextField outputPassword = new TextField();
        outputPassword.setEditable(false);
        outputPassword.setFocusTraversable(false);
        
        // Resets input error style when you start typing
        inputLength.textProperty().addListener((obs, oldVal, newVal) -> {
            inputLength.setStyle(""); // Clear red border when typing
        });
        
        inputLength.setPromptText("Enter a length");
        
        // Center output
        outputPassword.setAlignment(Pos.CENTER);
        
        // Generate password via "Enter" key or button press
        inputLength.setOnAction(event -> generateBtn.fire());
        generateBtn.setOnAction(event -> {
            int length = Integer.parseInt(inputLength.getText());
            
            if(length > 100){
                // Add red boarder for too large of a value 
                inputLength.setStyle("-fx-border-color: red; -fx-border-width: 2;");
                
                outputPassword.setText("Invalid input! Value too large. ");
            }
            else if(length < 1){
                // Add red boarder for too small of a value
                inputLength.setStyle("-fx-border-color: red; -fx-border-width: 2;");
                
                outputPassword.setText("Invalid input! Value too small.");
            }
            else{
                try{
                    // Reset any error styling
                    inputLength.setStyle("");

                    String password = PasswordGenerator.generator(length);
                    outputPassword.setText(password);

                    // Add to history
                    String currentText = history.getText();
                    if(currentText.equals("History is currently empty")){
                        history.setText("Generated:\n\t" + password + "\n");
                    } else{
                        history.setText(currentText + "Generated:\n\t" + password + "\n");
                    }
                }catch(NumberFormatException e){
                    // Add red boarder for invalid character
                    inputLength.setStyle("-fx-border-color: red; -fx-border-width: 2;");

                    outputPassword.setText("Invalid input! Please enter a valid integer");
                }
            }
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
            
            // Add to history
            String indentedText = results.replace("\n", "\n\t");
            String currentText = history.getText();
            if(currentText.equals("History is currently empty")){
                history.setText("Analysis:\n\t" + indentedText + "\n");
            } else{
                history.setText(currentText + "Analysis:\n\t" + indentedText + "\n");
            }
        });

        // Analuzer tab layout, centered, with padding on edges
        VBox analyzerLayout = new VBox(10, inputPassword, analyzeBtn, outputAnalysis);
        analyzerLayout.setAlignment(Pos.TOP_CENTER);
        analyzerLayout.setPadding(new Insets(20));
        
        // --- History ---
        history.setPrefHeight(350);
        history.setPrefHeight(350);
        VBox historyLayout = new VBox(10, history);
        historyLayout.setPadding(new Insets(20));
        VBox.setVgrow(history, Priority.ALWAYS);

        // --- Settings ---
        Button darkModeToggle = new Button("Dark Mode");
        
        VBox settingsLayout = new VBox(20, darkModeToggle);
        settingsLayout.setAlignment(Pos.TOP_CENTER);
        settingsLayout.setPadding(new Insets(20));
        
        // --- Tabs ---
        Tab generatorTab = new Tab("Generator", generatorLayout);
        Tab analyzerTab = new Tab("Analyzer", analyzerLayout);
        Tab historyTab = new Tab("History", historyLayout);
        Tab settingsTab = new Tab("Settings", settingsLayout);
        generatorTab.setClosable(false);
        analyzerTab.setClosable(false);
        historyTab.setClosable(false);
        settingsTab.setClosable(false);
        
        TabPane tabs = new TabPane(generatorTab, analyzerTab, 
                               historyTab, settingsTab);
        
        Scene scene = new Scene(tabs, 400, 400);
        
        // Toggle light or dark mode on button press
        darkModeToggle.setOnAction(event -> {
            if (scene.getStylesheets().isEmpty()) {
                // Turn on dark mode
                scene.getStylesheets().add(getClass().getResource("/darkmode.css").toExternalForm());
                darkModeToggle.setText("Light Mode");
            } else {
                // Turn off dark mode
                scene.getStylesheets().clear();
                darkModeToggle.setText("Dark Mode");
            }
        });
        
        // Create window
        stage.setTitle("Password Tool");
        stage.setMinHeight(300);
        stage.setMinWidth(300);
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