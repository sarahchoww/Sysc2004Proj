/**
 *             SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 1.0
 *
 * SYSC 2004 Project - Milestone 2 Store View class
 *
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Store View Class. Contains UI
 */
public class StoreView {

    /**
     * Main method
     *
     * @param args      String[], Command line arguments
     */
    public static void main(String[] args){

        Product p1 = new Product("cheese", 1, 2.99);
        Product p2 = new Product("ham", 2, 5.99);
        StoreManager s1 = new StoreManager();


        s1.getInventory().setStock(3, p1.getName(), p1.getProductID(), p1.getPrice());
        s1.getInventory().setStock(5, p1.getName(), p1.getProductID(), p1.getPrice());
        s1.getInventory().setStock(3, p2.getName(),p2.getProductID(), p2.getPrice());

        System.out.println(s1.getStock(p1.getProductID()));
        System.out.println(s1.getStock(p2.getProductID()));

        ArrayList<Integer[]> transac = new ArrayList<>();

        Integer[] a1 = {1, 1};
        Integer[] a2 = {2, 4};

        transac.add(a1);
        transac.add(a2);

        System.out.println(s1.transaction(transac));

        System.out.println(s1.getStock(p1.getProductID()));
        System.out.println(s1.getStock(p2.getProductID()));


    }
}
