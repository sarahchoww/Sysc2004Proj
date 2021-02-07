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

    // Wrapper function for getStock in inventory class
    public int getStock (int productID) {
        return this.inventory.getStock(productID);
    }

    // Processes transaction. Returns total value of items purchased and removes
    // them from stock. Return of -1 indicates error
    public double transaction (ArrayList<Integer[]> cart) {

        double total = 0.0;

        // Define indices of ProductID and Quantity in each sub-array of cart
        final int ID_INDEX = 0;
        final int QUANTITY_INDEX = 1;

        for (Integer[] item : cart) {

            int productID = item[ID_INDEX]; // Get product ID in item array
            int quantity = item[QUANTITY_INDEX]; // Get quantity in item array

            // Exit if insufficient stock of the product
            if (quantity > this.getStock(productID)) {
                return -1.0;
            }

            total += this.inventory.getProduct(productID).getPrice() * quantity;

            this.inventory.removeStock(quantity, productID);
        }

        return total;
    }

}
