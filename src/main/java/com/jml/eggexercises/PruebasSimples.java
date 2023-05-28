
package com.jml.eggexercises;

/* @author jmlucero */
public class PruebasSimples {
    
    public static void main(String[] args) {
        int[] vector1 = {32,64,36,94};
        int[] vector2=  {32,64,36,94};
        int[] vector1b= vector1;
        
        
        
        /// EL EQUALS EVALUA SI SE TRATA DEL MISMO OBJETO, POR ASI DECIRLO, LA MISMA DIRECCION DE MEMORIA, NO EL CONTENIDO
        System.out.println("Equivale v1 a v2: " + vector1.equals(vector2));
        System.out.println("Equivale v1 a v1b: " + vector1.equals(vector1b));
        System.out.println("vector1 = " + MyTools.ConcatenarVector(vector1));
        System.out.println("vector1b = " + MyTools.ConcatenarVector(vector1));
        System.out.println("Modificado vector 1b");
        vector1b[0] = 35;
        System.out.println("vector1 = " + MyTools.ConcatenarVector(vector1));
        System.out.println("vector1b = " + MyTools.ConcatenarVector(vector1));
         System.out.println("Equivale v1 a v1b: " + vector1.equals(vector1b));
        System.out.println("------------------------");
        int[] vector3 = {64,32,36,94};
        System.out.println("Equivale v1 a v3: " + vector1.equals(vector3));
        String[] vector4 = {"casa", "perro"};
        System.out.println("Equivale v1 a v4: " + vector1.equals(vector4));
        
        
    }

}


