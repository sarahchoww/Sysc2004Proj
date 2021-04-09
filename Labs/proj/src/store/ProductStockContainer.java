/**
 *              SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 1.0
 *
 * SYSC 2004 Project - Milestone 5 Product Stock Container Interface
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */


package store;

/**
 * A product stock container interface.
 */
public interface ProductStockContainer {

    /**
     * Returns amount of stock of a product.
     *
     * @param p product object
     * @return int of product quantity
     */
    public int getProductQuantity(Product p);

    /**
     * Method to set quantity of existing product
     * @param p product object
     * @param quantity amount being set for product
     */
    public void addProductQuantity(Product p, int quantity);

    /**
     * Removes quantity for a given product
     *
     * @param p product object
     * @param quantity amount being removed for product
     */
    public void removeProductQuantity(Product p, int quantity);

    /**
     * Method to get number of products.
     *
     * @return number of products, int
     */
    public int getNumOfProducts();
}
