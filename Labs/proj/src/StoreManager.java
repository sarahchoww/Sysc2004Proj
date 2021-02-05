/*===================================================
                SYSC 2004 Winter 2021

Names:
Michael Whitford, 101151720
Sarah Chow, 101143033

SYSC 2004 Project - Milestone 1 StoreManager Class

Used to manage the inventory class

Copyright © 2021 Michael Whitford & Sarah Chow.
All rights reserved.
====================================================*/

import java.util.ArrayList;

public class StoreManager {

    private Inventory inventory;

    StoreManager() {
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    //Wrapper function for getStock in inventory class
    public int getStock (int productID) {
        //TODO: implement getStock
        return this.inventory.getStock(productID);
    }

    //Processes transaction. Returns total value of
    //items purchased and removes them from stock.
    //Return of -1 indicates error
    public double transaction (ArrayList<Integer[]> cart) {

        double total = 0.0;

        final int productID_index = 0; //location of productID of item in cart array
        final int quantity_index = 1; //location of quantity of item in cart array

        for (Integer[] item : cart) {

            int productID = item[productID_index];
            int quantity = item[quantity_index];

            //Exit if insufficient stock of the product
            if (quantity > this.getStock(productID)) {
                return -1.0;
            }

            //TODO: implement getProduct
            total += this.inventory.getProduct(productID).getPrice() * quantity;

            //TODO: implement removeStock
            this.inventory.removeStock(quantity, productID);
        }

        return total;
    }

}
