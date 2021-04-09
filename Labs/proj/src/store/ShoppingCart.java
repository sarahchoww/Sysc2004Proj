/**
 *                 SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 4.0
 *
 * SYSC 2004 Project - Milestone 5 Shopping Cart Class
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */

package store;

import java.util.ArrayList;

/**
 * A shopping cart
 */
public class ShoppingCart implements ProductStockContainer {

    private int cartID;

    // { [productID, quantity] }
    private ArrayList<Integer[]> itemsInCart = new ArrayList<>();

    /**
     * Parametric constructor for ShoppingCart.
     * Sets first element of itemsInCart to null to avoid indices shift
     *
     * @param cartID    int, sets cartID for this cart
     */
    public ShoppingCart(int cartID){
        this.cartID = cartID;
        this.itemsInCart.add(0, null);
    }

    /**
     * Accessor for itemsInCart ArrayList
     *
     * @return ArrayList    itemsInCart attribute
     */
    public ArrayList<Integer[]> getItemsInCart(){
        return this.itemsInCart;
    }

    /**
     * Method to get number of products in cart.
     * @return number of products in cart, int
     */
    @Override
    public int getNumOfProducts(){
        return getItemsInCart().size();
    }

    /**
     * Mutator for cartID attribute
     *
     * @param cartID    int, new cartID to be set
     * @return void
     */
    public void setCartID(int cartID){
        this.cartID = cartID;
    }

    /**
     * Method to get quantity of product
     * @param p product object
     * @return quantity of product
     */
    @Override
    public int getProductQuantity(Product p){
        return itemsInCart.get(p.getProductID())[1];
    }

    /**
     * Adds product to cart if valid
     * @param p the product object
     * @param quantity quantity to be added
     */
    @Override
    public void addProductQuantity(Product p, int quantity){

        for (int i  = 1; i < itemsInCart.size(); i++){
            if (itemsInCart.get(i)[0] == p.getProductID()){
                itemsInCart.get(i)[1] += quantity;

                return;
            }
        }

        Integer[] newItem = {p.getProductID(), quantity};
        itemsInCart.add(newItem); // If product does not exist in cart
    }


    /**
     * Removes product from cart if valid
     * @param p product object
     * @param quantity that should be removed
     */
    @Override
    public void removeProductQuantity(Product p, int quantity){

        for (int i  = 1; i < itemsInCart.size(); i++){
            if (itemsInCart.get(i)[0] == p.getProductID()){
                itemsInCart.get(i)[1] -= quantity;
            }
        }
    }

    /**
     * Setter method to set the itemsInCart attribute.
     * @param itemsInCart represents the new itemsInCart, ArrayList<Integer[]>
     */
    public void setItemsInCart(ArrayList<Integer[]> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }
}
