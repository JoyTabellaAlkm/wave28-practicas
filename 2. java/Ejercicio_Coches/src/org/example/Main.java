package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculoList = new ArrayList<>();

        vehiculoList.add(vehiculo1);
        vehiculoList.add(vehiculo2);
        vehiculoList.add(vehiculo3);
        vehiculoList.add(vehiculo4);
        vehiculoList.add(vehiculo5);
        vehiculoList.add(vehiculo6);
        vehiculoList.add(vehiculo7);
        vehiculoList.add(vehiculo8);
        vehiculoList.add(vehiculo9);
        vehiculoList.add(vehiculo10);
        vehiculoList.add(vehiculo11);

        Garaje garage = new Garaje(1, vehiculoList);

        List<Vehiculo> vehiculosOrdenadosXMayor =  vehiculoList.stream().sorted((v1,v2) -> v1.getCosto() + v2.getCosto() ).toList();
        List<Vehiculo> vehiculosOrdenadosXMenor =  vehiculoList.stream().sorted((v1,v2) -> v1.getCosto() - v2.getCosto() ).toList();

        System.out.println("ORDENADOS DE MENOR A MAYOR: ");
        for (Vehiculo vehiculo : vehiculosOrdenadosXMenor) {
            System.out.println(vehiculo);
        }

        List<Vehiculo> vehiculosOrd = vehiculoList.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).toList();

        System.out.println("ORDENADOS POR MARCA Y PRECIO:");

        for (Vehiculo vehiculo : vehiculosOrd) {
            System.out.println(vehiculo);
        }


        List<Vehiculo> vehiculosCostoMenorA1000 = vehiculoList.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).toList();
        List<Vehiculo> vehiculosCostoMayorA1000 = vehiculoList.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).toList();


        double precioPromedio = vehiculoList.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);;



        System.out.println("Precio promedio: " + String.format("%.2f", precioPromedio));





    }
}