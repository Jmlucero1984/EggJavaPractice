package com.jml.eggexercises;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/* @author jmlucero */
public class EjercicioEx10 extends Exercise {

    public int secretNumber;
    int intentos = 3;
    String input;
    boolean founded = false;

    Random random = new Random();

    public EjercicioEx10(JTextPane jTextPane1, JTextField jTextField1,Document doc) {
        super(jTextPane1, jTextField1,doc);
        AddTextToPane("Realice un programa para que el usuario adivine el resultado de una multiplicación entre\n"
                + "dos números generados aleatoriamente entre 0 y 10. El programa debe indicar al usuario\n"
                + "si su respuesta es o no correcta. En caso que la respuesta sea incorrecta se debe permitir\n"
                + "al usuario ingresar su respuesta nuevamente. Para realizar este ejercicio investigue como\n"
                + "utilizar la función Math.random() de Java.");
        AddTextToPane("Vamos a generar un número entre 0 y 10 inclusive");
        secretNumber = random.nextInt(11);

    }

    @Override
    protected void action(ActionEvent evt) {

        int ingresado = 0;
        input = jTextField.getText();
        if (input == "") {
            AddTextToPane("No ha introducido nada...");

        } else {
            try {
                ingresado = Integer.parseInt(input);

                if (intentos > 0 && !founded) {
                    intentos--;
                   
                    if (ingresado < secretNumber) {
                        AddTextToPane("El numero ingresado es menor que el numero secreto");
                    } else if (ingresado > secretNumber) {
                        AddTextToPane("El numero ingresado es mayor que el numero secreto");
                    } else {
                        AddTextToPane("Exacto!!! el número era justamente " + secretNumber + "!");
                        founded = true;
                    }
                     AddTextToPane("Le quedan " + intentos + " intentos...");


                } else if (!founded) {
                    AddTextToPane("Qúe lástima, no pudo adivinar el número secreto, era el " + secretNumber);
                } else {
                    AddTextToPane("Apriete Ejecutar Accion para reiniciar el Juego");
                }
            } catch (Exception e) {
                    SimpleAttributeSet set = new SimpleAttributeSet();
                     StyleConstants.setForeground(set, Color.red);
                AddTextToPane("Al parecer no introdujo un numero valido...",set);
            }
        }
        jTextField.setText("");
    }

    protected void buttonAction() {
        AddTextToPane("Reiniciando el Juego...\nNuevo número generado... tiene 3 intentos");
        intentos = 3;
        founded = false;
        secretNumber = random.nextInt(11);
    }
}
