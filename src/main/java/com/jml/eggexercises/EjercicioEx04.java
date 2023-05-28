
package com.jml.eggexercises;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/* @author jmlucero */
public class EjercicioEx04 extends Exercise
{
String input;
    public EjercicioEx04(JTextPane jTextPane, JTextField jTextField, Document doc) {
        super(jTextPane, jTextField, doc);
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.cyan);
           AddTextToPane("Elaborar un algoritmo en el cuál se ingrese un número entre 1 y 10 y se muestre su " +
"equivalente en romano.",set);
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

              AddTextToPane("Ha ingresado el numero: "+ingresado);
              AddTextToPane("Y su equivalente en romano es: "+ConvertirARomano(ingresado));
            } catch (Exception e) {
                    SimpleAttributeSet set = new SimpleAttributeSet();
                     StyleConstants.setForeground(set, Color.red);
                    AddTextToPane("Al parecer no introdujo un numero valido...",set);
                }
            }
        
         
        jTextField.setText("");
   
    }

    @Override
    protected void buttonAction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String ConvertirARomano(int remain) {
        int index = 0;
        String salida = "";
        if (remain > 0) {
            int[] romansInts = {1000, 900, 500, 100, 90, 50, 10, 9, 5, 1};
            String[] romanLetters = {"M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I"};
            while (remain > 0) {
                if (remain >= romansInts[index]) {
                    remain -= romansInts[index];
                    salida += romanLetters[index];
                } else {
                    index++;
                }
            }
        } else {
            salida = "0";
        }
        return salida;
    }

}


