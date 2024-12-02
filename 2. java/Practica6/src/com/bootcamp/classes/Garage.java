package com.bootcamp.classes;

import java.util.List;

public class Garage {
    private static int cont = 0;
    private Integer id;
    private List<Vehicle> vehicles;

    public Garage(List<Vehicle> vehicles){
        this.id = ++cont;
        this.vehicles = vehicles;
    }

    public Integer getId() {
        return id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void averageCost(){
        double average =
                getVehicles().stream()
                        .mapToDouble(Vehicle::getCost)
                        .average()
                        .orElse(0);
        System.out.println("El promedio de precios es: " + String.format("$%.2f%n", average));
    }

    public void printVehiclesByCost(){
        getVehicles().stream()
                .sorted((v1, v2) -> v1.getCost().compareTo(v2.getCost()))
                .forEach(System.out::println);
    }

    public void printVehiclesByBrandAndCost(){
        getVehicles().stream()
                .sorted((v1, v2) -> v1.getBrand().compareTo(v2.getBrand()) != 0
                        ? v1.getBrand().compareTo(v2.getBrand())
                        : v1.getCost().compareTo(v2.getCost()))
                .forEach(System.out::println);
    }

    public void printVehiclesMinorTo1000(boolean isMinorTo1000){
        List<Vehicle> listOfVehicles;
        if(isMinorTo1000){
            listOfVehicles = getVehicles().stream()
                    .filter(vehiculo -> vehiculo.getCost() < 1000)
                    .toList();
        }else{
            listOfVehicles = getVehicles().stream()
                    .filter(vehiculo -> vehiculo.getCost() >= 1000)
                    .toList();
        }

        listOfVehicles.forEach(System.out::println);
    }


}
