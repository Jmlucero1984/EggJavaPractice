
package com.jml.eggexercises;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/* @author jmlucero */
public class Ejercicio1 extends Exercise{
    int counter=0;
    int[] numbers= new int[2];
    String input;


    public Ejercicio1(JTextPane jTextPane1, JTextField jTextField1,Document doc) {
        super(jTextPane1, jTextField1,doc);
        AddTextToPane("Bienvenido al Ejercicio 1");
        AddTextToPane("Ingrese dos numeros para calcular la suma");
    }

    
    @Override
    protected void action(ActionEvent evt) {
    
     
        input= jTextField.getText();
         if(input=="") {
             AddTextToPane("No ha introducido nada...");
             
         } else {
             numbers[counter]=Integer.parseInt(input);
            
             counter++;
              AddTextToPane("Su valor N° "+counter+ " es "+input);
            if(counter>1) {
                AddTextToPane(Sumar(numbers));
                counter=0;
                
                
         }
         
        }
             jTextField.setText("");
    }
    
    public String Sumar(int[] numeros){
        int resultado=numeros[0]+numeros[1];
        return "El resultado es " + String.valueOf(resultado);
         
        
    }

    @Override
    protected void buttonAction() {
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.blue);
        
        AddTextToPane("No hay accion especial implementada en esta caso.",set);
    }
 

    

}
