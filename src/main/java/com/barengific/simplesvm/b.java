package com.barengific.simplesvm;
//import java.util.Vector;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.commons.math3.geometry.euclidean.twod.*;
import org.apache.commons.math3.stat.regression.SimpleRegression;

public class b {

    static Vector2D vec1 = new Vector2D(9, 13);
    static Vector2D vec2 = new Vector2D(3, 5);

    //Vector2D(2,3);
    public static double aa() {
        double qw = 1;
        System.out.println(vec1.add(vec2));
        return qw;
    }

    public static void main(String[] args) {
        double x1[] = new double[2];
        x1[0] = 15.6667d;
        x1[1] = 53d;
        double x2[] = new double[2];
        x2[0] = 29.6667d;
        x2[1] = 46.6667d;

        //SVM1
        double[] wt1 = new double[2];
        wt1[0] = 0.0749d;
        wt1[1] = -0.0904d;
        double w01 = 1367d/387d;
        double aa = Matrix.multiA(x2, wt1);
        double svm1 = w01 + aa;
        System.out.println("svm1: " + svm1);

        //SVM2
        double[] wt2 = new double[2];
        wt2[0] = -0.273267326732674d;
        wt2[1] = -0.01980198019802d;
        double w02 = -935d/101d;
        double bb = Matrix.multiA(wt2, x2);
        double svm2 = bb + w02;
        System.out.println("svm2: " + svm2);

//        double v1[][] = new double[2][1];
//        v1[0][0] = 0;
//        v1[1][0] = 28;
//
//        double[][] l1 = new double[1][1];
//        l1[0][0] = 0.000026707619550370154;
//
//        double[][] l2 = new double[1][1];
//        l2[0][0] = 0.006870580584548258;
//
//        double[][] l3 = new double[1][1];
//        l3[0][0] = 0.006897288330037554;
//
//        double[][] l1t = new double[2][1];
//        l1t = Matrix.multi(v1, l1);
//
//        System.out.println(Arrays.deepToString(l1t));
        //System.out.println(vec1.add(vec2));
        //System.out.println(vec1.add(6, vec2));
        //System.out.println(vec1.crossProduct(vec2, vec2));
        //System.out.println(vec1.dotProduct(vec2));
        //System.out.println(product(vec1, vec2));
        //Scanner scans = new Scanner(System.in);
        //System.out.println("\r\n+++++Select Options+++++");
        //String userInput = scans.nextLine();  // Read user input
        //System.out.println("User Selected Option: " + userInput);
//        Vector2D a = new Vector2D(24, 70);
//        Vector2D b = new Vector2D(35, 57);
//        System.out.println(a.dotProduct(b));
//        //double aa;
//        //aa = aa();
//        double[][] qq = {{784, 1596, -1960, 1}, {1596, 4474, -4840, 1}, {1960, 4830, -5476, 1}, {1, 1, -1, 0}};
//        double[][] ww = {{1}, {1}, {-1}, {0}};
//        double[] ee = {1, 1, -1, 0};
//        //double[][] ee = qq*ww;
//        SimpleRegression sr = new SimpleRegression();
//        //sr.addData(qq);
//        //sr.addData(ww);
//        sr.addObservations(ww, ee);
//        System.out.println(sr.hasIntercept());
    }

    public static Vector2D product(Vector2D v1, Vector2D v2) {
        Vector2D vec1;
        vec1 = new Vector2D(v1.getX() * v2.getX(), v1.getY() * v2.getY());
        return vec1;
    }
}
