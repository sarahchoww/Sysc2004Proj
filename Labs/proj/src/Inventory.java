/**
 *              SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 2.0
 *
 * SYSC 2004 Project - Milestone 2 Inventory Class
 *
 * Used to manage the store's products, as well as
 * the stock of each product
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */

import java.util.ArrayList;

public class Inventory {
    //Beginning of inventory class

    private ArrayList<Integer> stock = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public Inventory(){
        // Setting the first index of both arraylists to null to offset
        // the indices to match the productIDs
        stock.add(0, null);
        products.add(0, null);
    }

    // Wrapper method to get the Product object from the productID
    public Product getProduct(int productID){
        return products.get(productID);
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public ArrayList<Integer> getStock() {
        return this.stock;
    }

    public void getProductInfo(int productID){
        System.out.println("Name: " + getProduct(productID).getName() + " Product ID: " + productID +
                " Price: " + getProduct(productID).getPrice());
    }

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

    // Function overloading - to set stock of existing product
    public void setStock(int stock, int productID){

        int newStock = this.getStock(productID) + stock;

        this.stock.set(productID, newStock);

    }

    // Function overloading - to create a new product and set stock
    public void setStock(int stock, String name, int productID, double price){
        if (this.stock.size() > productID){
            setStock(stock, productID);
            System.out.println("hello");
        }
        else{
            Product product = new Product(name, productID, price);

            this.stock.add(stock);
            this.products.add(product);
        }

    }

    public void removeStock(int stock, int productID){
        int count = 1;
        boolean found = false;

        while ((count < (products.size())) && !found){

            if (getProduct(count).getProductID() == productID){

                // Check to see if product will have remaining stock
                if ((this.stock.get(count) - stock) > 0){
                    this.stock.set(count, this.stock.get(count) - stock);
                }
                else{
                    this.stock.set(count, 0);
                }
                found = true;
            }
            count++;
        }

        if (!found){
            System.out.println("Item not found!");
        }
    }
}
