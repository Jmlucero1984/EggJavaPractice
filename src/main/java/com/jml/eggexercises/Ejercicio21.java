
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
public class Ejercicio21 extends Exercise implements IPanelPrinter {
    String input;
    int[][] motherMatrix;
    int[][] childMatrix;
    public Ejercicio21(JTextPane jTextPane1, JTextField jTextField1,Document doc) {
        super(jTextPane1, jTextField1,doc);
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.cyan);
        AddTextToPane("Dadas dos matrices cuadradas de números enteros, la matriz M de 10x10 y"+
                "la matriz P de3x3, se solicita escribir un programa en el cual se compruebe si la"+
                "matriz P está contenida dentro de la matriz M. Para ello se debe verificar si entre"+
                "todas las submatrices de 3x3" +
                "que se pueden formar en la matriz M, desplazándose por filas o columnas, existe al" +
                "menos una que coincida con la matriz P. En ese caso, el programa debe indicar la fila y la" +
                "columna de la matriz M en la cual empieza el primer elemento de la submatriz P.",set);

    }

    @Override
    protected void action(ActionEvent evt) {
        input = jTextField.getText();
        if (input == "") {
            AddTextToPane("No ha introducido nada...");

        } else {

        }
        jTextField.setText("");
    }

    @Override
    protected void buttonAction() {
        motherMatrix=MyTools.GenerateIntRandomMatrix(10, 2);
        childMatrix=MyTools.GenerateIntRandomMatrix(3, 2);
         MyTools.PrintInPanel(this, motherMatrix);
         MyTools.PrintInPanel(this, childMatrix);
         MyTools.EncontrarSuperposiciones(this,childMatrix,motherMatrix);
    

    }

    private String ConcatenarVector(int[] vector) {
        String output = "[";

        for (int i : vector) {

            output = output.concat("" + i + ", "); //String.valueOf()
        }

        output = output.substring(0, output.length() - 2).concat("]");
        return output;

    }

    @Override
    public void PrintInPanel(String text) {
         AddTextToPane(text);
    }
}
