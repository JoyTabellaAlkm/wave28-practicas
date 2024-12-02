package Entities;

public class Vehicle {
    // ATTRIBUTES
    private String model;
    private String brand;
    private int cost;

    // CONSTRUCTORS
    public Vehicle(String brand, String model, int cost) {
        this.model = model;
        this.brand = brand;
        this.cost = cost;
    }

    public Vehicle(){

    }

    // GETS & SETS
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", cost=" + cost +
                '}';
    }
}
