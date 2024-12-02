package Entities;

public class PerishableProduct extends Product
{
    // ATTRIBUTES
    private int daysToExpiration;

    // METHODS
    @Override
    public double calculate(int productQuantity){
        double toReturn = productQuantity * this.getPrice();
        switch(daysToExpiration){
            case 1:
                return toReturn / 4;
            case 2:
                return toReturn / 3;
            case 3:
                return toReturn / 2;
            default:
                return toReturn;
        }
    }

    // CONSTRUCTOR

    public PerishableProduct(String name, double price, int daysToExpiration) {
        super(name, price);
        this.daysToExpiration = daysToExpiration;
    }

    // GETS & SETS

    public int getDaysToExpiration() {
        return daysToExpiration;
    }

    public void setDaysToExpiration(int daysToExpiration) {
        this.daysToExpiration = daysToExpiration;
    }

    // TO STRING

    @Override
    public String toString() {
        return "[PerishableProduct]" +
                "daysToExpiration: " + daysToExpiration +
                " \n " + super.toString();
    }
}
