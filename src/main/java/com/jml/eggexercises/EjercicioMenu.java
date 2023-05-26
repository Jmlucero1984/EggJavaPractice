
package com.jml.eggexercises;

import java.util.Scanner;

/* @author jmlucero */
public class EjercicioMenu {
    
    public static void _main(String[] args) {
        System.out.println("Ingrese dos numeros enteros por teclado");
        
        Scanner leer = new Scanner(System.in);
        int numero1, numero2,opcion;
        System.out.println("Introduzca el primer numero");
        numero1=leer.nextInt();
        System.out.println("Introduzca el segundo numero");
        numero2=leer.nextInt();
        do {          
            System.out.println("Seleccione una opción");
            System.out.println("MENU\n1.Sumar\n2.Restar\n3.Multiplicar\n4.Dividir\n5.Salir");
            opcion = leer.nextInt();
            switch(opcion) {
                case 1:
                    System.out.println("La suma es: "+(numero1+numero2));
                    break;
                case 2:
                    System.out.println("La resta da: "+(numero1-numero2));
                    break;
                case 3:
                    System.out.println("La multipliacion da: "+ (numero1*numero2));
                    break;
                case 4: 
                    System.out.println("La division da: "+(numero1/numero2));
                    break;
                    
            }
            
        } while (opcion!=5);
        
        
    }

}
