/**
 *             SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 1.0
 *
 * SYSC 2004 Project - Milestone 3 StoreManager Test class
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */

package storetest;

import store.*;

import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//Used to ensure tests are being run in a specific order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

/**
 * A test harness for the StoreManager class
 */
public class StoreManagerTest {

    private static StoreManager s1;
    private static ShoppingCart cart1;

    private static ArrayList<String> productNames;

    /**
     * Initializes static attributes for testing
     *
     * @return void
     */
    @BeforeAll
    public static void init() {
        s1 = new StoreManager();

        //Add stock for the 4 products sold in our program
        s1.getInventory().getStock().addAll(Arrays.asList(5,5,5,5));

        //Add products being sold
        s1.getInventory().getProducts().addAll(Arrays.asList(new Product("Guitar", 1, 999.99),
                new Product("Piano", 2, 1999.99),
                new Product("Flute", 3, 599.99),
                new Product("Saxophone", 4, 799.99)));

        productNames = new ArrayList<>();

        productNames.addAll(Arrays.asList("Guitar", "Piano", "Flute", "Saxophone"));
    }


    /**
     * Unit test for StoreManager constructor
     *
     * @return void
     */
    @Test
    @Order(1)
    public void testConstructor() {
        assertNotNull(s1,
                "STOREMANAGER TEST - CONSTRUCTOR >> FAILED. OBJECT IS NULL");
        assertNotNull(s1.getInventory(),
                "STOREMANAGER TEST - CONSTRUCTOR >> FAILED. INVENTORY ATTRIBUTE IS NULL");
        assertNotNull(s1.getCartID(),
                "STOREMANAGER TEST - CONSTRUCTOR >> FAILED. INVENTORY ATTRIBUTE IS NULL");

        final int EXPECTEDARRAYSIZE = 1;
        assertEquals(EXPECTEDARRAYSIZE, s1.getCartID().size(),
                "STOREMANAGER TEST - CONSTRUCTOR >> FAILED. CARTID ARRAY SIZE IS NOT 1");
        assertNull(s1.getCartID().get(0),
                "STOREMANAGER TEST - CONSTRUCTOR >> FAILED. CARTID ARRAY ELEMENT 0 IS NOT NULL");
    }


    /**
     * Unit test for StoreManager addToCart method
     *
     * @return void
     */
    @Test
    @Order(2)
    public void testAddToCart() {

        //Cart1 is initialized here and not in init, as cart1 being initialized
        //in init would lead to faulty testing of the cartID array size
        //in testConstructor
        cart1 = new ShoppingCart(s1.assignNewCartID());

        //Models the 4 products that are available in our store
        final int PRODUCTID1 = 1;
        final int PRODUCTID2 = 2;
        final int PRODUCTID3 = 3;
        final int PRODUCTID4 = 4;
        final int INITIALQUANTITY = 5; //initial amount of stock for each product

        //Used to retrieve items from itemsInCart Array
        final int ID_INDEX = 0;
        final int QUANTITY_INDEX = 1;

        //For product 1
        int expectedSize = 2;
        int expectedLocation = 1;
        for (int i = 1; i <= 3; i++) {
            s1.addToCart(cart1, PRODUCTID1);

            //Ensure product was added into correct position in itemsInCart Array
            assertEquals(PRODUCTID1, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX],
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. PRODUCT ADDED TO WRONG INDEX");

            //Make sure size of array is correct
            assertEquals(expectedSize, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure new product's quantity is correct
            assertEquals(i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX],
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. INCORRECT QUANTITY OF PRODUCT AT INDEX " +
                            expectedLocation);

            //Ensure inventory stock was decreased accordingly
            assertEquals(INITIALQUANTITY-i, s1.getInventory().getStock(PRODUCTID1),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. INVENTORY NOT DECREASED CORRECTLY");
        }

        //For product 2
        expectedSize = 3;
        expectedLocation = 2;
        for (int i = 1; i <= 3; i++) {
            s1.addToCart(cart1, PRODUCTID2);

            //Ensure product was added into correct position in itemsInCart Array
            assertEquals(PRODUCTID2, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX],
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. PRODUCT ADDED TO WRONG INDEX");

            //Make sure size of array is correct
            assertEquals(expectedSize, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure new product's quantity is correct
            assertEquals(i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX],
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. INCORRECT QUANTITY OF PRODUCT AT INDEX " +
                            expectedLocation);

            //Ensure inventory stock was decreased accordingly
            assertEquals(INITIALQUANTITY-i, s1.getInventory().getStock(PRODUCTID2),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. INVENTORY NOT DECREASED CORRECTLY");
        }

        //For product 3
        expectedSize = 4;
        expectedLocation = 3;
        for (int i = 1; i <= 3; i++) {
            s1.addToCart(cart1, PRODUCTID3);

            //Ensure product was added into correct position in itemsInCart Array
            assertEquals(PRODUCTID3, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX],
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. PRODUCT ADDED TO WRONG INDEX");

            //Make sure size of array is correct
            assertEquals(expectedSize, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure new product's quantity is correct
            assertEquals(i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX],
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. INCORRECT QUANTITY OF PRODUCT AT INDEX " +
                            expectedLocation);

            //Ensure inventory stock was decreased accordingly
            assertEquals(INITIALQUANTITY-i, s1.getInventory().getStock(PRODUCTID3),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. INVENTORY NOT DECREASED CORRECTLY");
        }

        //For product 4
        expectedSize = 5;
        expectedLocation = 4;
        for (int i = 1; i <= 3; i++) {
            s1.addToCart(cart1, PRODUCTID4);

            //Ensure product was added into correct position in itemsInCart Array
            assertEquals(PRODUCTID4, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX],
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. PRODUCT ADDED TO WRONG INDEX");

            //Make sure size of array is correct
            assertEquals(expectedSize, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure new product's quantity is correct
            assertEquals(i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX],
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. INCORRECT QUANTITY OF PRODUCT AT INDEX " +
                            expectedLocation);

            //Ensure inventory stock was decreased accordingly
            assertEquals(INITIALQUANTITY-i, s1.getInventory().getStock(PRODUCTID4),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. INVENTORY NOT DECREASED CORRECTLY");
        }
    }


    /**
     * Unit test for StoreManager removeFromCart method
     *
     * @return void
     */
    @Test
    @Order(3)
    public void testRemoveFromCart() {
        final int PRODUCTID1 = 1;
        final int PRODUCTID2 = 2;
        final int PRODUCTID3 = 3;
        final int PRODUCTID4 = 4;

        //Used to retrieve items from itemsInCart Array
        final int ID_INDEX = 0;
        final int QUANTITY_INDEX = 1;

        final int INITIALSTOCK = 2; //initial amount of stock for each product
        final int INITIALQUANTITY = 3; //initial amount in cart for each product
        final int ARRAYSIZE = 5; //Size of itemsInCart array should not change for removal

        //For product 1
        int expectedLocation = 1;
        for (int i = 1; i <= 3; i++) {
            s1.removeFromCart(cart1, PRODUCTID1);

            //Ensure product is in correct position in itemsInCart Array
            assertEquals(PRODUCTID1, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX],
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. PRODUCT ID ASSOCIATED WITH " +
                            "WRONG INDEX");

            //Make sure size of array is correct
            assertEquals(ARRAYSIZE, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure product's changed quantity is correct
            assertEquals(INITIALQUANTITY - i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX],
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. INCORRECT QUANTITY OF PRODUCT AT INDEX " +
                            expectedLocation);

            //Ensure inventory stock was increased accordingly
            assertEquals(INITIALSTOCK+i, s1.getInventory().getStock(PRODUCTID1),
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. INVENTORY NOT DECREASED CORRECTLY");
        }

        //For product 2
        expectedLocation = 2;
        for (int i = 1; i <= 3; i++) {
            s1.removeFromCart(cart1, PRODUCTID2);

            //Ensure product is in correct position in itemsInCart Array
            assertEquals(PRODUCTID2, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX],
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. PRODUCT ID ASSOCIATED WITH " +
                            "WRONG INDEX");

            //Make sure size of array is correct
            assertEquals(ARRAYSIZE, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure product's changed quantity is correct
            assertEquals(INITIALQUANTITY - i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX],
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. INCORRECT QUANTITY OF PRODUCT AT INDEX " +
                            expectedLocation);

            //Ensure inventory stock was increased accordingly
            assertEquals(INITIALSTOCK+i, s1.getInventory().getStock(PRODUCTID2),
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. INVENTORY NOT DECREASED CORRECTLY");
        }

        //For product 3
        expectedLocation = 3;
        for (int i = 1; i <= 3; i++) {
            s1.removeFromCart(cart1, PRODUCTID3);

            //Ensure product is in correct position in itemsInCart Array
            assertEquals(PRODUCTID3, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX],
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. PRODUCT ID ASSOCIATED WITH " +
                            "WRONG INDEX");

            //Make sure size of array is correct
            assertEquals(ARRAYSIZE, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure product's changed quantity is correct
            assertEquals(INITIALQUANTITY - i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX],
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. INCORRECT QUANTITY OF PRODUCT AT INDEX " +
                            expectedLocation);

            //Ensure inventory stock was increased accordingly
            assertEquals(INITIALSTOCK+i, s1.getInventory().getStock(PRODUCTID3),
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. INVENTORY NOT DECREASED CORRECTLY");
        }

        //For product 4
        expectedLocation = 4;
        for (int i = 1; i <= 3; i++) {
            s1.removeFromCart(cart1, PRODUCTID4);

            //Ensure product is in correct position in itemsInCart Array
            assertEquals(PRODUCTID4, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX],
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. PRODUCT ID ASSOCIATED WITH " +
                            "WRONG INDEX");

            //Make sure size of array is correct
            assertEquals(ARRAYSIZE, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure product's changed quantity is correct
            assertEquals(INITIALQUANTITY - i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX],
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. INCORRECT QUANTITY OF PRODUCT AT INDEX " +
                            expectedLocation);

            //Ensure inventory stock was increased accordingly
            assertEquals(INITIALSTOCK+i, s1.getInventory().getStock(PRODUCTID4),
                    "STOREMANAGER TEST - REMOVEFROMCART >> FAILED. INVENTORY NOT DECREASED CORRECTLY");
        }
    }


    /**
     * Unit test for StoreManager assignNewCartID method
     *
     * @return void
     */
    @Test
    @Order(4)
    public void testAssignNewCartID() {

        int cartID = 0; //should never have a cartID be 0

        for (int i = 2; i <= 10; i++) {
            cartID = s1.assignNewCartID();

            //Potential for cartID to be null as assignNewCartID returns an arrayList
            //value
            assertNotNull(cartID,
                    "STOREMANAGER TEST - ASSIGNNEWCARTID >> FAILED. CARTID IS NULL");

            //cartIDs are assigned sequentially
            assertEquals(i, cartID,
                    "STOREMANAGER TEST - ASSIGNNEWCARTID >> FAILED. INCORRECT CARTID");

            //Ensure size is being increased correctly
            assertEquals(i+1, s1.getCartID().size(),
                    "STOREMANAGER TEST - ASSIGNNEWCARTID >> FAILED. CARTID ARRAY IS INCORRECT SIZE");
        }
    }

    /**
     * This method tests the getter of the Inventory object. It compares each Product name in the Inventory
     * with the expected Product name.
     */
    @Test
    @Order(5)
    public void testGetInventory(){
        Inventory testInventory = s1.getInventory();

        for (int i = 1; i < testInventory.getProducts().size(); i++) {
            assertEquals(productNames.get(i - 1), s1.getInventory().getProduct(i).getName(), "The get " +
                    "Inventory method is not working.");
        }
    }

    /**
     * This method checks the stock of the current Products in Inventory. It checks the expected stock value
     * against the actual stock value.
     */
    @Test
    @Order(6)
    public void testGetStock(){
        final int CURRENTSTOCK = 5; // All Products should have a stock value of 5

        for (int i = 1; i < s1.getInventory().getProducts().size(); i++){
            assertEquals(CURRENTSTOCK, s1.getStock(i), "The get stock value is incorrect.");
        }
    }

    /**
     * This method checks the cartID list of the current StoreManager. It compares each expected value with the
     * actual value in the list.
     */
    @Test
    @Order(7)
    public void testGetCartID(){
        int counter = 0;
        ArrayList<Integer> expectedCartIDs = new ArrayList<>();
        expectedCartIDs.addAll(Arrays.asList(null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        for (Integer cartID : s1.getCartID()){
            assertEquals(expectedCartIDs.get(counter), cartID, "The get CartID value is correct for cartID " +
                    cartID + ".");
            counter++;
        }
    }

}
