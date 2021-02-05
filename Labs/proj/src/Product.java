public class Product {
    //Beginning of Product Class

    private final String name;
    private final int productID;
    private final double price;

    public Product(String name, int productID, double price){
        this.name = name;
        this.productID = productID;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getProductID(){
        return productID;
    }

    public double getPrice() {
        return price;
    }
}
