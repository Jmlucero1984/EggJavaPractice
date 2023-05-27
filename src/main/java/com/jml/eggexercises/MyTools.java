
package com.jml.eggexercises;

import java.util.Random;

 
/* @author jmlucero */
public class MyTools {
    public IPanelPrinter panelPrinter;
    /**
     * SELECTION SORT METHOD 
     * Doble iteracion.
     * <p>
     * TIME COMPLEXITY<br>
     * Best Ω(n^2)  Average Θ(n^2)   Worst O(n^2)<br><br>
     * SPACE COMPLEXITY<br>
     * Worst O(1)<br>
     * <ol>
     * <li>
     * Simple and easy to understand
     * <li>
     * Best aproximation por newbies
     * </ol>
     * <p>
     * @param vector the <code>int[]</code> to sort; if <code>null</code>, well nothing happens?
     * @param order the ordering mode: <code>true</code> for Ascending, <code>false</code> for Descending
     * @see #BubbleSort #InsertionSort #HeapSort #QuickSort  #MergeSort  #BucketSort 
     * @see  #RadixSort  #CountSort #TimSort #TreeSort  #CubeSort
     * @see <a href="https://www.geeksforgeeks.org/time-complexities-of-all-sorting-algorithms/">GeekForGeeks- Sorting Algorithms</a>
     */
 
    public static void IntVectorSelectSort(int[] vector,boolean order) {
        int actualMin, changePos;
        for (int i = 0; i < vector.length; i++) {
            actualMin=vector[i];
            changePos=i;
            for (int j = i; j < vector.length; j++) {
                if (order) {
                    if(vector[j]<actualMin) {
                        changePos=j;
                        actualMin=vector[j];
                    }
                }else{
                    if(vector[j]>actualMin) {
                        changePos=j;
                        actualMin=vector[j];
                    }
                }                    
            }
            vector[changePos]=vector[i];
            vector[i]=actualMin;  
        }  
    }
    
    public static int[][] GenerateIntRandomMatrix(int rows, int cols,int maxInt) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(maxInt);
            }  
        }
        return matrix;
    }
    
    public static int[][] GenerateIntRandomMatrix(int squareDim, int maxInt) {
        return GenerateIntRandomMatrix(squareDim, squareDim,maxInt);
    }
    
    public static void PrintInPanel(IPanelPrinter panelPrinter, int[][] matrix) {
        for (int[] vect : matrix) {
           panelPrinter.PrintInPanel(ConcatenarVector(vect));
        }
        panelPrinter.PrintInPanel("\n");
    }
 
    private static String ConcatenarVector(int[] vector) {
        String output = "[";
        for (int i : vector) { output = output.concat("" + i + ", ");}//String.valueOf()
        output = output.substring(0, output.length() - 2).concat("]");
        return output;
    }
     
     
     
     
    public static void EncontrarSuperposiciones(IPanelPrinter panelPrinter, int[][] traveller,int [][]map){
        // int positionsToCheck = traveller.length*traveller[0].length;
         int r;
         int c;
         //int posChecked;
         boolean check;
         for (int i = 0; i <map.length-traveller.length+1 ; i++) {
             for (int j = 0; j < map[0].length-traveller[0].length+1; j++) {
                 check=true;
                 r=0;
                 //posChecked=0;
                 do{
                    c=0;
                    do{
                        if(traveller[r][c]!=map[i+r][j+c]){
                             check=false;
                        }
                        c++;
                    } while (check && c<traveller[0].length);
                  r++; 
                } while (check && r<traveller.length );
                 if(check) {
                    panelPrinter.PrintInPanel("Coincidencia en fila "+i+" y columna "+j+" de la matriz mayor");
                }
            }   
        }
    }
    
    public static int RevertirInt(int num) {
        
        int aux=num;
        int var = aux%10;
        while (aux>9) {
            
            aux=Math.floorDiv(aux, 10);
            var =var*10+ aux%10;
        }
        return var;
    }
    
    
}
