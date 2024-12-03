package classes;

import java.util.Comparator;
import java.util.List;

public class Garage {
    private List<Vehiculo> vehiculos;

    public Garage(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void vehiculosMenorAMayor() {
        vehiculos.stream()
                .sorted((v1, v2) -> (int) (v1.getCosto() - v2.getCosto()))
                .forEach(System.out::println);
    }

    public void vehiculosMarcaAndMenorAMayor() {
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public void vehiculosMenoresMil() {
        vehiculos.stream()
                .filter(v -> v.getCosto() < 1000)
                .forEach(System.out::println);
    }

    public void vehiculosMayoresIgualMil() {
        vehiculos.stream()
                .filter(x -> x.getCosto() >= 1000)
                .forEach(System.out::println);
    }

    public void vehiculosPromedio() {
        double promedio = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto).average().orElse(0.0);

        System.out.println("Precio promedio de todos los vehiculos: " + String.format("%.2f", promedio));
    }


}