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

    private final String Name;
    private final int ProductID;
    private final double Price;

    public Product(String name, int productID, double price){
        Name = name;
        ProductID = productID;
        Price = price;
    }

    public String getName(){
        return Name;
    }

    public int getProductID(){
        return ProductID;
    }

    public double getPrice() {
        return Price;
    }
}
