package com.barengific.simplesvm;
//import java.util.Vector;

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
        //System.out.println(vec1.add(vec2));
        //System.out.println(vec1.add(6, vec2));
        //System.out.println(vec1.crossProduct(vec2, vec2));
        //System.out.println(vec1.dotProduct(vec2));
        //System.out.println(product(vec1, vec2));
        //Scanner scans = new Scanner(System.in);
        //System.out.println("\r\n+++++Select Options+++++");
        //String userInput = scans.nextLine();  // Read user input
        //System.out.println("User Selected Option: " + userInput);

        Vector2D a = new Vector2D(24, 70);
        Vector2D b = new Vector2D(35, 57);
        System.out.println(a.dotProduct(b));
        //double aa;
        //aa = aa();
        double[][] qq = {{784, 1596, -1960, 1}, {1596, 4474, -4840, 1}, {1960, 4830, -5476, 1}, {1, 1, -1, 0}};
        double[][] ww = {{1}, {1}, {-1}, {0}};
        double[] ee = {1, 1, -1, 0};
        //double[][] ee = qq*ww;
        SimpleRegression sr = new SimpleRegression();
        //sr.addData(qq);
        //sr.addData(ww);
        sr.addObservations(ww, ee);
        System.out.println(sr.hasIntercept());

    }

    public static Vector2D product(Vector2D v1, Vector2D v2) {
        Vector2D vec1;
        vec1 = new Vector2D(v1.getX() * v2.getX(), v1.getY() * v2.getY());
        return vec1;
    }
}
