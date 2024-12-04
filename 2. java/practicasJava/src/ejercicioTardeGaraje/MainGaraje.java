package ejercicioTardeGaraje;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MainGaraje {
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

        List<Vehiculo> listaVehiculos = List.of(vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5,
                vehiculo6, vehiculo7, vehiculo8, vehiculo9, vehiculo10, vehiculo11);

        Garaje garaje = new Garaje(1, listaVehiculos);

        System.out.println(garaje);
        System.out.println("---------------------");

        List<Vehiculo> listaVehiculosOrdenadaPrecioMenorMayor = listaVehiculos.stream()
                .sorted((v1, v2) -> v1.getCosto() + v2.getCosto())
                .toList();
        listaVehiculosOrdenadaPrecioMenorMayor.forEach(x -> System.out.println(x.getMarca() +
                " " + x.getModelo() + " " + x.getCosto()));
        System.out.println("--------------------");

        List<Vehiculo> listaVehiculosOrdenadaMarcaPrecio = listaVehiculos.stream()
                .sorted((v1, v2) -> v1.getCosto() - v2.getCosto())
                .sorted((v1, v2) -> v1.getMarca().compareToIgnoreCase(v2.getMarca()))
                .toList();
        listaVehiculosOrdenadaMarcaPrecio.forEach(x -> System.out.println(x.getMarca() +
                " " + x.getModelo() + " " + x.getCosto()));
        System.out.println("-------------------");

        List<Vehiculo> vehiculosOrdenados = listaVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        vehiculosOrdenados.forEach(x -> System.out.println(x.getMarca() +
                " " + x.getModelo() + " " + x.getCosto()));
        System.out.println("-------------------");

        List<Vehiculo> listaVehiculosNoMayor1000 = listaVehiculos.stream()
                .filter(x -> x.getCosto() < 1000)
                .toList();
        listaVehiculosNoMayor1000.forEach(x -> System.out.println(x.getMarca() +
                " " + x.getModelo() + " " + x.getCosto()));
        System.out.println("------------------");

        List<Vehiculo> listaVehiculosMayorIgual1000 = listaVehiculos.stream()
                .filter(x -> x.getCosto() >= 1000)
                .toList();
        listaVehiculosMayorIgual1000.forEach(x -> System.out.println(x.getMarca() +
                " " + x.getModelo() + " " + x.getCosto()));
        System.out.println("----------------");

        //Primera forma
        Double promedio = listaVehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0);

        //Seguna forma con ayuda de Vanina
        Double promedio2 = listaVehiculos.stream().collect(Collectors.averagingDouble(Vehiculo::getCosto));

        System.out.println(promedio);
        System.out.println(promedio2);
    }
}
