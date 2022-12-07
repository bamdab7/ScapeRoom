package com.example.scaperoomnpc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class HelloController implements Initializable {

    public TextField TXTintentosTotal;
    public TextField TXTintentosRestantes;
    public TextField numeroUsuario;
    public TextField txtNumeroMinimo;
    public TextField txtNumeroMaximo;
    public TextField txtIntentos;
    public Text TXTFeedBack;
    public Button btnProbar;
    public Button btnNuevaPartida;
    public Button btnConfiguracion;
    public TextField TXTNumeroaAdivinar;
    private int numeroAleatorio;
    private int numeroMinimo, numeroMaximo;
    private int intentosRestantes, numeroIntentos;

    //Metodo inicializador
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setup();
    }
    protected void setup() {
        //En este metodo cargaremos la configuracion que hay en el programa
        cargarConfig();
        
        //Generando numero aleatorio
        numeroAleatorio = (int) (Math.random() * ((numeroMaximo - numeroMinimo) + 1) + numeroMinimo);
        intentosRestantes = numeroIntentos;

        //Reseteamos
        numeroUsuario.setText("");
        btnProbar.setDisable(false);

        TXTNumeroaAdivinar.setText("Numero entre " + numeroMinimo + "  e" + numeroMaximo);
        TXTintentosTotal.setText("Tes un total de " +numeroIntentos + " intentos");
        TXTintentosRestantes.setText("Quedanche  " + intentosRestantes + " intentos");
    }

    private void cargarConfig()  {
        //Se cargaran los datos de configuracion del fichero configuracion
        Properties prop = new Properties();
        try {
            prop.load(new FileReader("configuracion.properties"));
            //Una vez obtenido el fichero, se guardaran los valores recogidos
            numeroMaximo = Integer.parseInt(prop.getProperty("numeroMaximo"));
            numeroMinimo = Integer.parseInt(prop.getProperty("numeroMinimo"));
            numeroIntentos = Integer.parseInt(prop.getProperty("numeroIntentos"));
        } catch (IOException e) {
            System.err.println("Error al leer la configuracion");
        }
    }

    public void btnProbar(ActionEvent actionEvent) {
        //Para comprobar, imprimo por pantalla el numero
        System.out.println(numeroAleatorio);

        //Boton que hace las comprobaciones para ver si se acierta el numero (tiene que estar dentro del intervalo de los nuevos numeros)
        // int numeroUsuarioInput= parseInt(numeroUsuario.getText());
        if (Integer.parseInt(numeroUsuario.getText()) > numeroMaximo || Integer.parseInt(numeroUsuario.getText()) < numeroMinimo) {
            //Si el numero introducido no coincide, no se cuenta
            throw new NumberFormatException();

        //Si el numero introducido no coincide... Mejora: comprobando varios lados
        }else if(Integer.parseInt(numeroUsuario.getText()) <  numeroAleatorio) {
            if (numeroAleatorio - Integer.parseInt(numeroUsuario.getText()) > 20) {
                TXTFeedBack.setFill(Color.BLUE);
                TXTFeedBack.setText("El numero esta lejos");
            } else if (numeroAleatorio - Integer.parseInt(numeroUsuario.getText()) > 10 && numeroAleatorio - Integer.parseInt(numeroUsuario.getText()) <= 20) {
                TXTFeedBack.setFill(Color.ORANGE);
                TXTFeedBack.setText("El numero esta algo cerca");
            } else {
                TXTFeedBack.setFill(Color.RED);
                TXTFeedBack.setText("El numero esta muy cerca");
            }
            intentosRestantes--;
        }else if(Integer.parseInt(numeroUsuario.getText()) <  numeroAleatorio){
            if(Integer.parseInt(numeroUsuario.getText()) - numeroAleatorio > 20) {
                TXTFeedBack.setFill(Color.BLUE);
                TXTFeedBack.setText("El numero esta lejos");
            }else if(Integer.parseInt(numeroUsuario.getText()) - numeroAleatorio >10 && Integer.parseInt(numeroUsuario.getText()) - numeroAleatorio <= 20) {
                TXTFeedBack.setFill(Color.ORANGE);
                TXTFeedBack.setText("El numero esta algo cerca");
            }else {
                TXTFeedBack.setFill(Color.RED);
            }
            intentosRestantes -- ;
            //Si el numero introducido es igual al numero, el boton se desabilita

        }else if(Integer.parseInt(numeroUsuario.getText())== numeroAleatorio) {
            TXTFeedBack.setText("Acertó en " + (numeroIntentos - intentosRestantes + 1) + " intentos");
            TXTFeedBack.setFill(Color.GREEN);
            btnProbar.setDisable(true);
        }
        //Indicaremos cuantos intentos nos quedan
        TXTintentosRestantes.setText("Quedanche " +intentosRestantes + " intentos");
        //En el caso de quedar 0 intentos, notificamos y desabilitamos el boton probar
        if(intentosRestantes <= 0){
            TXTFeedBack.setFill(Color.BLACK);
            TXTFeedBack.setText("Quedaste sen intentos");
            btnProbar.setDisable(true);
        }
    }

    public void btnNuevaPartida() {
        setup();
    }

    public void btnConfiguracion(ActionEvent actionEvent) {
        //En este metodo cargaremos la configuracion para cambiar las variables...
        try {
            //Comprobar que los numeros que introduce estan dentro del parametro
            if(Integer.parseInt(txtNumeroMinimo.getText())< 0){
                throw new NumberFormatException();
            }
            if(Integer.parseInt(txtNumeroMaximo.getText())< 0){
                throw new NumberFormatException();
            }
            if(Integer.parseInt(txtIntentos.getText())< 0){
                throw new NumberFormatException();
            }
            //Actualizamos las variables
            Properties prop = new Properties();
            prop.setProperty("numeroMinimo" , txtNumeroMinimo.getText());
            prop.setProperty("numeroMaximo", txtNumeroMaximo.getText());
            prop.setProperty("numeroIntentos" , txtIntentos.getText());

            //Actualizando fichero
            prop.store(new FileWriter("configuracion.properties"),"ScapeRoom");

            System.out.println("Configuracion actualizada");
        } catch (IOException e) {
            System.err.println("No se cargo la configuracion");
        }
    }
}