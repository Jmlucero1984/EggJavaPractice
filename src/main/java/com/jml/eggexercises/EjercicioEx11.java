package com.jml.eggexercises;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/* @author jmlucero */
public class EjercicioEx11 extends Exercise {

    public EjercicioEx11(JTextPane jTextPane, JTextField jTextField, Document doc) {
        super(jTextPane, jTextField, doc);
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.cyan);
        AddTextToPane("Escribir un programa que lea un número entero y devuelva el número de dígitos que"
                + "componen ese número. Por ejemplo, si introducimos el número 12345, el programa"
                + "deberá devolver 5. Calcular la cantidad de dígitos matemáticamente utilizando el"
                + "operador de división. Nota: recordar que las variables de tipo entero truncan los"
                + "números o resultados.", set);
    }

    @Override
    protected void action(ActionEvent evt) {

        String input = jTextField.getText();
        if (input == "") {
            AddTextToPane("No ha introducido nada...");

        } else {
            try {
                int ingresado = Integer.parseInt(input);

                AddTextToPane("La cantidad de digitos de su numero es: " + MyTools.GetNumDigits(ingresado));

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
