package com.barengific.simplesvm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author barengistic
 */
public class DatasetGen {

    private static final long serialVersionUID = 111222998L;
    private static String trainLoc = "C:\\Users\\Admino\\Documents\\NetBeansProjects\\dataset.txt";
    private static String testLoc = "C:\\Users\\Admino\\Documents\\NetBeansProjects\\testdata.txt";

    public static int getRandNo(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int readData() {
        int x = 1;
        return x;
    }

    public static void dataGen() {
        try {
            FileWriter writer = new FileWriter(trainLoc, false);

            writer.append("ClassA");
            for (int i = 0; i < 20; i++) {
                //System.out.println(getRandNo(0, 30) + ", " + getRandNo(0, 30));
                writer.append("\r\n" + getRandNo(0, 30) + "," + getRandNo(0, 30));
            }
            writer.append("\r\nClassB");
            for (int i = 0; i < 20; i++) {
                //System.out.println(getRandNo(33, 60) + ", " + getRandNo(0, 30));
                writer.append("\r\n" + getRandNo(35, 60) + "," + getRandNo(35, 60));
            }
            writer.append("\r\nClassC");
            for (int i = 0; i < 20; i++) {
                //System.out.println(getRandNo(33, 60) + ", " + getRandNo(33, 60));
                writer.append("\r\n" + getRandNo(0, 30) + "," + getRandNo(70, 95));
            }
            writer.close();
            System.out.println("Finished Writing");
//
//            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admino\\Documents\\NetBeansProjects\\dataset.txt"));
//            ArrayList<String> res = new ArrayList<>();
//            ArrayList<Integer> xcA = new ArrayList<>();
//            ArrayList<Integer> ycA = new ArrayList<>();
//            ArrayList<Integer> xcB = new ArrayList<>();
//            ArrayList<Integer> ycB = new ArrayList<>();
//            ArrayList<Integer> xcC = new ArrayList<>();
//            ArrayList<Integer> ycC = new ArrayList<>();
//            ArrayList<ArrayList<Integer>> classA_XY = new ArrayList<>(2);
//            ArrayList<ArrayList<Integer>> classB_XY = new ArrayList<>(2);
//            ArrayList<ArrayList<Integer>> classC_XY = new ArrayList<>(2);
//            for (int i = 0; i < 2; i++) {
//                classA_XY.add(new ArrayList());
//                classB_XY.add(new ArrayList());
//                classC_XY.add(new ArrayList());
//            }
//            while (reader.ready()) {
//                res.add(reader.readLine());
//            }
//            for (int i = 1; i < 21; i++) {
//                String[] a = (res.get(i).split(","));
//                //xcA.add(Integer.parseInt(a[0].toString()));
//                //ycA.add(Integer.parseInt(a[1].toString()));
//                classA_XY.get(0).add(Integer.parseInt(a[0].toString()));
//                classA_XY.get(1).add(Integer.parseInt(a[1].toString()));
//            }
//            //System.out.println(xcA.toString());
//            //System.out.println(xcA.get(2).toString());
//
//            for (int i = 22; i < 42; i++) {
//                String[] a = (res.get(i).split(","));
//                classB_XY.get(0).add(Integer.parseInt(a[0].toString()));
//                classB_XY.get(1).add(Integer.parseInt(a[1].toString()));
//            }
//
//            for (int i = 43; i < 62; i++) {
//                String[] a = (res.get(i).split(","));
//                classC_XY.get(0).add(Integer.parseInt(a[0].toString()));
//                classC_XY.get(1).add(Integer.parseInt(a[1].toString()));
//            }
//            System.out.println(classA_XY.toString());
//            System.out.println(classB_XY.toString());
//            System.out.println(classC_XY.toString());
//            System.out.println(classC_XY.get(1).get(1).toString());
//            System.out.println("Finished Reading");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void testGen() {
        try {
            FileWriter writer = new FileWriter(testLoc, false);
            for (int i = 0; i < 20; i++) {
                writer.append(getRandNo(0, 60) + "," + getRandNo(0, 95) + "\r\n");
            }
            writer.close();
            System.out.println("Finished Writing Test");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
