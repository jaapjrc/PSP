package com.example.psp_a2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("PSP_A2");
        stage.setScene(scene);
        stage.show();
    }

    public static void setAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Aviso");
        alert.setContentText("Proceso completado correctamente");
        alert.showAndWait();
    }


    public static void ping(){
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("cmd.exe", "/c", "ping -n 3 google.com > output_ping.txt");

        try {
            Process process = processBuilder.start();
            setAlert();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dir(){
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("cmd.exe", "/c", "dir > output_dir.txt");

        try {
            Process process = processBuilder.start();
            setAlert();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void help(){
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("cmd.exe", "/c", "help > output_help.txt");

        try {
            Process process = processBuilder.start();
            setAlert();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void calculator(){
        ProcessBuilder pbWinCalc = new ProcessBuilder ("cmd.exe", "/c", "C:/Windows/System32/calc.exe");

        try {
            Process pWinCalc = pbWinCalc.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}