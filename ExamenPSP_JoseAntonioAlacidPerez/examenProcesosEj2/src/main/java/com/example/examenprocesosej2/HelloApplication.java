package com.example.examenprocesosej2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    private static final ProcessBuilder pb = new ProcessBuilder();
    private static Process p;
    private static Process p1;
    public static void paint(){
        pb.command("mspaint");

            try {
                p = pb.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public static void cPaint(){
            p.destroy();
    }

    public static void cPaint2(){
        p.destroy();
        p1.destroy();
    }

    public static void paint2(){
        pb.command("mspaint");
            try {
                p = pb.start();
                p1 = pb.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public static void main(String[] args) {
        launch();
    }
}