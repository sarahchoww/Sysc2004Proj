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

    public int getProductQuantity(Product p);
    public void addProductQuantity(Product p, int quantity);
    public void removeProductQuantity(Product p, int quantity);
    public int getNumOfProducts();
}
