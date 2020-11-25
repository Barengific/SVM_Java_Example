package com.barengific.simplesvm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import static javax.xml.bind.DatatypeConverter.parseInteger;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author barengistic
 */
public class viewDataset extends JFrame {
//

    public double wo1;
    public double wo2;
    public double wt1;
    public double wt2;

    Matrix matrix = new Matrix();
    private static final long serialVersionUID = 6294689542092367723L;
    private static String fileLoc = "C:\\Users\\Admino\\Documents\\NetBeansProjects\\dataset.txt";

    public viewDataset(String title) {
        super(title);

        // Create dataset  
        XYDataset dataset = createDataset();

        // Create chart  
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Visualised Dataset of Class A, B & C", //title
                "X-Axis", "Y-Axis", dataset);

        //Changes background color  
        //XYPlot plot = (XYPlot) chart.getPlot();
        //plot.setBackgroundPaint(new Color(255, 200, 196));
        // Create Panel  
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileLoc));
            ArrayList<String> res = new ArrayList<>();
            ArrayList<ArrayList<Integer>> classA_XY = new ArrayList<>(2);
            ArrayList<ArrayList<Integer>> classB_XY = new ArrayList<>(2);
            ArrayList<ArrayList<Integer>> classC_XY = new ArrayList<>(2);
            for (int i = 0; i < 2; i++) {
                classA_XY.add(new ArrayList());
                classB_XY.add(new ArrayList());
                classC_XY.add(new ArrayList());
            }
            while (reader.ready()) {
                res.add(reader.readLine());
            }

            for (int i = 1; i < 21; i++) {
                String[] a = (res.get(i).split(","));
                classA_XY.get(0).add(Integer.parseInt(a[0].toString()));
                classA_XY.get(1).add(Integer.parseInt(a[1].toString()));
            }

            for (int i = 22; i < 42; i++) {
                String[] a = (res.get(i).split(","));
                classB_XY.get(0).add(Integer.parseInt(a[0].toString()));
                classB_XY.get(1).add(Integer.parseInt(a[1].toString()));
            }

            for (int i = 43; i < 63; i++) {
                String[] a = (res.get(i).split(","));
                classC_XY.get(0).add(Integer.parseInt(a[0].toString()));
                classC_XY.get(1).add(Integer.parseInt(a[1].toString()));
            }

            XYSeries series1 = new XYSeries("ClassA");
            for (int i = 0; i < 20; i++) {
                series1.add(classA_XY.get(0).get(i), classA_XY.get(1).get(i));
            }
            XYSeries series2 = new XYSeries("ClassB");
            for (int i = 0; i < 20; i++) {
                series2.add(classB_XY.get(0).get(i), classB_XY.get(1).get(i));
            }
            XYSeries series3 = new XYSeries("ClassC");
            for (int i = 0; i < 20; i++) {
                //System.out.println(classC_XY.get(0).get(i) + ", " + classC_XY.get(1).get(i));
                series3.add(classC_XY.get(0).get(i), classC_XY.get(1).get(i));
            }

            dataset.addSeries(series1);
            dataset.addSeries(series2);
            dataset.addSeries(series3);

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return dataset;
    }

    private static void readDatas() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileLoc));
            ArrayList<String> res = new ArrayList<>();
            ArrayList<ArrayList<Integer>> classA_XY = new ArrayList<>(2);
            ArrayList<ArrayList<Integer>> classB_XY = new ArrayList<>(2);
            ArrayList<ArrayList<Integer>> classC_XY = new ArrayList<>(2);
            for (int i = 0; i < 2; i++) {
                classA_XY.add(new ArrayList());
                classB_XY.add(new ArrayList());
                classC_XY.add(new ArrayList());
            }
            while (reader.ready()) {
                res.add(reader.readLine());
            }
            for (int i = 1; i < 21; i++) {
                String[] a = (res.get(i).split(","));
                classA_XY.get(0).add(Integer.parseInt(a[0].toString()));
                classA_XY.get(1).add(Integer.parseInt(a[1].toString()));
            }
            for (int i = 22; i < 42; i++) {
                String[] a = (res.get(i).split(","));
                classB_XY.get(0).add(Integer.parseInt(a[0].toString()));
                classB_XY.get(1).add(Integer.parseInt(a[1].toString()));
            }
            for (int i = 43; i < 63; i++) {
                String[] a = (res.get(i).split(","));
                classC_XY.get(0).add(Integer.parseInt(a[0].toString()));
                classC_XY.get(1).add(Integer.parseInt(a[1].toString()));
            }
            System.out.println("Class A: " + classA_XY.toString());
            System.out.println("Class B: " + classB_XY.toString());
            System.out.println("Class C: " + classC_XY.toString());
            System.out.println("Finished Reading");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(viewDataset.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(viewDataset.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(viewDataset.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Vector2D product(Vector2D v1, Vector2D v2) {
        Vector2D vec1;
        vec1 = new Vector2D(v1.getX() * v2.getX(), v1.getY() * v2.getY());
        return vec1;
    }

    public static void main(String[] args) {
        Scanner scans = new Scanner(System.in);  // Create a Scanner object
        while (true) {
            System.out.println("\r\n+++++Select Options+++++");
            System.out.println("\r\n1) Generate Dataset \r\n2) Display Current Dataset \r\n3) Visualise Current Dataset \r\n4) Enter SVM1 \r\n5) Enter SVM2 \r\n6) Exit");

            String userInput = scans.nextLine();  // Read user input
            System.out.println("User Selected Option: " + userInput);  // Output user input
            if (userInput.equals("1")) {
                datasetGen.dataGen();
            } else if (userInput.equals("2")) {
                readDatas();
            } else if (userInput.equals("3")) {
                Thread thread = new Thread() {
                    public void run() {
                        System.out.println("Thread Running");
                        SwingUtilities.invokeLater(() -> {
                            viewDataset charter = new viewDataset("Scatter Graph - Barengific");
                            charter.setSize(800, 500);
                            charter.setLocationRelativeTo(null);
                            charter.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                            charter.setVisible(true);
                        });
                    }
                };
                thread.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(viewDataset.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (userInput.equals("4")) {
                Scanner scanz = new Scanner(System.in);
                System.out.println("    \r\nEnter SVM1");

                System.out.println("    \r\nFirst +1 or -1 Side");
                int pn1 = parseInt(scanz.nextLine());
                System.out.println("    \r\nFirst Lambda (x, y)");
                double v1[][] = new double[2][1];
                v1[0][0] = scanz.nextDouble();
                v1[1][0] = scanz.nextDouble();
                System.out.println(Arrays.deepToString(v1));

                System.out.println("    \r\nSecond +1 or -1 Side");
                //int pn2 = parseInt(scanz.nextLine());
                int pn2 = Integer.parseInt(scans.nextLine().trim());
                System.out.println("    \r\nSecond Lambda (x, y)");
                double v2[][] = new double[2][1];
                v2[0][0] = scanz.nextDouble();
                v2[1][0] = scanz.nextDouble();

                System.out.println("    \r\nThird +1 or -1 Side");
                //int pn3 = parseInt(scanz.nextLine());
                int pn3 = Integer.parseInt(scans.nextLine().trim());
                System.out.println("    \r\nThird Lambda (x, y)");
                double v3[][] = new double[2][1];
                v3[0][0] = scanz.nextDouble();
                v3[1][0] = scanz.nextDouble();

                Vector2D vec1 = new Vector2D(v1[0][0], v1[1][0]);
                Vector2D vec2 = new Vector2D(v2[0][0], v2[1][0]);
                Vector2D vec3 = new Vector2D(v3[0][0], v3[1][0]);
//
                double ma1 = vec1.dotProduct(vec1);
                double ma2 = vec1.dotProduct(vec2);
                double ma3 = vec1.dotProduct(vec3);
                //double ma = +ma1 + ma2 - ma3;

                double mb1 = vec2.dotProduct(vec1);
                double mb2 = vec2.dotProduct(vec2);
                double mb3 = vec2.dotProduct(vec3);
                //double mb = +mb1 + mb2 - mb3;

                double mc1 = vec3.dotProduct(vec1);
                double mc2 = vec3.dotProduct(vec2);
                double mc3 = vec3.dotProduct(vec3);
                //double mc = +mc1 + mc2 - mc3;

                double marginA[][] = new double[4][4];
                marginA[0][0] = ma1;
                marginA[0][1] = ma2;
                marginA[0][2] = -ma3;
                marginA[0][3] = 1;

                marginA[1][0] = mb1;
                marginA[1][1] = mb2;
                marginA[1][2] = -mb3;
                marginA[1][3] = 1;

                marginA[2][0] = mc1;
                marginA[2][1] = mc2;
                marginA[2][2] = -mc3;
                marginA[2][3] = 1;

                marginA[3][0] = pn1;
                marginA[3][1] = pn2;
                marginA[3][2] = pn3;
                marginA[3][3] = 0;

                System.out.println("a:  " + Arrays.deepToString(marginA));
                double marginB[][] = new double[4][1];
                marginB[0][0] = 1;
                marginB[1][0] = 1;
                marginB[2][0] = -1;
                marginB[3][0] = 0;
                // ( A^t * A )^-1   * A^t  *   B
                double[][] transposeA = Matrix.pose(marginA);
                System.out.println("transpsoe:  " + Arrays.deepToString(transposeA));

                double[][] beforeInverse = Matrix.multi(transposeA, marginA);
                System.out.println(Arrays.deepToString(beforeInverse));

                double[][] inverse = Matrix.inverse(beforeInverse);
                System.out.println("inverse:  " + Arrays.deepToString(inverse));

                double[][] notB = Matrix.multi(inverse, transposeA);
                System.out.println(Arrays.deepToString(notB));

                double[][] fin = Matrix.multi(notB, marginB);
                System.out.println(Arrays.deepToString(fin));

            } else if (userInput.equals("5")) {
                //System.out.println(vec1);
            } else if (userInput.equals("6")) {
                System.exit(0);
            }
        }
    }
}

//                System.out.println("    \r\nFirst Lambda (y)");
//                double vy1 = parseDouble(scans.nextLine());
//                System.out.println(vy1);
//
//                System.out.println("    \r\nFirst +1 or -1 Side");
//                int pn2 = parseInt(scans.nextLine());
//                System.out.println(pn2);
//
//                System.out.println("    \r\nFirst Lambda (x)");
//                double vx2 = parseDouble(scans.nextLine());
//                System.out.println(vx2);
//
//                System.out.println("    \r\nFirst Lambda (y)");
//                double vy2 = parseDouble(scans.nextLine());
//                System.out.println(vy2);
//
//                System.out.println("    \r\nFirst +1 or -1 Side");
//                int pn3 = parseInt(scans.nextLine());
//                System.out.println(pn3);
//
//                System.out.println("    \r\nFirst Lambda (x)");
//                double vx3 = parseDouble(scans.nextLine());
//                System.out.println(vx3);
//
//                System.out.println("    \r\nFirst Lambda (y)");
//                double vy3 = parseDouble(scans.nextLine());
//                System.out.println(vy3);
