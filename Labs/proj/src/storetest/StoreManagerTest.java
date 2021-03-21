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
        cart1 = new ShoppingCart(1);
    }

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


    @Test
    @Order
    public void testAddToCart() {

        //Models the 4 products that are available in our store
        final int PRODUCTID1 = 1;
        final int PRODUCTID2 = 2;
        final int PRODUCTID3 = 3;
        final int PRODUCTID4 = 4;
        final int INITIALQUANTITY = 5;

        //Used to retrieve items from itemsInCart Array
        final int ID_INDEX = 0;
        final int QUANTITY_INDEX = 1;

        //For product 1
        int expectedSize = 2;
        int expectedLocation = 1;
        for (int i = 1; i <= 3; i++) {
            s1.addToCart(cart1, PRODUCTID1);

            //Ensure product was added into correct position in itemsInCart Array
            assertEquals(PRODUCTID1, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX]);

            //Make sure size of array is correct
            assertEquals(expectedSize, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure new product's quantity is correct
            assertEquals(i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX]);

            //Ensure inventory stock was decreased accordingly
            assertEquals(INITIALQUANTITY-i, s1.getInventory().getStock(PRODUCTID1));
        }

        //For product 2
        expectedSize = 3;
        expectedLocation = 2;
        for (int i = 1; i <= 3; i++) {
            s1.addToCart(cart1, PRODUCTID2);

            //Ensure product was added into correct position in itemsInCart Array
            assertEquals(PRODUCTID2, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX]);

            //Make sure size of array is correct
            assertEquals(expectedSize, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure new product's quantity is correct
            assertEquals(i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX]);

            //Ensure inventory stock was decreased accordingly
            assertEquals(INITIALQUANTITY-i, s1.getInventory().getStock(PRODUCTID2));
        }

        //For product 3
        expectedSize = 4;
        expectedLocation = 3;
        for (int i = 1; i <= 3; i++) {
            s1.addToCart(cart1, PRODUCTID3);

            //Ensure product was added into correct position in itemsInCart Array
            assertEquals(PRODUCTID3, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX]);

            //Make sure size of array is correct
            assertEquals(expectedSize, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure new product's quantity is correct
            assertEquals(i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX]);

            //Ensure inventory stock was decreased accordingly
            assertEquals(INITIALQUANTITY-i, s1.getInventory().getStock(PRODUCTID3));
        }

        //For product 4
        expectedSize = 5;
        expectedLocation = 4;
        for (int i = 1; i <= 3; i++) {
            s1.addToCart(cart1, PRODUCTID4);

            //Ensure product was added into correct position in itemsInCart Array
            assertEquals(PRODUCTID4, cart1.getItemsInCart().get(expectedLocation)[ID_INDEX]);

            //Make sure size of array is correct
            assertEquals(expectedSize, cart1.getItemsInCart().size(),
                    "STOREMANAGER TEST - ADDTOCART >> FAILED. ITEMSINCART ARRAY SIZE IS INCORRECT");

            //Ensure new product's quantity is correct
            assertEquals(i, cart1.getItemsInCart().get(expectedLocation)[QUANTITY_INDEX]);

            //Ensure inventory stock was decreased accordingly
            assertEquals(INITIALQUANTITY-i, s1.getInventory().getStock(PRODUCTID4));
        }
    }

    @Test
    public void testRemoveFromCart() {
    }

    @Test
    @Order(2)
    public void testAssignNewCartID() {

        int cartID = 0; //should never have a cartID be 0

        for (int i = 2; i <= 10; i++) {
            cartID = s1.assignNewCartID();

            //Potential for cartID to be null as assignNewCartID returns an arrayList
            //value
            assertNotNull(cartID,
                    "STOREMANAGER TEST - ASSIGNNEWCARTID >> FAILED. CARTID IS NULL");

            //cartIDs are assigned sequentially, should match counter i of for loop
            assertEquals(i, cartID,
                    "STOREMANAGER TEST - ASSIGNNEWCARTID >> FAILED. INCORRECT CARTID");

            //Ensure size is being increased correctly
            assertEquals(i+1, s1.getCartID().size(),
                    "STOREMANAGER TEST - ASSIGNNEWCARTID >> FAILED. INCORRECT CARTID");
        }
    }

}
