import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) throws Exception {

        Vehiculo v1 = new Vehiculo("Ford", "Fiesta",1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer",2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500); 
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo ("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculosList = List.of(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11);

        List<Vehiculo> vehiculosListOrdered = vehiculosList.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .toList();

        vehiculosListOrdered.forEach(x -> System.out.println(x.getMarca() + " " + x.getModelo() + " " + x.getCosto()));
        System.out.println("---------------------------------");
        List<Vehiculo> vehiculosListOrderedByMarcaYPrecio = vehiculosList.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .sorted((x, y) -> x.getMarca().compareToIgnoreCase(y.getMarca()))
                .toList();

        vehiculosListOrderedByMarcaYPrecio.forEach(x -> System.out.println(x.getMarca() + " " + x.getModelo() + " " + x.getCosto()));

        List<Vehiculo> vehiculosListMenores1000 = vehiculosList.stream().filter(x -> x.getCosto() < 1000)
                .toList();

        List<Vehiculo> vehiculosListMayorIgual1000 = vehiculosList.stream().filter(x -> x.getCosto() >= 1000)
                .toList();

        Double promedio = vehiculosList.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0);

        Double promedio2 = vehiculosList.stream().collect(Collectors.averagingDouble(Vehiculo::getCosto));


        System.out.println("El promedio es: " + promedio);
        System.out.println("El promedio2 es: " + promedio2);
        

    }
}