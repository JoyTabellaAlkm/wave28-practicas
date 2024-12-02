package com.mercadolibre;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Instanciar vehiculos y garage
        Vehiculo fiesta = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo focus = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo explorer = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo uno = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo cronos = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo torino = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo aveo = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo spin = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo corola = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo fortuner = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo logan = new Vehiculo("Logan", "Renault", 950);

        List<Vehiculo> vehiculos = List.of(fiesta, focus, explorer, uno, cronos, torino, aveo, spin, corola, fortuner,
                logan);

        Garage instancia1 = new Garage(1, vehiculos);

        // Ordenar por costo
        System.out.println("Ordenado por costo");
        instancia1.getListaVehiculos()
                .stream()
                .sorted((a, b) -> a.getCostos() - b.getCostos())
                .forEach(System.out::println);

        // Ordenar por costo y marca
        System.out.println("Ordenado por marca y costo");
        instancia1.getListaVehiculos()
                .stream()
                .sorted((a, b) -> {
                    int marca = a.getMarca().compareTo(b.getMarca());
                    if (marca != 0) {
                        return marca;
                    }
                    return a.getCostos() - b.getCostos();
                }).forEach(System.out::println);

        // Mostrar vehiculos menores a mil
        System.out.println("Costo menor a mil");
        instancia1.getListaVehiculos()
                .stream()
                .filter(v -> v.getCostos() < 1000)
                .forEach(System.out::println);

        // Mostrar vehiculos mayores o igual a mil
        System.out.println("Costo mayor o igual a mil");
        instancia1.getListaVehiculos()
                .stream()
                .filter(v -> v.getCostos() >= 1000)
                .forEach(System.out::println);

        // Traer promedio
        System.out.println("Promedio");
        double promedio = instancia1.getListaVehiculos()
                .stream()
                .mapToInt(Vehiculo::getCostos)
                .average()
                .orElse(0.0);

        System.out.println(promedio);
    }
}