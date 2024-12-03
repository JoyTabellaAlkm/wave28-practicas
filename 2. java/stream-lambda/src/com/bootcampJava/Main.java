package com.bootcampJava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950);

        vehiculos = List.of(vehiculo1,vehiculo2,vehiculo3,vehiculo4,vehiculo5,vehiculo6,vehiculo7,vehiculo8,vehiculo9,vehiculo10,vehiculo11);
        Garage garage1 = new Garage(1,vehiculos);

        List<Vehiculo> listaPreciosOrdenados = garage1.getVehiculos().stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .toList();

        System.out.println("Lista ordenada por costo de menor a mayor");
        System.out.println(listaPreciosOrdenados);

        List<Vehiculo> listaOrdenadaPorMarcaPrecio = garage1.getVehiculos().stream()
                .sorted((v1,v2) -> v1.getCosto() -v2.getCosto())
                .sorted((v1,v2) -> v1.getMarca().compareTo(v2.getMarca()))
                .toList();
        System.out.println("Lista ordenada por marca y precio");
        System.out.println(listaOrdenadaPorMarcaPrecio);

        List<Vehiculo> listaPreciosMenoresAMil = garage1.getVehiculos().stream()
                .filter((v1) -> v1.getCosto() <= 1000)
                .collect(Collectors.toList());
        System.out.println("Lista ordenada por precios menores a 1000");
        System.out.println(listaPreciosMenoresAMil);

        List<Vehiculo> listaPreciosMayoresMil = garage1.getVehiculos().stream()
                .filter(v1 -> v1.getCosto() >= 1000)
                .collect(Collectors.toList());
        System.out.println("Lista ordenada por precios mayores o igual a 1000");
        System.out.println(listaPreciosMayoresMil);

        double promedio = garage1.getVehiculos().stream()
                .mapToDouble(v -> v.getCosto())
                .average()
                .orElse(0.0);
        System.out.println("Promedio costo");
        System.out.println(promedio);
    }
}
