package Entities;

public class NonPerishableProduct extends Product{

    // ATTRIBUTES
    private String type;

    // CONSTRUCTORS
    public NonPerishableProduct(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    // TO STRING
    @Override
    public String toString() {
        return "[NonPerishableProduct]" +
                "Type: " + type + "\n" + super.toString();
    }

    // GETS & SETS
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
