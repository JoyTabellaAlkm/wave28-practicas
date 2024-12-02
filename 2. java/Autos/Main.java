import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje garage = new Garaje(1, List.of(
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

        // List<Vehiculo> listaOrdenaPrecio = garage.getListaVehiculos().stream().sorted((v1,v2) -> v1.getCosto() - v2.getCosto()).toList();
        // System.out.println(listaOrdenaPrecio);

        System.out.println("Orden x precio");
        garage.getListaVehiculos().stream().sorted((v1,v2) -> v1.getCosto() - v2.getCosto())
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Orden x Marca y Precio");
        garage.getListaVehiculos().stream().sorted(Comparator.comparing((Vehiculo::getMarca)).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Autos < a 1000");
        garage.getListaVehiculos().stream().filter(v1 -> v1.getCosto() < 1000).forEach(System.out::println);
        System.out.println();

        System.out.println("Autos >= a 1000");
        garage.getListaVehiculos().stream().filter(v1 -> v1.getCosto() >= 1000).forEach(System.out::println);
        System.out.println();

        System.out.println("Promedio de costo");
        System.out.println(garage.getListaVehiculos().stream().mapToInt(Vehiculo::getCosto).average());


    }
}