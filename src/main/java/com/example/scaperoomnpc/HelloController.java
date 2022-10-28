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
    public Button btnProbar;
    int numeroIntentos = 6; //sino ejecuta 7 intentos

//  PARA LLAMAR AL NUMERO ALEATORIO = HelloApplication.numeroAleatorio

    public void btnProbar(ActionEvent actionEvent) {
        // ESTE ES EL BOTON QUE HACE LAS COMPROBACIONES
        int numeroUsuarioInput= parseInt(numeroUsuario.getText());
        //  COMPROBADOR DE SI EL NUMERO ESTA DENTRO DEL RANGO ESPECIFICADO
        if(numeroUsuarioInput <= 0 || numeroUsuarioInput>100){
            TXTFeedBack.setText("Por favor introduce un numero válido 1-100");
        }else{
            numeroIntentos--;
            if(numeroIntentos==0){
                btnProbar.setVisible(false);
            }
            //diferencia
            int lejos = numeroUsuarioInput - HelloApplication.numeroAleatorio;
            int lejos2 = HelloApplication.numeroAleatorio - numeroUsuarioInput;
            //  numeroIntentos--;
            if(lejos > 20 || lejos2 > 20){
                TXTFeedBack.setFill(Color.BLUE);
                TXTFeedBack.setText("El numero esta lejos");
                System.out.println("El numero esta lejos, diferencia de mas de 20");
            }else if(lejos < 20 && lejos > 10 || lejos2< 20 && lejos2 >10){
                TXTFeedBack.setFill(Color.ORANGE);
                TXTFeedBack.setText("El numero esta algo cerca");
                System.out.println("El numero esta algo cerca, diferencia menos de  20 y  mas de 10");
            }else if(lejos < 10 || lejos2<10 ){
                TXTFeedBack.setFill(Color.RED);
                TXTFeedBack.setText("El numero esta muy cerca");
                System.out.println("El numero esta muy cerca, menos de 10");
            }
            TXTintentosRestantes.setText("Quedanche  " + numeroIntentos + " intentos");
            if(numeroUsuarioInput==HelloApplication.numeroAleatorio){
                btnProbar.setVisible(false);
                int resta= 6 - numeroIntentos;
                TXTFeedBack.setText("Acertó en " + resta + " intentos");
                TXTFeedBack.setFill(Color.GREEN);
            }
        }

    }

    public void btnReset(ActionEvent actionEvent) {
        //  BASICAMENTE ESTE BOTON LO QUE HACE ES SETEAR TODOS LOS VALORES A COMO ESTABAN ANTES
        numeroIntentos = 6;
        btnProbar.setVisible(true);
    }
}