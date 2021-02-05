/*===================================================
                SYSC 2004 Winter 2021

Names:
Michael Whitford, 101151720
Sarah Chow, Sarah Chow, 101143033

SYSC 2004 Project - Milestone 1 Inventory Class

Used to manage the store's products, as well as
the stock of each product

Copyright © 2021 Michael Whitford & Sarah Chow.
All rights reserved.
====================================================*/

import java.util.ArrayList;

public class Inventory {
    //Beginning of inventory class

    private ArrayList<Integer> stock = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();


    public Inventory(){

    }

    public void getProductInfo(int productID){
        System.out.println("Name: " + this.products.get(productID - 1).getName() + " Product ID: " + productID +
                " Price: " + this.products.get(productID - 1).getPrice());
    }

    public int getStock(int productID){
        return stock.get(productID - 1); // Subtract one as productIDs start from 1
    }

    public void setStock(int stock, String name){

        int count = 0;
        boolean found = false;

        while (count < products.size() && !found){
            if (products.get(count).getName().equals(name)){
                this.stock.set(count, stock); // Count is the index
                found = true;
            }
            count++;
        }
    }

    public void setStock(int stock, String name, double price){
        Product product = new Product(name, products.size() - 1, price);

        this.stock.add(stock);
        this.products.add(product);
    }

    public void removeStock(int stock, int productID){
        int count = 0;
        boolean found = false;

        while (count < products.size() && !found){
            if (products.get(count).getProductID() == productID){

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