/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoesofttest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
/**
 *
 * @author Andrés Alvarez
 */
public class GrupoEsoftTest {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        
        int n=0;
        int m=0;
                
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(n < 3){
            System.out.println("Ingrese el número de filas y presione enter\n");
            String rows = br.readLine();
            try{
                n = Integer.parseInt(rows);
            }
            catch(NumberFormatException e){
            System.err.println("Ingrese un número de filas válido");
            }
            
            System.out.println("Las filas de la matriz serán: " + n);
            if(n < 3)System.err.println("N debe ser mayor a 2");
        }
        
        while(m < 3){
            System.out.println("\nIngrese el número de columnas y presione enter\n");
            String columns = br.readLine();
            try{
                m = Integer.parseInt(columns);
            }
            catch(NumberFormatException e){
            System.err.println("Ingrese un número de columnas válido");
            }
            System.out.println("Las columnas de la matriz serán: " + m + "\n");
            if(m < 3)System.err.println("M debe ser mayor a 2");
        }
        
        Random rand = new Random();
        int[][] matrix = new int [n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = rand.nextInt(n*m) + 1; 
            }
        }
        
        printMatrix(matrix);
        int [] v = totalColumns(matrix, n, m);
        System.out.print("\n\n");
        double average = averageEvenColumns(v);
        System.out.print("\n");
        totalColumnsMeetProperty(v, average);

    }

        public static void printMatrix(int matrix[][]){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            System.out.println();
            }
            System.out.println("==============================");
        }

        public static int [] totalColumns(int matrix[][], int n, int m){
            int[] vector = new int [m];
            for (int i = 0; i < m; i++) {
                int sumColumn = 0;
                for (int j = 0; j < n; j++) {
                    sumColumn = sumColumn + matrix[j][i];
                    vector[i] = sumColumn;             
                }
                    System.out.print(vector[i] + " ");
            }
            return vector;
        }

        public static double averageEvenColumns(int vector[]){
            int suma = 0;
            double contador = 0;
            for(int i = 0; i < vector.length; i++){            
                if(i % 2 == 0){
                    contador = contador + 1;
                    int b = vector[i];
                    suma = suma + b;
                }            
            }
            double a = suma / contador;
            System.out.print("El promedio de las columnas pares es: " + String.format("%.2f", a) +"\n");
            return a;
        }

        public static int totalColumnsMeetProperty(int vector[], double a){
            int contador = 0;
            for(int i = 0; i < vector.length; i++){            
                if(vector[i] > a){
                    contador = contador + 1;
                }            
            }

            System.out.print("Las columnas cuya suma es mayor que " + String.format("%.2f", a)
                    + " son: " + contador +"\n\n");
            return contador;
    }
}
