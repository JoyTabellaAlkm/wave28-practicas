import Clases.Garaje;
import Clases.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args){
        Garaje garaje = new Garaje("Garaje1", new ArrayList<>());
        garaje.getVehiculos().add(new Vehiculo("Ford", "Fiesta", 1000));
        garaje.getVehiculos().add(new Vehiculo("Ford", "Focus", 1200));
        garaje.getVehiculos().add(new Vehiculo("Ford", "Explorer", 2500));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Uno", 500));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Cronos", 1000));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Torino", 1250));
        garaje.getVehiculos().add(new Vehiculo("Chevrolet", "Aveo", 1250));
        garaje.getVehiculos().add(new Vehiculo("Chevrolet", "Spin", 2500));
        garaje.getVehiculos().add(new Vehiculo("Toyota", "Corola", 1200));
        garaje.getVehiculos().add(new Vehiculo("Toyota", "Fortuner", 3000));
        garaje.getVehiculos().add(new Vehiculo("Renault", "Logan", 950));

        System.out.println("Orden por Precio ------------------->");
        List<Vehiculo> ordenPrecio = garaje.getVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).toList();
        for (Vehiculo vehiculo : ordenPrecio) System.out.println(vehiculo);

        System.out.println("Orden por Precio y marca ----------->");
        List<Vehiculo> ordenMarcaPrecio = ordenPrecio.stream().sorted(Comparator.comparing(Vehiculo::getMarca)).toList();
        for (Vehiculo vehiculo : ordenMarcaPrecio) System.out.println(vehiculo);

        System.out.println("Vehículos con precio menor a 1000 ----------->");
        List<Vehiculo> precioMenor1000 = ordenMarcaPrecio.stream().filter(v1 -> v1.getCosto() < 1000).toList();
        for (Vehiculo vehiculo : precioMenor1000) System.out.println(vehiculo);

        System.out.println("Vehículos con precio mayor o igual a 1000 ----------->");
        List<Vehiculo> precioMayor1000 = ordenPrecio.stream().filter(v1 -> v1.getCosto() >= 1000).toList();
        for (Vehiculo vehiculo : precioMayor1000) System.out.println(vehiculo);

        double sumaCostos = garaje.getVehiculos().stream()
                .map(Vehiculo::getCosto)
                .reduce(0.0, Double::sum);
        double promedioCosto = sumaCostos / garaje.getVehiculos().size();
        System.out.println("El promedio de los precios de los autos es "+ String.format("%.2f", promedioCosto));
    }
}
