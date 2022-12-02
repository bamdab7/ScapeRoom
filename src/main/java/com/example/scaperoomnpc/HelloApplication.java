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
    public void start(Stage stage) throws IOException {
        //  AL ARRANCAR GENERAR UN NUMERO RANDOM
//        int max= 100;
//        int min = 1;
//        //  CREATE ISNTANCE OF RANDOM CLASS
//        Random randomNum = new Random();
//        numeroAleatorio= min + randomNum.nextInt(max);
//        System.out.println(numeroAleatorio);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = null;
        try{
            scene = new Scene(fxmlLoader.load(), 517, 381);
        }catch (IOException e){
            System.err.println("Error al cargar la escena");
        }
        stage.setTitle("Scape Room");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}