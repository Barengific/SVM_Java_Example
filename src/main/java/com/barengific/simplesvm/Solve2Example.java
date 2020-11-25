/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barengific.simplesvm;

import java.util.Arrays;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;

public class Solve2Example {

    public static void main(String[] args) {
        try {
            ExprEvaluator util = new ExprEvaluator();
            double a[][] = {{784, 1596, -1960, 1},
            {1596, 4474, -4830, 1},
            {1960, 4830, -5476, 1},
            {1, 1, -1, 0}};
            double b[][] = {{1}, {1}, {-1}, {0}};
            String q[][] = {{"x"}, {"y"}, {"z"}, {"w"}};

            IExpr result = util.evaluate("Solve(" + Arrays.deepToString(a) + "*" + Arrays.deepToString(q) + "==" + Arrays.deepToString(b) + ")");
            // print: {{x->-5/2}}
            System.out.println(result.toString());

            //result = util.evaluate("Roots(2*x==5+4*x, x)");
            // print: x==-5/2
            System.out.println(result.toString());
        } catch (SyntaxError e) {
            // catch Symja parser errors here
            System.out.println(e.getMessage());
        } catch (MathException me) {
            // catch Symja math errors here
            System.out.println(me.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
