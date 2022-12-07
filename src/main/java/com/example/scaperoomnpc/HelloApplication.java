package com.example.scaperoomnpc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
   // static int numeroAleatorio;
    @Override
    public void start(Stage stage) {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = null;
        try{
            scene = new Scene(fxmlLoader.load(), 517, 381);
        }catch (IOException e){
            System.err.println("Error al cargar la escena");
            System.out.println(e.getMessage());
        }
        stage.setTitle("Scape Room");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}