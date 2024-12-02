import java.util.Comparator;
import java.util.List;

public class Garage {
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

        // ejercicio 3
        List<Vehiculo> vehiculosMenorAMayor = vehiculos.stream()
                .sorted((a, b) -> (int) ((int) a.costo - b.costo))
                .toList();
        vehiculosMenorAMayor.forEach(System.out::println);
        System.out.println();

        // ejercicio 4
        // usamos lista de autos ya ordenada por precio, para seccionar por marca
        vehiculosMenorAMayor.stream()
                .sorted(Comparator.comparing(a -> a.marca))
                .forEach(System.out::println);
        System.out.println();

        // ejercicio 5
        // autos menores a mil
        vehiculosMenorAMayor.stream()
                .filter(x -> x.costo < 1000)
                .forEach(System.out::println);
        System.out.println();

        // autos mayores a mil
        vehiculosMenorAMayor.stream()
                .filter(x -> x.costo >= 1000)
                .forEach(System.out::println);
        System.out.println();

        double promedio = vehiculosMenorAMayor.stream()
                .mapToDouble(x -> (double) x.costo)
                .average()
                .orElse(0.0);
        System.out.println(Math.round(promedio));
    }
}