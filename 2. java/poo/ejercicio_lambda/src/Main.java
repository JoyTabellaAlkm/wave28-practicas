import classes.Garage;
import classes.Vehiculo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(vehiculos);

        // ejercicio 3
        garage.vehiculosMenorAMayor();
        System.out.println();

        // ejercicio 4
        garage.vehiculosMarcaAndMenorAMayor();
        System.out.println();

        // ejercicio 5
        // autos menores a mil
        garage.vehiculosMenoresMil();
        System.out.println();

        // autos mayores a mil
        garage.vehiculosMayoresIgualMil();
        System.out.println();

        // Precio promedio
        garage.vehiculosPromedio();
        System.out.println();
    }
}