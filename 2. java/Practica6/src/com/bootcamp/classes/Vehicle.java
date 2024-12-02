package com.bootcamp.classes;

public class Vehicle {
    private String brand;
    private String model;
    private Integer cost;

    public Vehicle(String brand, String model, Integer cost){
        this.model = model;
        this.brand = brand;
        this.cost = cost;
    }

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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + brand + '\'' +
                ", modelo='" + model + '\'' +
                ", costo=" + cost +
                '}';
    }
}
