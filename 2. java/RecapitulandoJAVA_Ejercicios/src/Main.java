
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000d));
        listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200d));
        listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500d));
        listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500d));
        listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000d));
        listaVehiculos.add(new Vehiculo("Fiat", "Torino", 1250d));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250d));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500d));
        listaVehiculos.add(new Vehiculo("Toyota", "Corola", 1200d));
        listaVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000d));
        listaVehiculos.add(new Vehiculo("Renault", "Logan", 950d));

        System.out.println("Ejercicio 3 - SORTEO POR COSTO");
        listaVehiculos.stream()
                .sorted((v1, v2) -> (int) (v1.getCosto() - v2.getCosto()))
                .forEach(System.out::println);
        System.out.println("Ejercicio 4 - SORTEO POR MARCA Y COSTO");
        listaVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("Ejercicio 5 - Filtrado precios no mayor a 1000");
        List<Vehiculo> listaVehiculosMenorA1000 = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000).toList();
        System.out.println(listaVehiculosMenorA1000);

        System.out.println("Ejercicio 5 - Filtrado precios mayor o igual 1000");
        List<Vehiculo> listaVehiculosMayorOIgualA1000 = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000).toList();
        System.out.println(listaVehiculosMayorOIgualA1000);

        Double promedioCosto = listaVehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(Double.NaN);

        System.out.println("Ejercicio 5 - Promedio costos");
        System.out.println("Promedio costos: " + promedioCosto);

        System.out.println("=== GARAGE ===");
        Garaje garaje = new Garaje(1, listaVehiculos);
        System.out.println(garaje);
    }
}