package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        // Punto 2
        List<Vehiculo> listadoVehiculos = new ArrayList<>();
        listadoVehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        listadoVehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        listadoVehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        listadoVehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        listadoVehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        listadoVehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        listadoVehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        listadoVehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        listadoVehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        listadoVehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        listadoVehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garaje garaje = new Garaje("garaje1", listadoVehiculos );

        // Punto 3
        System.out.println("===== PUNTO 3 POR COSTO =====");
        listadoVehiculos.stream()
                .sorted((v1, v2) -> (int) (v1.getCosto() - v2.getCosto()))
                .forEach(System.out::println);

        // Punto 4
        System.out.println("===== PUNTO 4 SORTEO POR MARCA Y COSTO =====");
        listadoVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        // Punto 5
        System.out.println("===== PUNTO 5 VEHICULOS PRECIO MENOR A 1000 =====");
        listadoVehiculos.stream().filter((vehiculo) ->  vehiculo.getCosto() < 1000).forEach(System.out::println);

        // Punto 6
        System.out.println("===== PUNTO 5 VEHICULOS PRECIO MAYOR O IGUAL A 1000 =====");
        listadoVehiculos.stream().filter((vehiculo) ->  vehiculo.getCosto() >= 1000).forEach(System.out::println);

        // Punto 7
        System.out.println("===== PUNTO 5 PROMEDIO TOTAL PRECIOS =====");
        System.out.println(Math.round(listadoVehiculos.stream().mapToDouble(value -> value.getCosto()).average().orElse(0.0)));

    }

}