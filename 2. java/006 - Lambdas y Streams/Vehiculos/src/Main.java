import Modelo.Garaje;
import Modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo vehiculo1 = new Vehiculo("Fiesta","Ford",1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus","Ford",1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer","Ford",2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno","Fiat",500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos","Fiat",1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino","Fiat",1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo","Chevrolet",1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin","Chevrolet",2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola","Toyota",1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner","Toyota",3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan","Renault",950);
        vehiculos = List.of(vehiculo1,vehiculo2,vehiculo3,vehiculo4,vehiculo5,vehiculo6,vehiculo7,vehiculo8,vehiculo9,vehiculo10,vehiculo11);
        Garaje garaje = new Garaje(1,vehiculos);

        List<Vehiculo> lstVehiculosOrdenados = garaje.getVehiculos().stream().sorted((v1,v2)-> v1.getCosto() - v2.getCosto()).toList();
        System.out.println("Ordenadas por costo: ");
        System.out.println(lstVehiculosOrdenados);

        List<Vehiculo> lstVehiculosOrdenados2 = garaje.getVehiculos().stream()
                .sorted((v1,v2)-> v1.getCosto() - v2.getCosto())
                .sorted((v1,v2) -> v1.getMarca().compareTo(v2.getMarca()))
                .toList();
        System.out.println("Ordenadas por marca y costo: ");
        System.out.println(lstVehiculosOrdenados2);

        List<Vehiculo> lstVehiculosOrdenados3 = garaje.getVehiculos().stream().
        filter(v -> v.getCosto() < 1000)
        .toList();
        System.out.println("Costo menor a 1000: ");
        System.out.println(lstVehiculosOrdenados3);

        List<Vehiculo> lstVehiculosOrdenados4 = garaje.getVehiculos().stream().
                filter(v -> v.getCosto() >= 1000)
                .toList();
        System.out.println("Costo mayor a 1000: ");
        System.out.println(lstVehiculosOrdenados4);

        Double promedio = garaje.getVehiculos().stream()
                .mapToDouble(v -> v.getCosto())
                .average()
                .orElse(0.0);
        System.out.println("Promedio costo: ");
        System.out.println(promedio);
    }
}
