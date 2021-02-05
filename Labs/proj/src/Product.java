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

    //Attributes are all final as they cannot be
    //changed after object creation

    private final String name;      //Product Name
    private final int productID;    //Product ID
    private final double price;     //Price of product

    //Parametric constructor
    Product(String name, int productID, double price) {
        this.name = name;
        this.productID = productID;
        this.price = price;
    }

    //Accessor Methods
    public String getName() {
        return this.name;
    }

    public int getProductID() {
        return this.productID;
    }

    public double getPrice() {
        return this.price;
    }
}
