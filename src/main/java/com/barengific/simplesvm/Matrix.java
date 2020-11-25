/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barengific.simplesvm;

//import cern.colt.Arrays;
import java.util.Arrays;
import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author Admino
 */
public class Matrix {

    //public static void main(String args[]) {
    //********************input matrix as parameter
    public static double[][] multi(double[][] aa, double[][] bb) {
        int rows1 = aa.length;
        int cols1 = aa[0].length;

        int rows2 = bb.length;
        int cols2 = bb[0].length;

//        SimpleMatrix firstMatrix = new SimpleMatrix(
//                new double[][]{
//                    new double[]{1, 3},
//                    new double[]{2, 4}
//                }
//        );
        SimpleMatrix firstMatrix = new SimpleMatrix(aa);

        SimpleMatrix secondMatrix = new SimpleMatrix(bb);

        SimpleMatrix actual = firstMatrix.mult(secondMatrix);

        //System.out.println(actual);
        double ret[][] = new double[actual.numRows()][actual.numCols()];

        for (int i = 0; i < actual.numRows(); i++) {
            for (int j = 0; j < actual.numCols(); j++) {
                ret[i][j] = actual.get(i, j);
                //System.out.print(ret[i][j] + " ");
            }
            //System.out.println();//new line    
        }
        // F System.out.println(Arrays.deepToString(ret));
        return ret;

    }
//********************input matrix as parameter

    public static double[][] pose(double[][] aa) {

        int rows = aa.length;
        int cols = aa[0].length;
        //creating a matrix  
        //double original[][] = {{1, 3, 4}, {2, 4, 3}, {3, 4, 5}};

        //creating another matrix to store transpose of a matrix  
        double transpose[][] = new double[rows][cols];  //3 rows and 3 columns  

        //Code to transpose a matrix  
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[i][j] = aa[j][i];
            }
        }
//
//        System.out.println("Printing Matrix without transpose:");
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.print(aa[i][j] + " ");
//            }
//            System.out.println();//new line    
//        }
//        System.out.println("Printing Matrix After Transpose:");
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.print(transpose[i][j] + " ");
//            }
//            System.out.println();//new line    
//        }
        return transpose;
    }

    public static double[][] inverse(double[][] a) {
        SimpleMatrix b = new SimpleMatrix(
                a
        );
        SimpleMatrix inverse = b.pseudoInverse();

        double ret[][] = new double[inverse.numRows()][inverse.numCols()];

        for (int i = 0; i < inverse.numRows(); i++) {
            for (int j = 0; j < inverse.numCols(); j++) {
                ret[i][j] = inverse.get(i, j);
                //System.out.print(ret[i][j] + " ");
            }
            //System.out.println();//new line    
        }
        return ret;
    }
}
