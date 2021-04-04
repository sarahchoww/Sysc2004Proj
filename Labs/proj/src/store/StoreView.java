/**
 * SYSC 2004 Winter 2021
 *
 * @author Michael Whitford, 101151720
 * @author Sarah Chow, 101143033
 * @version 3.0
 * <p>
 * SYSC 2004 Project - Milestone 4 Store View class
 * <p>
 * Copyright © 2021 Michael Whitford & Sarah Chow.
 * All rights reserved.
 */

package store;

import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * Store View Class. Contains UI
 */
public class StoreView {

    private static StoreManager storeManager;
    private int cartID;
    private Integer[] maxStock;

    private final JFrame frame;
    private JLabel[] productLabels;
    private JButton[][] upDown;


    /**
     * Constructor for Storeview.
     *
     * @param storeManager StoreManager, Store View's store manager
     * @param cartID       int, cartID for the Store View
     */
    public StoreView(StoreManager storeManager, int cartID) {
        this.storeManager = storeManager;
        this.cartID = cartID;
        this.frame = new JFrame();
        this.maxStock = new Integer[]{null, 10, 10, 10, 10};
    }

    /**
     * Method that sets the + button for the products.
     * @param productID represents the productID of the product to be incremented, int
     * @param cart represents the cart object, ShoppingCart
     * @return the button object, JButton
     */
    private JButton getUp(int productID, ShoppingCart cart) {
        JButton button = new JButton("+");

        button.setPreferredSize(new Dimension(100, 30));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                storeFunctions("ADDTOCART", productID, cart);
                updateProductLabel(productID);
                enableButtons(productID);
            }
        });
        return button;
    }

    /**
     * Method that sets the - button for the products
     * @param productID represents the productID of the product to be decremented, int
     * @param cart represents the cart object, ShoppingCart
     * @return the button object, JButton
     */
    private JButton getDown(int productID, ShoppingCart cart) {
        JButton button = new JButton("-");
        button.setEnabled(false);

        button.setPreferredSize(new Dimension(100, 30));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                storeFunctions("REMOVEFROMCART", productID, cart);
                updateProductLabel(productID);
                enableButtons(productID);

            }
        });
        return button;
    }

    /**
     * Method that enables and disables the + and - buttons based on the stock value.
     * @param productID represents the productID of the product, int
     */
    private void enableButtons(int productID){
        final int UP = 0;
        final int DOWN = 1;

        int currentStock = storeManager.getStock(productID);

        if (currentStock > 0){
            upDown[productID][UP].setEnabled(true);
            upDown[productID][DOWN].setEnabled(true);

            if (currentStock == maxStock[productID]){
                upDown[productID][DOWN].setEnabled(false);
            }
        }
        else{
            upDown[productID][DOWN].setEnabled(true);
            upDown[productID][UP].setEnabled(false);
        }
    }

    /**
     * Method to set the view cart button.
     * @param cart the cart object, Shopping Cart
     * @return the button object, JButton
     */
    private JButton viewCartButton(ShoppingCart cart) {
        JButton button = new JButton("View Cart");

        button.setPreferredSize(new Dimension(150, 30));

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                ImageIcon icon = new ImageIcon(getClass().getResource("shoppingcart.png"));
                StringBuilder output = printCart(cart, "VIEWCART");
                JOptionPane.showMessageDialog(frame, output.toString(), "Your Cart",
                        JOptionPane.INFORMATION_MESSAGE, icon);

            }
        });
        return button;
    }

    /**
     * Method to set the checkout button. Checks if buttons should be enabled or disabled and resets the cart.
     * @param cart the cart object, ShoppingCart
     * @return a button object, JButton
     */
    private JButton checkoutButton(ShoppingCart cart) {
        JButton button = new JButton("Checkout");
        ArrayList<Integer[]> newItemsInCart = new ArrayList<>();
        newItemsInCart.add(null);

        button.setPreferredSize(new Dimension(150, 30));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ImageIcon icon = new ImageIcon(getClass().getResource("receipt.png"));
                StringBuilder output = printCart(cart, "CHECKOUT");
                JOptionPane.showMessageDialog(frame, output.toString(), "Your Receipt",
                        JOptionPane.INFORMATION_MESSAGE, icon);

                // Reset / disable the remove button if there is no stock to remove from cart
                enableButtons(1);
                enableButtons(2);
                enableButtons(3);
                enableButtons(4);

                cart.setItemsInCart(newItemsInCart); // Once the user checkouts, their cart is reset
            }
        });
        return button;
    }

    /**
     * Method to set the quit button. A message pop-up appears for a yes or no answer and the program closes if yes.
     * @param cart the cart object, ShoppingCart
     * @return a button object, JButton
     */
    private JButton quitButton(ShoppingCart cart) {
        JButton button = new JButton("Quit");

        button.setPreferredSize(new Dimension(150, 30));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (JOptionPane.showConfirmDialog(null, "Close application?", "QUIT",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        return button;
    }

    /**
     * Method to update the Stock(x) value in the GUI.
     * @param productID represents the productID of the product, int
     */
    private void updateProductLabel(int productID) {
        switch (productID) {
            case (1):
                productLabels[productID].setText(String.format("<html>Guitar<br/>$999.99 - Stock (%d)</html>",
                        storeManager.getStock(1)));

                break;
            case (2):
                productLabels[productID].setText(String.format("<html>Piano<br/>$1999.99 - Stock (%d)</html>",
                        storeManager.getStock(2)));
                break;
            case (3):
                productLabels[productID].setText(String.format("<html>Flute<br/>$599.99 - Stock (%d)</html>",
                        storeManager.getStock(3)));
                break;
            case (4):
                productLabels[productID].setText(String.format("<html>Saxophone<br/>$799.99 - Stock (%d)</html>",
                        storeManager.getStock(4)));
                break;
            default:
                break;
        }
    }

    /**
     * Mehtod to build the GUI.
     * @param cart the cart object, ShoppingCart
     */
    private void displayGUI(ShoppingCart cart) {
        final int NUMOFPRODUCTS = 5; // 4 product, nothing in index 0

        frame.setTitle("M&S Music Store");

        JLabel headerLabel = new JLabel(String.format("M&S Music Store! (Cart ID: %d)", this.cartID));
        headerLabel.setFont(new Font("Serif", Font.PLAIN, 40));

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel headerPanel = new JPanel();
        JPanel bodyPanel = new JPanel(new GridLayout());
        JPanel footerPanel = new JPanel();

        this.upDown = new JButton[NUMOFPRODUCTS][2]; // 0: Up, 1: Down
        JPanel[] productPanels = new JPanel[NUMOFPRODUCTS];

        final int UP = 0;
        final int DOWN = 1;

        // set the preferred sizes and colours here
        headerPanel.setPreferredSize(new Dimension(1000, 100));
        headerPanel.setBackground(Color.white);


        bodyPanel.setPreferredSize(new Dimension(1000, 100));


        footerPanel.setPreferredSize(new Dimension(1000, 100));
        footerPanel.setBackground(Color.white);

        this.productLabels = new JLabel[]{ null,
                new JLabel(String.format("<html>Guitar<br/>$999.99 - Stock (%d)</html>",
                        storeManager.getStock(1)), SwingConstants.CENTER),
                new JLabel(String.format("<html>Piano<br/>$1999.99 - Stock (%d)</html>",
                        storeManager.getStock(2)), SwingConstants.CENTER),
                new JLabel(String.format("<html>Flute<br/>$599.99 - Stock (%d)</html>",
                        storeManager.getStock(3)), SwingConstants.CENTER),
                new JLabel(String.format("<html>Saxophone<br/>$799.99 - Stock (%d)</html>",
                        storeManager.getStock(4)), SwingConstants.CENTER)
        };


        for (int i = 1; i < NUMOFPRODUCTS; i++) {


            upDown[i][UP] = getUp(i, cart);
            upDown[i][DOWN] = getDown(i, cart);

            productLabels[i].setForeground(Color.white);
            productLabels[i].setFont(new Font("Serif", Font.PLAIN, 25));

            productPanels[i] = new JPanel(new BorderLayout());

            productPanels[i].setPreferredSize(new Dimension(250, 50));
            productPanels[i].setBackground(Color.DARK_GRAY);

            productPanels[i].add(productLabels[i], BorderLayout.NORTH);


            JPanel testPanel = new JPanel(new FlowLayout());

            testPanel.add(upDown[i][UP], FlowLayout.LEFT);
            testPanel.add(upDown[i][DOWN], FlowLayout.CENTER);

            productPanels[i].add(testPanel, BorderLayout.SOUTH);


            bodyPanel.add(productPanels[i]);
        }


        ImageIcon guitar = new ImageIcon(getClass().getResource("guitar.png"));
        productPanels[1].add(new JLabel(guitar), BorderLayout.CENTER);

        ImageIcon piano = new ImageIcon(getClass().getResource("piano.png"));
        productPanels[2].add(new JLabel(piano), BorderLayout.CENTER);

        ImageIcon flute = new ImageIcon(getClass().getResource("flute.png"));
        productPanels[3].add(new JLabel(flute), BorderLayout.CENTER);

        ImageIcon saxophone = new ImageIcon(getClass().getResource("saxophone.png"));
        productPanels[4].add(new JLabel(saxophone), BorderLayout.CENTER);

        headerPanel.add(headerLabel);

        footerPanel.add(viewCartButton(cart), BorderLayout.LINE_START);
        footerPanel.add(checkoutButton(cart), BorderLayout.CENTER);
        footerPanel.add(quitButton(cart), BorderLayout.LINE_END);


        // add your JLabels to the panel here
        mainPanel.add(headerPanel, BorderLayout.PAGE_START);
        mainPanel.add(bodyPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.PAGE_END);

        // pack
        frame.add(mainPanel);
        frame.pack();


        // add the window listener
        // we no longer want the frame to close immediately when we press "x"
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?")
                        == JOptionPane.OK_OPTION) {
                    // close it down!
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });

        // the frame is not visible until we set it to be so
        frame.setVisible(true);

    }

    /**
     * This method returns a StringBuilder object with the cart / checkout details.
     * @param cart the cart object, ShoppingCart
     * @param command a String that is either "VIEWCART" or "CHECKOUT"
     * @return
     */
    private StringBuilder printCart(ShoppingCart cart, String command) {

        StringBuilder output1 = new StringBuilder();
        StringBuilder output2 = new StringBuilder();
        output1.append("<html><table border='0'>");
        output2.append("<html><table border='0'>");

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        ArrayList<Integer[]> items = cart.getItemsInCart();

        boolean emptyCart = false;
        int counter = 1;

        while ( !emptyCart && counter < cart.getItemsInCart().size()){
            if (items.get(counter)[1] > 0) {
                emptyCart = true;
            }
            counter++;
        }

        if (command.equals("VIEWCART") && !emptyCart) { // Empty cart
            return (new StringBuilder("No items in cart!"));
        }

        if (command.equals("CHECKOUT") && !emptyCart) { // Empty cart
            return (new StringBuilder("No items in cart!"));
        }

        if (command.equals("CHECKOUT")){
            output1.append("|---------------------RECEIPT---------------------|");
        }
        else{
            output1.append("|---------------SHOPPING CART---------------|");
        }



        output2.append("<tr><td align='center'>Quantity ");
        output2.append("</td><td align='center'>| Product Name |");
        output2.append("</td><td align='center'> Unit Price");



        for (int i = 1; i < cart.getItemsInCart().size(); i++) {
            if (items.get(i)[1] > 0) {

                output2.append("<tr><td align='center'>");
                output2.append(String.valueOf(items.get(i)[1]));
                output2.append("</td><td align='center'>");
                output2.append(storeManager.getInventory().getProduct(items.get(i)[0]).getName());
                output2.append("</td><td align='center'>");
                output2.append(nf.format(storeManager.getInventory().getProduct(items.get(i)[0]).getPrice()));
                output2.append("</td></tr>");

            }
        }

        output2.append("</td></tr><br/>");
        output1.append(output2);

        if (command.equals("CHECKOUT")) {
            output1.append("<br><br>");
            output1.append("<tr><td align='right'>");
            output1.append("TOTAL:");
            output1.append("</td><td align='left'>");
            output1.append(nf.format((this.checkout(cart))));
            output1.append("</td></tr>");
        }

        return output1;
    }

    /**
     * This method adds an item to the user's shopping cart
     *
     * @param cart      ShoppingCart, represents the user's shopping cart
     * @param productID int, represents the productID of the product to be added
     */
    private void addToCart(ShoppingCart cart, int productID) {
        storeManager.addToCart(cart, productID);

    }

    /**
     * This method removes an item from the user's shopping cart.
     *
     * @param cart      ShoppingCart, represents the user's shopping cart
     * @param productID int, represents the productID of the product to be added
     */
    private void removeFromCart(ShoppingCart cart, int productID) {
        storeManager.removeFromCart(cart, productID);
    }

    /**
     * This methods calls on the StoreManager's checkout method.
     * It sets the new maxStock value in the store.
     *
     * @param cart represents the user's cart, ShoppingCart
     * @return the total value, double
     */
    private double checkout(ShoppingCart cart) {

        double total = storeManager.checkout(cart);

        for (int i = 1; i < 5; i++){
            this.maxStock[i] = storeManager.getInventory().getStock().get(i);
        }

        return total;
    }

    /**
     * Helper method to call specific methods for each possible command
     *
     * @param choiceString String, command user has input that they want to run
     * @param cart         ShoppingCart, user's shopping cart
     * @return void
     */

    private void storeFunctions(String choiceString, int productID, ShoppingCart cart) {

        switch (choiceString) {
            case ("ADDTOCART"):

                if (storeManager.getInventory().getStock().get(productID) > 0) {
                    addToCart(cart, productID);
                }
                break;

            case ("REMOVEFROMCART"):

                for(int i = 1; i < cart.getItemsInCart().size(); i++){
                    if (((cart.getItemsInCart().get(i)[0]) == productID) && (cart.getItemsInCart().get(i)[1]) > 0){
                        removeFromCart(cart, productID);
                        break;
                    }
                }
                break;
        default:
            break;
    }

}

    /**
     * Setter method for storeManager attribute
     *
     * @param sm StoreManager, storeManager attribute getting set
     *           !!!Will affect all instances as StoreManager is static
     * @return void
     */
    public void setStoreManager(StoreManager sm) {
        this.storeManager = sm;
    }

    /**
     * Main method
     *
     * @param args String[], Command line arguments
     */

    public static void main(String[] args) {
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

        sv1.displayGUI(shoppingCart.get(sv1.cartID));

    }
}