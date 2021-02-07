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

    private final String NAME;
    private final int PRODUCTID;
    private final double PRICE;

    public Product(String name, int productID, double price){
        NAME = name;
        PRODUCTID = productID;
        PRICE = price;
    }

    public String getName(){ return NAME; }

    public int getProductID(){ return PRODUCTID; }

    public double getPrice() { return PRICE; }
}
