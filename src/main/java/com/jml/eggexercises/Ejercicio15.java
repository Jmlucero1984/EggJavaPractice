
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
public class Ejercicio15 extends Exercise{
    String input;
    int[] myIntVector = new int[30];
    Random random = new Random(5);

    public Ejercicio15(JTextPane jTextPane1, JTextField jTextField1,Document doc) {
        super(jTextPane1, jTextField1,doc);
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.cyan);
        AddTextToPane("Realizar un algoritmo que rellene un vector con los 100 primeros números enteros y los"
                + "muestre por pantalla en orden descendente. Presione EJECUTAR ACCION",set);

    }

    @Override
    protected void action(ActionEvent evt) {
        input = jTextField.getText();
        if (input == "") {
            AddTextToPane("No ha introducido nada...");

        }
        jTextField.setText("");
    }

    @Override
    protected void buttonAction() {

        for (int i = 0; i < myIntVector.length; i++) {
            myIntVector[i] = random.nextInt(100);

        }
        AddTextToPane("Se generaron 30 valores enteros aleatorios");
        AddTextToPane(ConcatenarVector(myIntVector));
        AddTextToPane("Se ordenaran de Menor a Mayor");
        MyTools.IntVectorSelectSort(myIntVector, false);

        AddTextToPane(ConcatenarVector(myIntVector));

    }

    private String ConcatenarVector(int[] vector) {
        String output = "[";

        for (int i : vector) {

            output = output.concat("" + i + ", "); //String.valueOf()
        }

        output = output.substring(0, output.length() - 2).concat("]");
        return output;

    }

}
