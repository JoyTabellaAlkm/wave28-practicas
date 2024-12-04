import garage.Garage;
import garage.Vehicle;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Garage garage = new Garage(1);

        List<Vehicle> vehiclesList = List.of(
                new Vehicle("Ford", "Fiesta", 1000),
                new Vehicle("Ford", "Focus", 1200),
                new Vehicle("Ford", "Explorer", 2500),
                new Vehicle("Fiat", "Uno", 500),
                new Vehicle("Fiat", "Cronos", 1000),
                new Vehicle("Fiat", "Torino", 1250),
                new Vehicle("Chevrolet", "Aveo", 1250),
                new Vehicle("Chevrolet", "Spin", 2500),
                new Vehicle("Toyota", "Corola", 1200),
                new Vehicle("Toyota", "Fortuner", 3000),
                new Vehicle("Renault", "Logan", 950)
        );

        garage.setVehicles(vehiclesList);

        System.out.println("Vehículos ordenados por precio de menor a mayor\n");
        garage.getVehicles().stream()
                .sorted(Comparator.comparingInt(Vehicle::getCost))
                .forEach(System.out::println);

        System.out.println("\nVehículos ordenados por marca y precio\n");
        garage.getVehicles().stream()
                .sorted(Comparator.comparingInt(Vehicle::getCost))
                .sorted( (vehicle1, vehicle2) -> vehicle1.getBrand().compareToIgnoreCase(vehicle2.getBrand()))
                .forEach(System.out::println);

        System.out.println("\nVehículos con precio menor a 1000\n");

        garage.getVehicles().stream()
                        .filter( vehicle -> vehicle.getCost() < 1000)
                        .forEach(System.out::println);

        System.out.println("\nVehículos con precio mayor o igual a 1000\n");

        garage.getVehicles().stream()
                .filter( vehicle -> vehicle.getCost() >= 1000)
                .forEach(System.out::println);

        System.out.println("\nPromedio del total de precios de los vehículos");

        double costAvg = garage.getVehicles().stream()
                .mapToInt(Vehicle::getCost)
                .average().orElse(0);

        System.out.printf("%.2f",costAvg);
    }
}