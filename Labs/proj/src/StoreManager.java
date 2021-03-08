/**
 *              SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 2.0
 *
 * SYSC 2004 Project - Milestone 2 Store Manager Class
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */


import java.util.ArrayList;

/**
 * Store Manager Class. Used to manage the inventory class.
 */

public class StoreManager {

    private static Inventory inventory;
    private ArrayList<Integer> cartID = new ArrayList<>();

    /**
     * Default constructor for Store Manager
     */
    public StoreManager() {
        this.inventory = new Inventory();
        this.cartID.add(0, null);
    }

    /**
     * Accessor for inventory attribute
     *
     * @return inventory     Inventory, inventory attribute for this class
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Wrapper function for getStock in inventory class
     *
     * @param productID     int, productID of specific product
     * @return int          quantity of stock of specific product
     */
    public int getStock (int productID) {
        return this.inventory.getStock(productID);
    }

    /**
     * Accessor for cartID array
     *
     * @return cartID  ArrayList<Integer>, cartID attribute
     */
    public ArrayList<Integer> getCartID() {
        return this.cartID;
    }

    /**
     * Adds product to cart if valid, and removes stock from inventory
     * accordingly
     *
     * @param productID     int, productID of specific product
     * @param cart          ShoppingCart, user's cart that product is being added to
     * @return void
     */
    public void addToCart(ShoppingCart cart, int productID){
        if(cart.addProduct(productID)){
            inventory.removeStock(1, productID);
        }
    }

    /**
     * Removes product to cart if valid, and adds stock from inventory
     * accordingly
     *
     * @param productID     int, productID of specific product
     * @param cart          ShoppingCart, user's cart that product is being removed from
     * @return void
     */
    public void removeFromCart(ShoppingCart cart, int productID){
        if (cart.removeProduct(productID)){
            inventory.setStock(1, productID);
        }
    }

    /**
     * Prints user's receipt at checkout for their given Shopping Cart
     *
     * @param cart      ShoppingCart, user's cart that is being checked out
     * @return void
     */
    public void checkout (ShoppingCart cart) {

        ArrayList<Integer[]> items = cart.getItemsInCart();

        double total = 0.0;

        // Define indices of ProductID and Quantity in each sub-array of cart
        final int ID_INDEX = 0;
        final int QUANTITY_INDEX = 1;

        int productID;
        int quantity;

        System.out.println("|-------------RECEIPT-------------|");
        System.out.println("Quantity | Product Name |    PRICE");


        for (int i = 1; i < items.size(); i++){
            productID = items.get(i)[ID_INDEX]; // Get product ID in item array
            quantity = items.get(i)[QUANTITY_INDEX]; // Get quantity in item array

            if (quantity > 0){
                System.out.printf("%8s %14s %10s%n", items.get(i)[QUANTITY_INDEX],
                        getInventory().getProduct(items.get(i)[ID_INDEX]).getName(),
                        (getInventory().getProduct(items.get(i)[ID_INDEX]).getPrice()) * (items.get(i)[QUANTITY_INDEX]));

                total += this.inventory.getProduct(productID).getPrice() * quantity;
            }
        }
        System.out.println("-----------------------------------");

        System.out.printf("Total: $%.2f%n%n", total);

    }

    /**
     * Assigns new cart ID when new StoreView object is created. ID matches
     * location in cartID arraylist
     *
     * @return int    returns the new assigned cartID
     */
    public int assignNewCartID() {
        this.cartID.add(this.cartID.size());
        return this.cartID.get((this.cartID.size()-1));
    }

}
