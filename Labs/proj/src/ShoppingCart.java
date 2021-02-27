/**
 *                 SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 1.0
 *
 * SYSC 2004 Project - Milestone 2 Shopping Cart Class
 *
 *  ***************************************************ADD DOCUMENTATION
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */

import java.util.ArrayList;

public class ShoppingCart {

    private int cartID;
    private boolean inUse;

    // "Upon request, the StoreManager should return a new, unique cartID. This means StoreManager should
    // be keeping track of cartIDs in some way"
    // StoreManager should have the inUse variable?



    private ArrayList<Integer[]> cart = new ArrayList<>();

    private Inventory inventory;


    public void addProduct(int productID, int quantity){

        // Need to have the inventory as static
        // Shopping Cart will be hosted by different instances of store manager and we need all the
        // Inventories to be synced

        inventory.removeStock(quantity, productID);

    }

    public void removeProduct(int productID, int quantity){

        inventory.setStock(quantity, productID);

    }

    public void setCartID(int cartID){
        this.cartID = cartID;

    }

    public ArrayList<Integer[]> getReceipt(){
        return cart;
    }


}
