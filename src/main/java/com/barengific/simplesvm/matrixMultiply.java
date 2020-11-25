/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barengific.simplesvm;

import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author Admino
 */
public class matrixMultiply {

    public static double[][] multi() {
        SimpleMatrix firstMatrix = new SimpleMatrix(
                new double[][]{
                    new double[]{1, 3},
                    new double[]{2, 4}
                }
        );

        SimpleMatrix secondMatrix = new SimpleMatrix(
                new double[][]{
                    new double[]{5},
                    new double[]{6}
                }
        );

        SimpleMatrix actual = firstMatrix.mult(secondMatrix);

        System.out.println(actual);
        
        return null;
    }

//    public static void main(String args[]) {
//        SimpleMatrix firstMatrix = new SimpleMatrix(
//                new double[][]{
//                    new double[]{1, 3},
//                    new double[]{2, 4}
//                }
//        );
//
//        SimpleMatrix secondMatrix = new SimpleMatrix(
//                new double[][]{
//                    new double[]{5},
//                    new double[]{6}
//                }
//        );
//
//        SimpleMatrix actual = firstMatrix.mult(secondMatrix);
//
//        System.out.println(actual);
//    }
}
