/**
 *              SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, Sarah Chow, 101143033
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
    public void setStock(int stock, String name){
        int count = 1;
        boolean exit = false;

        // Search for the desired product
        while ((count < (products.size())) && !exit){
            // Offset by 1 as comparing an offset counter by a non-offset size

            if (getProduct(count).getName().equals(name)){
                this.stock.set(count, stock); // Count is the index
                exit = true; // Exit loop
            }
            count++;
        }
    }

    // Function overloading - to create a new product and set stock
    public void setStock(int stock, String name, double price){
        Product product = new Product(name, products.size(), price);

        this.stock.add(stock);
        this.products.add(product);
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