/**
 * This document depicts the class PolyCalc and its methods and attributes.
 * @author Sarah Chow, L3
 */

package mymath;

/**
 * This class represents the calculations performed on a given polynomial object.
 */
public class PolyCalc {

    private static int arrSize;
    private static double[] coefficients;

    /**
     * This method differentiates the given polynomial.
     * @param poly represents the polynomial that will be differentiated
     * @return a Poly object that contains the coefficients of the differentiated polynomial
     */
    public static Poly differentiate(Poly poly){
        arrSize = poly.getSize();
        coefficients = poly.getArray();

        Poly newPoly = new Poly(new double[arrSize]);
        double[] newCoefficients = newPoly.getArray();

        newCoefficients[0] = 0.0; // This will always be zero when finding the derivative of a polynomial

        for (int i = 1; i < arrSize; i++){
            newCoefficients[i] = (arrSize - i) * coefficients[i - 1];
        }
        return newPoly;
    }

    /**
     * This method integrates the given polynomial.
     * @param poly represents the polynomial that will be differentiated
     * @return a Poly object that contains the coefficients of the integrated polynomial
     */
    public static Poly integrate(Poly poly){

        double editedCoefficient;

        arrSize = poly.getSize() + 1;
        coefficients = poly.getArray();

        Poly newPoly = new Poly(new double[arrSize]);
        double[] newCoefficients = newPoly.getArray();

        for (int i = 0; i < arrSize; i++){

            if (i == arrSize - 1){
                editedCoefficient = 0.0; // Add the constant 0 at the end
            }
            else {
                editedCoefficient = coefficients[i];
            }
            newCoefficients[i] = editedCoefficient / (arrSize - i - 1);
        }
        return newPoly;
    }
}
