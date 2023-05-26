package com.jml.eggexercises;

import java.util.Scanner;

/* @author jmlucero */
public class Exercise_11 {

    public Exercise_11() {
        String cadena = "mensajito";
        char mychar = cadena.charAt(5);
        System.out.println("mychar " + mychar);

        String[] todosChars = cadena.split("");

        for (String chaar : todosChars) {
            System.out.print("char " + chaar);
        }

        Scanner scanner = new Scanner(System.in);
        String cadenaDeText;
        System.out.println("Introduzca una cadena de texto");
        cadenaDeText = scanner.nextLine();
        String[] caracteres = cadenaDeText.split("");
        cadenaDeText = "";
        String newCar;
        for (String caracter : caracteres) {
            switch (caracter) {
                case "a":
                    newCar = "@";
                    break;
                case "e":
                    newCar = "#";
                    break;
                case "i":
                    newCar = "$";
                    break;
                case "o":
                    newCar = "%";
                    break;
                case "u":
                    newCar = "*";
                    break;
                default:
                    newCar = caracter;
            }
            cadenaDeText = cadenaDeText.concat(newCar);
        }
        System.out.println("La cadena de salida: " + cadenaDeText);

    }
}
