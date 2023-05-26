
package com.jml.eggexercises;

import java.util.Scanner;

/* @author jmlucero */
public class Exercise_11b {
    
    public Exercise_11b() {
        Scanner scanner = new Scanner(System.in);
        String cadenaDeText;
        System.out.println("Introduzca una cadena de texto");
        cadenaDeText = scanner.nextLine();
        
      
        String newCar="";
        int indice;
        String added="";
        
        String[] code = {"@","#","$","%","*"};
        
        
        for (String car : cadenaDeText.split("")) {
           indice="aeiou".indexOf(car);
           System.out.println("INDICE: "+indice);
           if (indice!=-1 && !added.contains(car)) {
               System.out.println("ADDED: "+added);
            indice=-1;
            added=added.concat(car);
            } 
               
           newCar=newCar.concat(indice!=-1?code[indice]:car);
        }
      
        System.out.println("La cadena de salida: " + newCar);
    }

}
