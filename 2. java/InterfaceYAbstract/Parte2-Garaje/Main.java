import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
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
        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);
        Garaje garaje = new Garaje(1, vehiculos);
        System.out.println("--------------------");
        System.out.println("Vehiculos ordenado de menor a mayor");
        System.out.println("--------------------");
        garaje.getVehiculos().stream().sorted((x, y) -> x.getCosto() - y.getCosto()).forEach(
                System.out::println);
        ;
        System.out.println("--------------------");
        System.out.println("Vehiculos ordenado por marca y por precio");
        System.out.println("--------------------");
        garaje.getVehiculos().stream()
                .sorted((x, y) -> x.getCosto() - y.getCosto())
                .sorted((x, y) -> x.getMarca().compareToIgnoreCase(y.getMarca()))
                .forEach(
                        System.out::println);
        ;
        System.out.println("--------------------");
        System.out.println("Vehiculos con precio menor a 1000");
        System.out.println("--------------------");
        garaje.getVehiculos().stream()
                .filter(x -> x.getCosto() < 1000)
                .forEach(
                        System.out::println);
        ;
        System.out.println("--------------------");
        System.out.println("Vehiculos con precio mayor o igual a 1000");
        System.out.println("--------------------");
        garaje.getVehiculos().stream()
                .filter(x -> x.getCosto() >= 1000)
                .forEach(
                        System.out::println);
        ;
        System.out.println("--------------------");
        System.out.println("Promedio de total de precios de la lista");
        System.out.println("--------------------");
        double average = garaje.getVehiculos().stream().mapToDouble(a -> a.getCosto()).average().orElse(0);
        System.out.printf("%,.2f\n", average);
    }

}
