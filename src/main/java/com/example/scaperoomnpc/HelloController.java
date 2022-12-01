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
    public Button btnNuevaPartida;
    int numeroIntentos = 6; //sino ejecuta 7 intentos
    private int numeroAleatorio;

    protected void setup(){
        //GENERAMOS NUMERO ALEATORIO
        numeroAleatorio = (int) (Math.random() * ((100 -1) + 1) +1);
        //RESETEAMOS
        numeroUsuario.setText("");
        btnProbar.setDisable(false);
        numeroIntentos = 6;
        TXTintentosRestantes.setText("Quedanche  " + numeroIntentos + " intentos");
    }

    public void btnProbar(ActionEvent actionEvent) {
        System.out.println(numeroAleatorio);
        // ESTE ES EL BOTON QUE HACE LAS COMPROBACIONES
        int numeroUsuarioInput= parseInt(numeroUsuario.getText());
        //  COMPROBADOR DE SI EL NUMERO ESTA DENTRO DEL RANGO ESPECIFICADO
        if(numeroUsuarioInput < -1 || numeroUsuarioInput>100){
            TXTFeedBack.setText("Por favor introduce un numero válido 0-100");
        }else{
            numeroIntentos--;
            if(numeroIntentos==0){
                btnProbar.setDisable(true);
            }
            //diferencia
            int lejos = numeroUsuarioInput - numeroAleatorio;
            int lejos2 = numeroAleatorio - numeroUsuarioInput;
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
            if(numeroUsuarioInput==numeroAleatorio){
                int resta= 6 - numeroIntentos;
                TXTFeedBack.setText("Acertó en " + resta + " intentos");
                TXTFeedBack.setFill(Color.GREEN);
                btnProbar.setDisable(true);
            }
        }

    }

    public void btnNuevaPartida(ActionEvent actionEvent) {
        setup();
    }
}