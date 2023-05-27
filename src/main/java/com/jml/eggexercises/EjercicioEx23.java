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
public class EjercicioEx23 extends Exercise {
    
    char[][] matrix = new char[20][20];
    
    int counter=0;
    int limit=8;
 
    String[] listaPalabras= new String[limit];

    public EjercicioEx23(JTextPane jTextPane, JTextField jTextField, Document doc) {
        super(jTextPane, jTextField, doc);
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.cyan);
        AddTextToPane("Construya un programa que lea 5 palabras de mínimo 3 y hasta 5 caracteres y, a medida" +
        "que el usuario las va ingresando, construya una “sopa de letras para niños” de tamaño de" +
        "20 x 20 caracteres. Las palabras se ubicarán todas en orden horizontal en una fila que" +
        "será seleccionada de manera aleatoria. Una vez concluida la ubicación de las palabras," +
        "rellene los espacios no utilizados con un número aleatorio del 0 al 9. Finalmente imprima" +
        "por pantalla la sopa de letras creada.", set);
        AddTextToPane("Introduzca su palabra N° 1");
        Inicializar(matrix);
        //PrintInPanel(matrix);
    }

    @Override
    protected void action(ActionEvent evt) {

        String input = jTextField.getText();
        if (input == "") {
            AddTextToPane("No ha introducido nada...");
        } else {
            if(counter<limit) {
                if(!ValidarPalabra(input)) {
                    AddTextToPane("Introduzca su palabra N° "+(counter+1)); 
                    
                } else{
                    AddTextToPane("Introduzca su palabra N° "+(counter+1)+" es "+input); 
                    listaPalabras[counter]=input.toUpperCase();
                       counter++;
                       if(counter>limit-1) {
                            counter=0;
                       for (String cs : listaPalabras) {
                           AddTextToPane("PALABRA: "+cs);
                           UbicarPalabra(cs,matrix);
                          
                           }
                       PrintInPanel(matrix);
                       LlenarMatrix(matrix);
                       PrintInPanel(matrix);
                       
                       }
                }
            }   
        }
        jTextField.setText("");
    }

    @Override
    protected void buttonAction() {
               SimpleAttributeSet set = new SimpleAttributeSet();
      StyleConstants.setForeground(set, Color.blue);
        char letra ='A';
 
        AddTextToPane("CODE OF A:" +(char) 65, set);
        letra ='Z';
        AddTextToPane("CODE OF Z:" +(char) 75, set);
        
        
//        SimpleAttributeSet set = new SimpleAttributeSet();
//        StyleConstants.setForeground(set, Color.blue);
//
//        AddTextToPane("No hay accion especial implementada en esta caso.", set);
    }
    
    public boolean ValidarPalabra(String palabra){
        return palabra.length()>=3 && palabra.length()<=10;
    }
    
    public void LlenarMatrix(char[][] matrix){
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                  if(matrix[i][j]==' ') {
                    matrix[i][j]=(char) (random.nextInt(26)+65);  
                }
            }
        }
       
    }
    
    public void Inicializar(char[][] matrix){
        
        char slot;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
              
                    matrix[i][j]=' ';
 
            }
            
        }
    }
    
    
    
    
     public  void PrintInPanel(char[][] matrix) {
        for (char[] vect : matrix) {
             AddTextToPane(ConcatenarVector(vect));
        }
        AddTextToPane("\n");
    }
 
    private  String ConcatenarVector(char[] vector) {
        String output = "[";
        for (char i : vector) { output = output.concat("" + i + ", ");}//String.valueOf()
        output = output.substring(0, output.length() - 2).concat("]");
        return output;
    }
    
    
    
    private  void UbicarPalabra(String palabra, char[][] matrix){
        Random rdm = new Random();
        int xDir;
        int yDir;
        do {
               xDir= rdm.nextInt(3)-1;
        yDir= rdm.nextInt(3)-1;
        
        }
         while (xDir==0 && yDir==0);
                
             
        int largoPalabra = palabra.length();
        int dimR= matrix.length;
        int dimC=matrix[0].length;
        int rdmPosY;
        int rdmPosX;
        boolean valid;
        do {
          
            rdmPosY=rdm.nextInt(dimR);
            rdmPosX=rdm.nextInt(dimC);
           
        valid = (rdmPosY+(largoPalabra*yDir)>=0 && rdmPosY+(largoPalabra*yDir)<dimR) && (rdmPosX+(largoPalabra*xDir)>=0 && rdmPosX+(largoPalabra*xDir)<dimC);
       
        valid =valid && CheckSuperpose(palabra,largoPalabra, matrix, yDir, xDir,rdmPosY,rdmPosX);
    
        } while (!valid);
        
        
        
    }
    
    private boolean CheckSuperpose(String palabra, int largoPalabra, char[][] matrix, int yDir, int xDir, int rdmPosY, int rdmPosX) {
        boolean valid = true;
        char place;
        for (int i = 0; i < largoPalabra; i++) {
            place = matrix[rdmPosY + (yDir * i)][rdmPosX + (xDir * i)];
            valid = valid && (place==' ' || place == palabra.charAt(i));
        }
        if (valid) {
            System.out.println("PALABRA: "+palabra);
            System.out.println("yDir: "+yDir+"   xDir: "+xDir+"   rdmPosy: "+rdmPosY+"   rdmPosx: "+rdmPosX);
            for (int i = 0; i < largoPalabra; i++) {
                matrix[rdmPosY + (yDir * i)][rdmPosX + (xDir * i)] = palabra.charAt(i);
            }

        }

        return valid;

    }

}
