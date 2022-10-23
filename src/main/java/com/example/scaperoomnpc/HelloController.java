package com.example.scaperoomnpc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class HelloController {

    public TextField TXTintentosTotal;
    public TextField TXTintentosRestantes;
    public TextField numeroUsuario;
    public Text TXTFeedBack;

//  PARA LLAMAR AL NUMERO ALEATORIO = HelloApplication.numeroAleatorio


    public void btnProbar(ActionEvent actionEvent) {
        // ESTE ES EL BOTON QUE HACE LAS COMPROBACIONES
        int numeroUsuarioInput= parseInt(numeroUsuario.getText());
            //diferencia
            int lejos = numeroUsuarioInput - HelloApplication.numeroAleatorio;
            int lejos2 = HelloApplication.numeroAleatorio - numeroUsuarioInput;

        if(lejos > 20 || lejos2 > 20){
            TXTFeedBack.setFill(Color.BLUE);
            System.out.println("El numero esta lejos, diferencia de mas de 20");
        }else if(lejos < 20 && lejos > 10 || lejos2< 20 && lejos2 >10){
            TXTFeedBack.setFill(Color.ORANGE);
            System.out.println("EL numero esta algo cerca, diferencia menos de  20 y  mas de 10");
        }else if(lejos < 10 || lejos2<10 ){
            TXTFeedBack.setFill(Color.RED);
            System.out.println("El numero esta muy cerca, menos de 10");
        }
    }
}