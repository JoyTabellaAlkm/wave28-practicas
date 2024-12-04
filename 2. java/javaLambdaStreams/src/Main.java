import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Vehiculo> garage  = new ArrayList<>(List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corolla", 1200),
                new Vehiculo("Toyota", "Fortuna", 3000),
                new Vehiculo("Renault", "Logan", 950)
        ));

         System.out.println("\n" +"******Lista de vehiculos ordenados de menor a mayor********");
         garage.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\n" +"******Lista de vehiculos ordenados por marca********");
        garage.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .forEach(System.out::println);

        System.out.println("\n" +"******Lista de vehiculos con precio menor a 1000********");
        List<Vehiculo> listaDeProductoConPrecioMenorA = garage.stream()
                .filter(a -> a.getCosto() <= 1000)
                .toList();

        listaDeProductoConPrecioMenorA.forEach(a ->System.out.println(a));

        System.out.println("\n" + "******Lista de vehiculos con precio mayor a 1000r********");
        List<Vehiculo> listaDeProductoConPrecioMayorA = garage.stream()
                .filter(a -> a.getCosto() >= 1000)
                .toList();
        listaDeProductoConPrecioMayorA.forEach(a ->System.out.println(a));


        double promedio = garage.stream().
                mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.printf("\n" +"Promedio:  %,.2f\n" , promedio);


    }
}