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


    // [productID, quantity]

    private ArrayList<Integer[]> itemsInCart = new ArrayList<>();



    public ShoppingCart(int cartID){
        this.inUse = true;
        this.cartID = cartID;
        this.itemsInCart.add(0, null);
    }

    public ArrayList<Integer[]> getItemsInCart(){
        return this.itemsInCart;
    }


    public boolean addProduct(int productID){

        for (int i  = 1; i < itemsInCart.size(); i++){
            if (itemsInCart.get(i)[0] == productID){
                itemsInCart.get(i)[1] ++; // If product is already added to cart, increment quantity
                return true;
            }
        }

        Integer[] newItem = {productID, 1};
        itemsInCart.add(newItem); // If product does not exist in cart

        return true;
    }

    public boolean removeProduct(int productID){
        for (int i  = 1; i < itemsInCart.size(); i++){
            if (itemsInCart.get(i)[0] == productID){
                itemsInCart.get(i)[1] --; // If product is already added to cart, increment quantity
                return true;
            }
        }

        return false;
    }

    public void setCartID(int cartID){
        this.cartID = cartID;
    }

    public ArrayList<Integer[]> getReceipt(){
        return itemsInCart;
    }

}
