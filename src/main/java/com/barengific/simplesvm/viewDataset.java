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

    public static double w01;
    public static double w02;
    public static double[] wt1 = new double[2];
    public static double[] wt2 = new double[2];

    Matrix matrix = new Matrix();
    private static final long serialVersionUID = 6294689542092367723L;
    private static String fileLoc = "C:\\Users\\Admino\\Documents\\NetBeansProjects\\dataset.txt";
    private static String testLoc = "C:\\Users\\Admino\\Documents\\NetBeansProjects\\testdata.txt";

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

    public static ArrayList<ArrayList<Double>> testData() {
        BufferedReader reader = null;
        ArrayList<String> res = new ArrayList<>();

        ArrayList<ArrayList<Double>> test_dataset = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            test_dataset.add(new ArrayList());
        }

        try {
            reader = new BufferedReader(new FileReader(testLoc));

            while (reader.ready()) {
                res.add(reader.readLine());
            }
            for (int i = 0; i < 20; i++) {
                String[] a = (res.get(i).split(","));
                test_dataset.get(0).add(Double.parseDouble(a[0].toString()));
                test_dataset.get(1).add(Double.parseDouble(a[1].toString()));
            }
            System.out.println("Test Data Class: " + test_dataset.toString());
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
        return test_dataset;
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
        DatasetGen dg = new DatasetGen();
        Scanner scans = new Scanner(System.in);  // Create a Scanner object
        while (true) {
            System.out.println("\r\n+++++Select Options+++++");
            System.out.println("\r\n1) Generate Dataset \r\n2) Generate Test Data \r\n3) Display Current Dataset \r\n4) Visualise Current Dataset \r\n5) Enter SVM1 \r\n6) Enter SVM2 \r\n7) Test Datapoint \r\n8) Use Test Data \r\n9) Exit");

            String userInput = scans.nextLine();  // Read user input
            System.out.println("User Selected Option: " + userInput);  // Output user input
            if (userInput.equals("1")) {
                DatasetGen.dataGen();
            } else if (userInput.equals("2")) {
                dg.testGen();
                System.out.println();
                //DatasetGen.testGen();
            } else if (userInput.equals("3")) {
                readDatas();
            } else if (userInput.equals("4")) {
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
            } else if (userInput.equals("5")) {
                svmCal(scans, 1);
            } else if (userInput.equals("6")) {
                svmCal(scans, 2);
            } else if (userInput.equals("7")) {
                //test data point
                //𝑤𝑇 * 𝑥 + 𝑤0     ----for both SVMS
                System.out.println("    Enter Datapoint (x1)");
                double x1[] = new double[2];
                x1[0] = Double.parseDouble(scans.nextLine().trim());
                x1[1] = Double.parseDouble(scans.nextLine().trim());

                //SVM1
                double aa = Matrix.multiA(wt1, x1);
                double svm1 = w01 + aa;
                System.out.println("svm1: " + svm1);

                //SVM2
                double bb = Matrix.multiA(wt2, x1);
                double svm2 = bb + w02;
                System.out.println("svm2: " + svm2);

                if (svm1 >= 0d && svm2 >= 0d) {
                    System.out.println("Datapoint is Class 1 !!");
                } else if (svm1 >= 0d && svm2 < 0d) {
                    System.out.println("Datapoint is Class 2 !!");
                } else if (svm1 < 0d && svm2 >= 0d) {
                    System.out.println("Datapoint is Class 3 !!");
                } else if (svm1 < 0d && svm2 < 0d) {
                    System.out.println("Datapoint is Undefined !!");
                }

            } else if (userInput.equals("8")) {
                //test dataset of test
                ArrayList<ArrayList<Double>> test_dataset = testData();
                double x1[] = new double[2];

                for (int i = 0; i < 20; i++) {
                    x1[0] = test_dataset.get(0).get(i);
                    x1[1] = test_dataset.get(1).get(i);

                    //SVM1
                    double aa = Matrix.multiA(wt1, x1);
                    double svm1 = w01 + aa;

                    //SVM2
                    double bb = Matrix.multiA(wt2, x1);
                    double svm2 = bb + w02;

                    if (svm1 >= 0d && svm2 >= 0d) {
                        System.out.println(i + " : " + Arrays.toString(x1) + " Class A");
                    } else if (svm1 >= 0d && svm2 < 0d) {
                        System.out.println(i + " : " + Arrays.toString(x1) + " Class B");
                    } else if (svm1 < 0d && svm2 >= 0d) {
                        System.out.println(i + " : " + Arrays.toString(x1) + " Class C");
                    } else if (svm1 < 0d && svm2 < 0d) {
                        System.out.println(i + " : " + Arrays.toString(x1) + " Undefined");
                    }

                }

            } else if (userInput.equals("9")) {
                System.exit(0);
            }
        }
    }

    public static void svmCal(Scanner scans, int svmNo) {
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

        double marginB[][] = new double[4][1];
        marginB[0][0] = 1;
        marginB[1][0] = 1;
        marginB[2][0] = -1;
        marginB[3][0] = 0;
        // ( A^t * A )^-1   * A^t  *   B
        double[][] transposeA = Matrix.pose(marginA);
        double[][] beforeInverse = Matrix.multi(transposeA, marginA);
        double[][] inverse = Matrix.inverse(beforeInverse);
        double[][] notB = Matrix.multi(inverse, transposeA);
        double[][] fin = Matrix.multi(notB, marginB);

//                System.out.println("a:  " + Arrays.deepToString(marginA));
//                System.out.println("transpsoe:  " + Arrays.deepToString(transposeA));
//                System.out.println(Arrays.deepToString(beforeInverse));
//                System.out.println("inverse:  " + Arrays.deepToString(inverse));
//                System.out.println(Arrays.deepToString(notB));
        //System.out.println(Arrays.deepToString(fin) + "\r\n");
        double[][] l1 = new double[1][1];
        l1[0][0] = fin[0][0];
        double[][] l2 = new double[1][1];
        l2[0][0] = fin[1][0];
        double[][] l3 = new double[1][1];
        l3[0][0] = fin[2][0];
        //System.out.println(Arrays.deepToString(l1) + " : " + Arrays.deepToString(l2) + " : " + Arrays.deepToString(l3));

        double[][] l1t = new double[2][1];
        l1t = Matrix.multi(v1, l1);
        double[][] l2t = new double[2][1];
        l2t = Matrix.multi(v2, l2);
        double[][] l3t = new double[2][1];
        l3t = Matrix.multi(v3, l3);
        //System.out.println("here:  " + Arrays.deepToString(l1t) + " : " + Arrays.deepToString(l2t) + " : " + Arrays.deepToString(l3t));

        double[][] l12t = new double[2][1];
        l12t = Matrix.add(l1t, l2t);
        double[][] l123t = new double[2][1];
        l123t = Matrix.subtract(l12t, l3t);

        if (svmNo == 1) {
            wt1[0] = l123t[0][0];
            wt1[1] = l123t[1][0];
            //huperplane 𝑤𝑇 * 𝑥 + 𝑤0 
            System.out.println("svm1:  " + Arrays.toString(wt1));
            w01 = fin[3][0];
        } else if (svmNo == 2) {
            wt2[0] = l123t[0][0];
            wt2[1] = l123t[1][0];
            System.out.println("svm2:  " + Arrays.toString(wt2));
            w02 = fin[3][0];
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
