import com.bootcamp.classes.Garage;
import com.bootcamp.classes.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehiculo1 = new Vehicle("Ford", "Fiesta", 1000);
        Vehicle vehiculo2 = new Vehicle("Ford", "Focus", 1200);
        Vehicle vehiculo3 = new Vehicle("Ford", "Explorer", 2500);
        Vehicle vehiculo4 = new Vehicle("Fiat", "Uno", 500);
        Vehicle vehiculo5 = new Vehicle("Fiat", "Cronos", 1000);
        Vehicle vehiculo6 = new Vehicle("Fiat", "Torino", 1250);
        Vehicle vehiculo7 = new Vehicle("Chevrolet", "Aveo", 1250);
        Vehicle vehiculo8 = new Vehicle("Chevrolet", "Spin", 2500);
        Vehicle vehiculo9 = new Vehicle("Toyota", "Corolla", 1200);
        Vehicle vehiculo10 = new Vehicle("Toyota", "Fortuner", 3000);
        Vehicle vehiculo11 = new Vehicle("Renault", "Logan", 950);
        vehicles = List.of(vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5, vehiculo6, vehiculo7, vehiculo8, vehiculo9, vehiculo10, vehiculo11);

        Garage garage1 = new Garage(vehicles);

        System.out.println("\nRespuesta Ejercicio 3:");
        garage1.printVehiclesByCost();

        System.out.println("\nRespuesta Ejercicio 4:");
        garage1.printVehiclesByBrandAndCost();

        System.out.println("\nRespuesta Ejercicio 5 - 1:");
        garage1.printVehiclesMinorTo1000(true);
        System.out.println("\nRespuesta Ejercicio 5 - 2:");
        garage1.printVehiclesMinorTo1000(false);
        System.out.println("\nRespuesta Ejercicio 5 - 3:");
        garage1.averageCost();
    }
}