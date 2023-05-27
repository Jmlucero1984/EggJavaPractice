package com.jml.eggexercises;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/* @author jmlucero */
public class Pruebas extends Exercise {

    int counter = 0;
    int[] numbers = new int[2];
    String input;

    public Pruebas(JTextPane jTextPane1, JTextField jTextField1, Document doc) {
        super(jTextPane1, jTextField1, doc);
        AddTextToPane("Bienvenido a Pruebas");
        AddTextToPane("Ingrese dos numeros para calcular la Math.floorDiv y Math.floorMod");
    }

    @Override
    protected void action(ActionEvent evt) {

        input = jTextField.getText();
        if (input == "") {
            AddTextToPane("No ha introducido nada...");

        } else {
            try {

                numbers[counter] = Integer.parseInt(input);

                counter++;
                AddTextToPane("Su valor N° " + counter + " es " + input);
                if (counter > 1) {

                    int resultado = Math.floorDiv(numbers[0], numbers[1]);

                    AddTextToPane("El resultado de Math.floorDiv es " + String.valueOf(resultado));
                    resultado = Math.floorMod(numbers[0], numbers[1]);
                    AddTextToPane("El resultado de Math.floorMod es " + String.valueOf(resultado));
                    resultado = numbers[0] % numbers[1];
                    AddTextToPane("El resultado del operador % es " + String.valueOf(resultado));
               
                    AddTextToPane("El revertido del primero es: " + String.valueOf(MyTools.RevertirInt(numbers[0])) );  
                    AddTextToPane("El revertido del segundo es: " + String.valueOf(MyTools.RevertirInt(numbers[1])) ); 
                    counter = 0;

                }
            } catch (Exception e) {
                SimpleAttributeSet set = new SimpleAttributeSet();
                StyleConstants.setForeground(set, Color.red);
                AddTextToPane("Al parecer no introdujo un numero valido...", set);
            }

        }
        jTextField.setText("");
    }

    @Override
    protected void buttonAction() {
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.blue);

        AddTextToPane("No hay accion especial implementada en esta caso.", set);
    }

}
