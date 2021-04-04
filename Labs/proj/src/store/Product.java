/**
 *              SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 3.0
 *
 * SYSC 2004 Project - Milestone 4 Product Class
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */

package store;

/**
 * A Product class. Contains the info for each product sold in the store
 */

public class Product {

    private final String NAME;
    private final int PRODUCTID;
    private final double PRICE;

    /**
     * Parametric constructor for a Product.
     *
     * @param name          String, product name
     * @param productID     int, productID
     * @param price         double, product price
     */
    public Product(String name, int productID, double price){
        NAME = name;
        PRODUCTID = productID;
        PRICE = price;
    }

    /**
     * Accessor method for product's name
     *
     * @return NAME      String, product's name
     */
    public String getName(){ return this.NAME; }

    /**
     * Accessor method for product's ID
     *
     * @return  PRODUCTID     int, product's ID
     */
    public int getProductID(){ return this.PRODUCTID; }

    /**
     * Accessor method for product's price
     *
     * @return PRICE      double, product's price
     */
    public double getPrice() { return this.PRICE; }
}
