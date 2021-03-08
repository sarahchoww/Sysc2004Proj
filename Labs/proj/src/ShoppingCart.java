/**
 *                 SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 1.0
 *
 * SYSC 2004 Project - Milestone 2 Shopping Cart Class
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */
import java.util.ArrayList;

/**
 * A shopping cart
 */
public class ShoppingCart {

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
     * Mutator for cartID attribute
     *
     * @param cartID    int, new cartID to be set
     * @return void
     */
    public void setCartID(int cartID){
        this.cartID = cartID;
    }

    /**
     * Adds product to cart if valid
     *
     * @param productID   int, productID of product to be added
     * @return boolean    true if product could be added, false otherwise
     */
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

    /**
     * Removes product from cart if valid
     *
     * @param productID   int, productID of product to be removed
     * @return boolean    true if product could be removed, false otherwise
     */
    public boolean removeProduct(int productID){

        for (int i  = 1; i < itemsInCart.size(); i++){
            if (itemsInCart.get(i)[0] == productID){
                itemsInCart.get(i)[1] --; // If product is already added to cart, increment quantity

                return true;
            }
        }

        return false;
    }
}
