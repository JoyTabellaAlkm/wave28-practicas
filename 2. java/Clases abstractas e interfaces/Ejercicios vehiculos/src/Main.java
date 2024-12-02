import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int sumaVehiculos = 0;
        double promedioDeCostos = 0;
        List<Vehiculo> vehiculos = Stream.of(
                new Vehiculo("Fiesta", "Ford", 1000),
                new Vehiculo("Focus", "Ford", 1200),
                new Vehiculo("Explorer", "Ford", 2500),
                new Vehiculo("Uno", "Fiat", 500),
                new Vehiculo("Cronos", "Fiat", 1000),
                new Vehiculo("Torino", "Fiat", 1250),
                new Vehiculo("Aveo", "Chevrolet", 1250),
                new Vehiculo("Spin", "Chevrolet", 2500),
                new Vehiculo("Corola", "Toyota", 1200),
                new Vehiculo("Fortuner", "Toyota", 3000)
        ).collect(Collectors.toList());

        System.out.println("Lista de vehiculos -------------------");
        vehiculos.forEach(System.out::println);

        List<Vehiculo> vehiculosXPrecio = vehiculos.stream()
                .sorted((v1, v2) -> (v1.getCosto() - v2.getCosto()))
                .toList();

        System.out.println(" ");
        System.out.println("Lista de vehiculos ordenada por precio---------");
        vehiculosXPrecio.forEach(System.out::println);
        System.out.println(" ");

        List<Vehiculo> vehiculosXPrecioYMarca = vehiculosXPrecio.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .toList();

        System.out.println(" ");
        System.out.println("Lista de vehiculos ordenada por precio y marca---------");
        vehiculosXPrecioYMarca.forEach(System.out::println);
        System.out.println(" ");

        List<Vehiculo> vehiculosCostoMenor1000 = vehiculos.stream()
                .filter((v1) -> (v1.getCosto() < 1000))
                .toList();

        System.out.println(" ");
        System.out.println("Lista de vehiculos con costo menor a mil");
        vehiculosCostoMenor1000.forEach(System.out::println);
        System.out.println(" ");

        List<Vehiculo> vehiculosCostoMayores1000 = vehiculos.stream()
                .filter((v1) -> (v1.getCosto() >= 1000))
                .toList();

        System.out.println(" ");
        System.out.println("Lista de vehiculos con costo mayor o igual a mil");
        vehiculosCostoMayores1000.forEach(System.out::println);
        System.out.println(" ");

        for(Vehiculo vehiculo: vehiculos) {
            sumaVehiculos += vehiculo.getCosto();
            promedioDeCostos = (double) sumaVehiculos / vehiculos.size();
        }

        System.out.println("El costo promedio de los vehiculos es: " + promedioDeCostos);
    }
}