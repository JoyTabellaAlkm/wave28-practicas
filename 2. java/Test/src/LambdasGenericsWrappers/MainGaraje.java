package LambdasGenericsWrappers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainGaraje {
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>(List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corolla", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        ));
        garaje.setId(1);
        garaje.setVehiculos(vehiculos);

        System.out.println("--------------------- ORDEN POR PRECIO ---------------------");
        garaje.getVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println();
        
        System.out.println("--------------------- ORDEN POR MARCA Y PRECIO ---------------------");
        garaje.getVehiculos().stream().sorted(Comparator.comparing((Vehiculo::getMarca)).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("--------------------- VEHICULOS MENOR A 1000 ---------------------");
        garaje.getVehiculos().stream().filter(v1 -> v1.getCosto() < 1000).forEach(System.out::println);
        System.out.println();

        System.out.println("--------------------- VEHICULOS MAYOR A 1000 ---------------------");
        garaje.getVehiculos().stream().filter(v1 -> v1.getCosto() >= 1000).forEach(System.out::println);
        System.out.println();

        System.out.println("--------------------- PROMEDIO PRECIOS ---------------------");
        System.out.println(garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0));

    }
}
