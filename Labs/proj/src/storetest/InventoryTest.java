/**
 *          SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 1.0
 *
 * SYSC 2004 Project - Milestone 3 Inventory Test
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */

package storetest;

import store.*;

import org.junit.jupiter.api.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

/**
 * This class represents the testing for the inventory class. It contains one instance of Inventory and three Product
 * objects.
 */
public class InventoryTest {
    private static Product p1;
    private static Product p2;
    private static Product p3;
    private static Inventory i1;

    private static ArrayList<Product> testProducts1;

    /**
     * This method initializes the Product instances, the ArrayList that contains the test Product objects, and
     * the Inventory instance.
     */
    @BeforeAll
    public static void init(){
        p1 = new Product("Guitar", 1, 500.99);
        p2 = new Product("Piano", 2, 1000.99);
        p3 = new Product("Drums", 3, 600.99);

        testProducts1 = new ArrayList<>();

        testProducts1.add(p1);
        testProducts1.add(p2);
        testProducts1.add(p3);

        i1 = new Inventory();

    }

    /**
     * This method is the first test to be called. It ensures the constructor was initialized properly. It checks
     * the sizes of the Product ArrayList and Stock ArrayList in Inventory.
     */
    @Test
    @Order(1)
    public void testInitialSetUp(){
        assertEquals(1, i1.getProducts().size(), "The product ArrayList initializer in the " +
                "constructor is not working.");
        assertEquals(1, i1.getStock().size(),  "The stock ArrayList initializer in the " +
                "constructor is not working.");
    }

    /**
     * This method is the second test to be called. It tests adding non existent products to the Inventory. It checks
     * that the sizes of the Product ArrayList and the Stock ArrayList have increased by one in the Inventory.
     */
    @Test
    @Order(2)
    public void testAddStockToNonExistingProduct(){
        int currentStock = 1; // Counter for the expected sizes of the Product and Stock ArrayLists
        final int STOCK = 1;

        for (Product p : testProducts1){
            i1.setStock(STOCK, p.getName(), p.getProductID(), p.getPrice());
            assertEquals(currentStock + 1, i1.getProducts().size(), "The set stock for adding the " +
                    String.valueOf(p.getProductID()) + " in the Product ArrayList is not working.");
            assertEquals(currentStock + 1, i1.getStock().size(), "The set stock for adding the " +
                    String.valueOf(p.getProductID()) + " in the Stock ArrayList is not working.");
            currentStock++;
        }
    }

    /**
     * This method is the third test to be called. It tests adding to stock of an existing product. It checks
     * that the new stock value is as expected. It also checks that the size of the Product and Stock ArrayLists
     * have not increased.
     */
    @Test
    @Order(3)
    public void testAddStockToExistingProduct(){

        int oldSizeProduct;
        int oldSizeStock;

        final int ADDSTOCKVAL = 1;
        final int NEWSTOCKVAL = 2;

        for (Product p : testProducts1){

            oldSizeProduct = i1.getProducts().size();
            oldSizeStock = i1.getStock().size();

            i1.setStock(ADDSTOCKVAL, p.getProductID());

            assertEquals(oldSizeProduct, i1.getProducts().size(), "The size of the Product ArrayList is " +
                    "increasing for number " + String.valueOf(p.getProductID()) + " and it should not.");

            assertEquals(oldSizeStock, i1.getStock().size(), "The size of the Stock ArrayList is " +
                    "increasing for number " + String.valueOf(p.getProductID()) + " and it should not.");

            assertEquals(NEWSTOCKVAL, i1.getStock(p.getProductID()), "The set stock for existing product " +
                    "number " + String.valueOf(p.getProductID()) + " is not working.");
        }
    }

    /**
     * This method is the fourth test to be called. It tests the retrieval of a specific product given the product
     * ID.
     */
    @Test
    @Order(4)
    public void testGetProduct(){
        for (Product p : testProducts1){
            assertEquals(p.getName(), i1.getProduct(p.getProductID()).getName(), "The get product by " +
                    "product ID for product number " + String.valueOf(p.getProductID()) + " is not working.");
        }
    }

    /**
     * This method is the fifth test to be called. It tests the proper retrieval of the Products ArrayList in the
     * Inventory by iterating through the returned ArrayList and comparing the expected ProductIDs.
     */
    @Test
    @Order(5)
    public void testGetProducts(){

        ArrayList<Product> testGetProducts = i1.getProducts();

        for (int i = 1; i < i1.getProducts().size(); i++){
            assertEquals(testProducts1.get(i - 1).getProductID(), testGetProducts.get(i).getProductID(),
                    "The get product ArrayList is not working for item at index " + i + ".");
        }
    }

    /**
     * This method is the sixth test to be called. It tests the proper retrieval of the Stocks ArrayList in the
     * Inventory by comparing it against the size of the expected size of Stock.
     */
    @Test
    @Order(6)
    public void testGetStock(){
        assertEquals(testProducts1.size() + 1, i1.getStock().size(), "The get stock ArrayList is not working.");
    }

    /**
     * This method is the seventh test to be called. It tests the proper removal of the stock of a certain product in
     * Inventory.
     */
    @Test
    @Order(7)
    public void testRemoveProduct(){
        final int EXPECTEDSTOCK = 1;
        final int REMOVESTOCK = 1;

        for (Product p : testProducts1){
            i1.removeStock(REMOVESTOCK, p.getProductID());

            assertEquals(EXPECTEDSTOCK, i1.getStock(p.getProductID()), "The get product by product " +
                    "ID for product number " + String.valueOf(p.getProductID()) + " is not working.");
        }
    }



}
