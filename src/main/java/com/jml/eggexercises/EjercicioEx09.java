package com.jml.eggexercises;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/* @author jmlucero */
public class EjercicioEx09 extends Exercise {

    int counter = 0;
    String input;
    int[] numbers = new int[2];

    public EjercicioEx09(JTextPane jTextPane1, JTextField jTextField1,Document doc) {
        super(jTextPane1, jTextField1,doc);
           AddTextToPane("Simular la división usando solamente restas. Dados dos números enteros mayores que\n" +
"uno, realizar un algoritmo que calcule el cociente y el residuo usando sólo restas.\n" +
"Método: Restar el dividendo del divisor hasta obtener un resultado menor que el divisor,\n" +
"este resultado es el residuo, y el número de restas realizadas es el cociente.");
    }

    @Override
    protected void action(ActionEvent evt) {

        input = jTextField.getText();
        if (input == "") {
            AddTextToPane("No ha introducido nada...");

        } else {
            numbers[counter] = Integer.parseInt(input);

            counter++;
            AddTextToPane("Su valor N° " + counter + " es " + input);
            if (counter > 1) {
                if (numbers[0]>numbers[1]) {
                AddTextToPane(RestasSucesivas(numbers));
               }
                else {
                   AddTextToPane(RestasSucesivasExtendido(numbers));      
                 }
                
                counter = 0;
            }
        }
        jTextField.setText("");
    }

    public String RestasSucesivas(int[] nums) {
        if(nums[0]>nums[1]) {
            int dividendo= nums[0];
            int divisor= nums[1];
            int iters=0;
            do {
                dividendo-=divisor;
                iters++;     
            } while (dividendo>=divisor);
            return "El cociente es "+iters+" y el resto es "+dividendo;
        } else {
            return "El divisor es mayor que el dividendo... Pruebe con el método extendido...";
        }
               
        
        //return "El resultado es " + String.valueOf(resultado);

    }
     public String RestasSucesivasExtendido(int[] nums) {
       if(nums[0]<nums[1]) {
            int dividendo= nums[0];
            int divisor= nums[1];
            int iters=0;
            int DECIMALES = 3;
            int dec=DECIMALES;
            int suma;
          
            String cociente="0.";
        
            do {
                iters=0;
                dec--;
                suma=0;
                for (int i = 0; i < 10; i++) {
                    suma=suma+dividendo;
                }
                dividendo=suma;
                while (dividendo>=divisor){
                    dividendo-=divisor;
                    iters++;     
                } 
                cociente = cociente.concat(String.valueOf(iters));
            } while (dec>0 && dividendo!=0);
            String residuo=String.valueOf(dividendo);
            int ceros=DECIMALES-residuo.length();
            while(ceros>=0) {
            ceros--;
            residuo="0"+residuo;
           
           }
            String decimalPart=residuo.substring(residuo.length()-DECIMALES,residuo.length());
            residuo=residuo.substring(0,residuo.length()-DECIMALES)+"."+decimalPart;
     
         return "Cociente = "+cociente+" y el residuo = "+ residuo+"\n Recordar que residuo= dividendo - divisor*cociente";
       } else {
           return "Por qué no prueba con el método simple?";
       }
    }
          
        
        //return "El resultado es " + String.valueOf(resultado);

    @Override
    protected void buttonAction() {
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.blue);
        
        AddTextToPane("No hay accion especial implementada en esta caso.",set);
    }
 
}
