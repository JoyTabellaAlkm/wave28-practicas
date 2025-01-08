import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Garaje garaje = new Garaje(1);
        garaje.agregarVehiculo(new Vehiculo("Fiesta", "Ford", 1000));
        garaje.agregarVehiculo(new Vehiculo("Focus", "Ford", 1200));
        garaje.agregarVehiculo(new Vehiculo("Explorer", "Ford", 2500));
        garaje.agregarVehiculo(new Vehiculo("Uno", "Fiat", 500));
        garaje.agregarVehiculo(new Vehiculo("Cronos", "Fiat", 1000));
        garaje.agregarVehiculo(new Vehiculo("Torino", "Fiat", 1250));
        garaje.agregarVehiculo(new Vehiculo("Aveo", "Chevrolet", 1250));
        garaje.agregarVehiculo(new Vehiculo("Spin", "Chevrolet", 2500));
        garaje.agregarVehiculo(new Vehiculo("Corola", "Toyota", 1200));
        garaje.agregarVehiculo(new Vehiculo("Fortuner", "Toyota", 3000));
        garaje.agregarVehiculo(new Vehiculo("Logan", "Renault", 950));

        List<Vehiculo> vehiculosOrdenados = garaje.getVehiculos();
        vehiculosOrdenados.sort(Comparator.comparingDouble(Vehiculo::getCosto));

        System.out.println("vehiculos Ordenados: \n");
        for (Vehiculo vehiculo : vehiculosOrdenados){
            System.out.println(vehiculo);
        }

        List<Vehiculo> vehiculosMarcaCosto = garaje.getVehiculos();
        vehiculosMarcaCosto.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));

        System.out.println("Orden por marca y costo\n");
        for (Vehiculo vehiculo:vehiculosMarcaCosto){
            System.out.println(vehiculo);
        }
        System.out.println("Vehiculos No Mayores Mil\n");
        List<Vehiculo> vehiculosNoMayoresMil = vehiculosMarcaCosto.stream()
                .filter(v -> v.getCosto() < 1000)
                .toList();


        for (Vehiculo vehiculo:vehiculosNoMayoresMil){
            System.out.println(vehiculo);
        }

        List<Vehiculo> vehiculosMayoresMil = vehiculosMarcaCosto.stream()
                .filter(v -> v.getCosto() >= 1000)
                .toList();
        System.out.println("Vehiculos Mayores a Mil\n");
        for (Vehiculo vehiculo: vehiculosMayoresMil){
            System.out.println(vehiculo);
        }

        double promedioVehiculos = vehiculosOrdenados.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println("Promedio total de costo de vehiculos: "+promedioVehiculos);
    }
}