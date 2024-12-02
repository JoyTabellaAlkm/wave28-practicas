package Entities;

public class Product {

    // ATTRIBUTES
    private String name;
    private double price;

    // METHODS

    public double calculate(int productQuantity){
        return price * productQuantity;
    }

    // CONSTRUCTORS

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    // TO STRING

    @Override
    public String toString() {
        return "[Product] " +
                "Name: " + name + '\'' +
                ", Price: " + price;
    }

    // GETS & SETS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
