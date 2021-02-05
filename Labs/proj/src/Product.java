/*===================================================
                SYSC 2004 Winter 2021

Names:
Michael Whitford, 101151720
Sarah Chow, Sarah Chow, 101143033

SYSC 2004 Project - Milestone 1 Project Class

Used to contain the info for each product sold in the
store

Copyright © 2021 Michael Whitford & Sarah Chow.
All rights reserved.
====================================================*/

public class Product {
    //Beginning of Product Class

    private final String name;
    private final int productID;
    private final double price;

    public Product(String name, int productID, double price){
        this.name = name;
        this.productID = productID;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getProductID(){
        return productID;
    }

    public double getPrice() {
        return price;
    }
}
