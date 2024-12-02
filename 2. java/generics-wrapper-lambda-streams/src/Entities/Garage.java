package Entities;

import java.util.Comparator;
import java.util.List;

public class Garage {
    // ATTRIBUTES
    private int uid;
    private List<Vehicle> vehicleList;

    // METHODS
    public void printSortedByCost(){
        vehicleList.stream()
                .sorted((v1, v2) -> v1.getCost() - v2.getCost())
                .forEach(System.out::println);
    }

    public void printSortedByBrandAndCost(){
        vehicleList.stream()
                .sorted((v1, v2) -> v1.getBrand().compareTo(v2.getBrand()) != 0 // Compares comparison to 0, in case it's equal it shall give that
                ? v1.getBrand().compareTo(v2.getBrand()) //If comparison is different from 0, sort based on brand name
                : v1.getCost() - v2.getCost()) // If comparison is equal to 0, sort shall be based on cost
                .forEach(System.out::println);
    }

    public void extractVehiclesBasedOnPrice(boolean moreThan1000){
        if(!moreThan1000){
            vehicleList.stream()
                    .filter( x -> x.getCost() < 1000)
                    .forEach(System.out::println);
        } else {
            vehicleList.stream()
                    .filter( x -> x.getCost() >= 1000)
                    .forEach(System.out::println);
        }
    }

    public void getAverageCost(){
        double average = vehicleList.stream()
                .mapToDouble(Vehicle::getCost)
                .average()
                .orElse(0);

                System.out.printf("The average cost for all the cars is: %.2f%n", average);
    }

    // CONSTRUCTORS
    public Garage(){

    }

    public Garage(int uid, List<Vehicle> vehicleList){
        this.uid = uid;
        this.vehicleList = vehicleList;
    }

    // GETS & SETS
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
