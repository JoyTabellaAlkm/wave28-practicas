import Entities.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new Vehicle("Ford", "Fiesta", 1000));
        vehicleList.add(new Vehicle("Ford", "Focus", 1200));
        vehicleList.add(new Vehicle("Ford", "Explorer", 2500));
        vehicleList.add(new Vehicle("Fiat", "Uno", 500));
        vehicleList.add(new Vehicle("Fiat", "Cronos", 1000));
        vehicleList.add(new Vehicle("Fiat", "Torino", 1250));
        vehicleList.add(new Vehicle("Chevrolet", "Aveo", 1250));
        vehicleList.add(new Vehicle("Chevrolet", "Spin", 2500));
        vehicleList.add(new Vehicle("Toyota", "Corolla", 1200));
        vehicleList.add(new Vehicle("Toyota", "Fortuner", 3000));
        vehicleList.add(new Vehicle("Renault", "Logan", 950));

        Garage garage = new Garage(1, vehicleList);

        garage.printSortedByCost();
        System.out.println("=================");
        garage.printSortedByBrandAndCost();
        System.out.println("=================");
        garage.extractVehiclesBasedOnPrice(true);
        System.out.println("=================");
        garage.extractVehiclesBasedOnPrice(false);
        System.out.println("=================");
        garage.getAverageCost();
    }
}
