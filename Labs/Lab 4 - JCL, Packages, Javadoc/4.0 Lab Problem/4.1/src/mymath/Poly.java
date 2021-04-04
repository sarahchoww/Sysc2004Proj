/**
 * This document depicts the class Poly and its methods and attributes.
 * @author Sarah Chow, L3
 */
package mymath;

import java.lang.Math;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 * This class represents a polynomial. Each object has an array of coefficients and another
 * variable to store the length of that array.
 */
public class Poly {

    private double[] coefficients;
    private int arrLen;

    /**
     * This method is a constructor for an object of Poly.
     * @param coefficients represents the array of coefficients
     */
    public Poly(double[] coefficients){
        this.coefficients = coefficients;
        arrLen = coefficients.length;
    }

    /**
     * This method accesses the private integer of the array size of the coefficients.
     * @return an integer that is the length of the array of coefficients
     */
    public int getSize(){
        return arrLen;
    }

    /**
     * This method accesses the array of coefficients.
     * @return an array of doubles of the coefficients
     */
    public double[] getArray(){
        return coefficients;
    }

    /**
     * This method evaluates the polynomial expression using given x value.
     * @param x represents the value of x in the polynomial
     * @return a double that is the answer of the polynomial expression with the given x value
     */
    public double evaluate(int x){
        double result = 0.0;

        for (int i = 0; i < arrLen; i++){
            result += coefficients[i] * pow(x, arrLen - i - 1);
        }

        return result;
    }

    /**
     * This method prints the polynomial with the coefficients.
     */
    public void printPoly(){
        String result = "";

        for (int i = 0; i < arrLen; i++){

            if (coefficients[i] > 0){
                result += String.valueOf(abs(coefficients[i])); // To get the absolute value of the coefficient

                if ((arrLen - i - 1) != 0){
                    result += "x^" + String.valueOf(arrLen - i - 1);

                    if (coefficients[i + 1] > 0){
                        result += " + ";
                    }
                    else if (coefficients[i + 1] < 0){
                        result += " - ";
                    }
                }
            }
        }
        System.out.println(result);
    }
}
