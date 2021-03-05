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

import java.lang.*;
import java.util.*;

/**
 * Store View Class. Contains UI
 */
public class StoreView {

    private static StoreManager storeManager;
    private int cartID;

    /**
     * Parametric constructor for a StoreView
     *
     * @param storeManager  StoreManager, Store View's store manager
     * @param cartID        int, cartID for the Store View
     */
    public StoreView(StoreManager storeManager, int cartID) {
        this.storeManager = storeManager;
        this.cartID = cartID;
    }

    /**
     * Prints available StoreViews and deactivated StoreViews to the screen
     *
     * @param users    ArrayList<StoreView>, arraylist of all users
     */
    private static void printUsers(ArrayList<StoreView> users) {

        System.out.print("AVAILABLE STOREVIEWS: ");
        for (int i = 1; i < users.size(); i++) {
            if(users.get(i) != null) {
                System.out.print("(" + i + ") ");
            }
        }

        boolean anyDeactivated = false;

        System.out.print("DEACTIVATED STOREVIEWS: ");

        for (int i = 1; i < users.size(); i++) {

            if(users.get(i) == null) {
                System.out.print("(" + i + ") ");
                anyDeactivated = true;
            }
        }

        if (!anyDeactivated) {
            System.out.print("None");
        }

        System.out.println();
    }

    /**
     * Prints description of valid commands user can enter
     */
    private static void explainCommands() {
        System.out.println();
        System.out.println("AddToCart: Allows you to add items to your cart");
        System.out.println("Browse: Shows a list of products");
        System.out.println("Checkout: Completes purchase and prints receipt");
        System.out.println("RemoveFromCart: Allows you to remove items to your cart");
        System.out.println("ViewCart: Allows you to view the items in your cart");
        System.out.println("Q: Completely exits program");
        System.out.println();
    }

    /**
     * Returns whether or not there are any active users
     *
     * @param users     ArrayList<StoreView>, arraylist of all users
     * @return boolean  true if there are active users, false otherwise
     */
    private static boolean activeUsers(ArrayList<StoreView> users) {

        for(int i = 0; i < users.size(); i++) {
            if (users.get(i) != null) {
                return true;
            }
        }

        return false;
    }

    /**
     * Prints store menu
     *
     * @param command   String, displays command user has just entered
     */
    private void printMenu(String command) {

        boolean addToCart = false;

        System.out.println();
        System.out.println(command.toUpperCase());
        System.out.println("|---------THE MUSIC STORE---------|");
        System.out.print("Stock | Product Name | Unit Price");

        if (command.equals("ADDTOCART")){
            addToCart = true;

            System.out.print(" | Options");

        }
        System.out.println();

        ArrayList<Product> products = this.storeManager.getInventory().getProducts();

        for (int i = 1; i < products.size(); i++) {
            if(this.storeManager.getStock(products.get(i).getProductID()) > 0) {
                System.out.printf("%5s %14s %12s ", this.storeManager.getStock(products.get(i).getProductID()),
                        products.get(i).getName(), products.get(i).getPrice());


                if (addToCart){

                    System.out.printf("%8x)%n", storeManager.getInventory().getProducts().get(i).getProductID());
                }
                else{
                    System.out.printf("%n");
                }

            }
        }

        System.out.println();
    }

    private boolean viewCart(ShoppingCart cart, String command){
        if (cart.getItemsInCart().size() == 1){ // Empty cart
            System.out.println("No items in cart!");
            return false;
        }

        boolean removeFromCart = false;
        ArrayList<Integer[]> items = cart.getItemsInCart();

        System.out.println("|---------SHOPPING CART---------|");
        System.out.print("Quantity | Product Name | Unit Price");



        if (command.equals("REMOVEFROMCART")){
            removeFromCart = true;
            System.out.print(" | Options");

        }
        System.out.println();

        for (int i = 1; i < cart.getItemsInCart().size(); i++){

            if (items.get(i)[1] > 0) {
                System.out.printf("%8s %14s %12s ", items.get(i)[1],
                        storeManager.getInventory().getProduct(items.get(i)[0]).getName(),
                        storeManager.getInventory().getProduct(items.get(i)[0]).getPrice());

                //System.out.println("TEST: " + cart.getItemsInCart().get(i)[0])

                if (removeFromCart){

                    System.out.printf("%8x)%n", cart.getItemsInCart().get(i)[0]);
                }
                else{
                    System.out.printf("%n");
                }
            }

        }

        System.out.println();

        return true;
    }

    private void addToCart(ShoppingCart cart, int productID){
        storeManager.addToCart(cart, productID);
        this.viewCart(cart, "ADDTOCART");

    }

    private void removeFromCart(ShoppingCart cart, int productID){
        storeManager.removeFromCart(cart, productID);
        this.viewCart(cart, "REMOVEFROMCART");
    }

    private void checkout(ShoppingCart cart){
        storeManager.checkout(cart);
    }

    private void storeFunctions(String choiceString, ShoppingCart cart){

        switch(choiceString){
            case ("ADDTOCART"):

                boolean validOption1 = false;

                while(!validOption1){
                    System.out.print("Option: ");
                    Scanner sc1 = new Scanner(System.in);
                    int option1 = sc1.nextInt();

                    if ((option1 < this.storeManager.getInventory().getProducts().size()) && (option1 > 0)) {
                        addToCart(cart, option1);
                        validOption1 = true;
                    }
                    else{
                        System.out.println("MAIN > ERROR > INVALID OPTION");
                    }
                }

                break;

            case("REMOVEFROMCART"):

                if (this.viewCart(cart, choiceString)){
                    boolean inCart = false;

                    while(!inCart){

                        System.out.print("Option: ");
                        Scanner sc2 = new Scanner(System.in);
                        int option2 = sc2.nextInt();

                        for(int i = 1; i < cart.getItemsInCart().size(); i++){
                            if ((cart.getItemsInCart().get(i)[0]) == option2){
                                removeFromCart(cart, option2);
                                inCart = true;
                                break;
                            }
                        }

                        if (!inCart){
                            System.out.println("MAIN > ERROR > INVALID OPTION");
                        }
                    }
                }

                break;

            case("CHECKOUT"):
                this.viewCart(cart, choiceString);
                this.checkout(cart);
                break;
            default:
                break;
        }

    }

    public void setStoreManager(StoreManager sm){
        this.storeManager = sm;
    }

    /**
     * Main method
     *
     * @param args      String[], Command line arguments
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StoreManager sm = new StoreManager();



        //Initialize products
        sm.getInventory().getProducts().add(new Product("Guitar", 1, 999.99));
        sm.getInventory().getStock().add(10);
        sm.getInventory().getProducts().add(new Product("Piano", 2, 1999.99));
        sm.getInventory().getStock().add(10);
        sm.getInventory().getProducts().add(new Product("Flute", 3, 599.99));
        sm.getInventory().getStock().add(10);
        sm.getInventory().getProducts().add(new Product("Saxophone", 4, 799.99));
        sm.getInventory().getStock().add(10);


        //First user
        StoreView sv1 = new StoreView(sm, sm.assignNewCartID());

        sv1.setStoreManager(sm);

        ArrayList<StoreView> users = new ArrayList<>(); // ArrayList of storeviews
        users.add(null); //first element is null so there's no offset
        users.add(sv1);

        ArrayList<ShoppingCart> shoppingCart = new ArrayList<>();
        shoppingCart.add(null); //first element is null so there's no offset
        shoppingCart.add(new ShoppingCart(sv1.cartID));


        ArrayList<String> validCommands = new ArrayList<>(Arrays.asList("HELP", "ADDTOCART", "BROWSE",
                "CHECKOUT", "REMOVEFROMCART", "VIEWCART", "Q"));

        String choiceString = ""; //used to get user input



        while (StoreView.activeUsers(users) && !choiceString.equals("Q")) {
            boolean valid = false; // For user error checking
            StoreView.printUsers(users);

            System.out.print("CHOOSE YOUR STOREVIEW >>> ");
            int choice = sc.nextInt();

            boolean choiceValid = false;

            //If storeview input is valid but not a current storeview, add
            //new storeview (ID won't match user input however)
            if (!sm.getCartID().contains(choice) && choice > 0) {
                System.out.println();
                System.out.println("THAT STOREVIEW DOES NOT CURRENTLY EXIST");

                while (!valid){
                    System.out.print("ADD A NEW STOREVIEW? (y/n) >>> ");
                    choiceString = sc.next().toUpperCase();

                    if (choiceString.equals("Y") || choiceString.equals("N")){
                        valid = true;
                    }
                }


                if(choiceString.equals("Y")) {
                    StoreView newUser = new StoreView(sm, sm.assignNewCartID());
                    users.add(newUser);
                    shoppingCart.add(new ShoppingCart(newUser.cartID));

                    choiceValid = true;
                }
            }
            //Cannot access a deactivated storeview, but input is still allowed
            else if (choice < users.size() && choice > 0
                    && users.get(choice) == null){
                System.out.println("MAIN > ERROR > THAT STOREVIEW WAS DEACTIVATED");
            }
            else if (sm.getCartID().contains(choice)){
                choiceValid = true;
            }
            else {
                System.out.println(
                        String.format("MAIN > ERROR > PLEASE CHOOSE A STOREVIEW IN RANGE [%d, %d]",
                                1, users.size()-1));
            }

            System.out.println();

            valid = false;
            choiceString = "";
            if (choiceValid) {
                System.out.println("CART >>> " + users.get(choice).cartID);
                while (!choiceString.equals("Y") && !choiceString.equals("Q") && StoreView.activeUsers(users) &&
                !choiceString.equals("CHECKOUT")) {

                    boolean validCommand = false;

                    while (!validCommand) {
                        System.out.println("ENTER A COMMAND");
                        System.out.print("Type 'Help' for a list of commands >>> ");
                        choiceString = sc.next().toUpperCase();

                        if (choiceString.equals("HELP")) {
                            StoreView.explainCommands();
                        }
                        else if(!validCommands.contains(choiceString)) {
                            System.out.println("MAIN > ERROR > INVALID COMMAND");
                            System.out.println();
                        }
                        else {
                            validCommand = true;
                        }
                    }

                    if (!choiceString.equals("Q") && !choiceString.equals("VIEWCART")) {

                        if (!choiceString.equals("REMOVEFROMCART") && !choiceString.equals("CHECKOUT")){
                            users.get(choice).printMenu(choiceString);
                        }

                        users.get(choice).storeFunctions(choiceString, shoppingCart.get(choice));

                        if (choiceString.equals("CHECKOUT")){
                            users.set(choice, null);
                            valid = true;
                        }

                        while (!valid){
                            System.out.print("GO TO ANOTHER STOREVIEW? (y/n/q) >>> ");
                            choiceString = sc.next().toUpperCase();

                            if (choiceString.equals("Y") || choiceString.equals("N") || choiceString.equals("Q")) {
                                valid = true;
                            }
                        }

                        if (StoreView.activeUsers(users)){
                            valid = false;
                        }


                    }
                    else if (choiceString.equals("VIEWCART")) {
                        users.get(choice).viewCart(shoppingCart.get(choice), choiceString);
                    }

                }


                valid = false;
                if(!choiceString.equals("Q") && StoreView.activeUsers(users) && !choiceString.equals("CHECKOUT")) {

                    while (!valid){
                        System.out.print("DEACTIVATE PREVIOUS USER? (y/n) >>> "); // TODO: choose a nonsequential storeview to add, CRASHES, if user is deactivated, replace the items in cart
                        choiceString = sc.next().toUpperCase();

                        if (choiceString.equals("Y") || choiceString.equals("N")){
                            valid = true;
                        }
                    }


                    if (choiceString.equals("Y")) {
                        users.set(choice, null);
                    }

                    System.out.println();
                }

            }
        }
        System.out.println("ALL STOREVIEWS DEACTIVATED");

        //TODO: Will need to empty all carts? Maybe not necessary cleanup unless
        //we eventually are writing and reading from a text file
    }
}
