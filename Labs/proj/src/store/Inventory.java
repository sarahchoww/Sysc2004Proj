/**
 *              SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 3.0
 *
 * SYSC 2004 Project - Milestone 4 Inventory Class
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */

package store;

import java.util.ArrayList;

/**
 * Inventory Class. Used to manage the store's products, as well as
 * the stock of each product
 */

public class Inventory {
    //Beginning of inventory class

    private ArrayList<Integer> stock = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    /**
     * Constructor for inventory. Initializes first element of stock and products
     * list to null so that there's no offset in indices
     */
    public Inventory(){
        // Setting the first index of both arraylists to null to offset
        // the indices to match the productIDs
        stock.add(0, null);
        products.add(0, null);
    }

    /**
     * Wrapper method to get the Product object from the productID
     *
     * @param productID     int, productID of the Product being searched for
     * @return Product      returns the Product object with the given ID
     */
    public Product getProduct(int productID){
        return products.get(productID);
    }

    /**
     * Accessor method for products attribute
     *
     * @return ArrayList      returns the ArrayList of products attribute
     */
    public ArrayList<Product> getProducts() {
        return this.products;
    }

    /**
     * Accessor method for stock attribute
     *
     * @return ArrayList      returns the ArrayList of stock for each product
     */
    public ArrayList<Integer> getStock() {
        return this.stock;
    }

    /**
     * Prints product info based on a given productID
     *
     * @param productID     int, productID being used to search for a product
     * @return void
     */
    public void getProductInfo(int productID){
        System.out.println("Name: " + getProduct(productID).getName() + " Product ID: " + productID +
                " Price: " + getProduct(productID).getPrice());
    }

    /**
     * Returns amount of stock of a product.
     * Returns error code if product is not in inven tory
     *
     * @param productID     int, productID being used to search for a product
     * @return int          returns quantity of stock of given product
     */
    public int getStock(int productID){
        int stockVal;
        final int ERROR = -1;

        try{
            stockVal = this.stock.get(productID);
        }
        catch(Exception e){
            System.out.println("Item does not exist in stock.");
            return ERROR;
        }
        return stockVal;
    }


    /**
     * Function overloading - to set stock of existing product
     *
     * @param productID     int, productID being used to search for a product
     * @param stock         int, amount of stock being set for product
     * @return void
     */
    public void setStock(int stock, int productID){

        int newStock = this.getStock(productID) + stock;

        this.stock.set(productID, newStock);

    }

    /**
     * Function overloading - to create a new product and set stock
     *
     * @param productID     int, productID of new product
     * @param stock         int, amount of stock being set for product
     * @param name          String, name of new product
     * @param price         double, price of new product
     * @return void
     */
    public void setStock(int stock, String name, int productID, double price){
        if (this.stock.size() > productID){
            setStock(stock, productID);
        }
        else{
            Product product = new Product(name, productID, price);

            this.stock.add(stock);
            this.products.add(product);
        }

    }

    /**
     * Removes stock for a given product
     *
     * @param productID     int, productID being used to search for a product
     * @param stock         int, amount of stock being removed for specific product
     * @return void
     */
    public void removeStock(int stock, int productID){
        int count = 1;

        while (count < (products.size())){

            if (getProduct(count).getProductID() == productID){

                // Check to see if product will have remaining stock
                if ((this.stock.get(count) - stock) > 0){
                    this.stock.set(count, this.stock.get(count) - stock);
                }
                else{
                    this.stock.set(count, 0);
                }
            }
            count++;
        }
    }
}
