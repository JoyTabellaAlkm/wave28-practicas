import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950);

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

        //Lista original
//        System.out.println("--- Lista Original ---");
//        vehiculos.forEach(vehiculo -> System.out.println(vehiculo));

        Garage garage = new Garage(1);
        garage.setListaVehiculos(vehiculos);

        //Lista Ordenada por costo
        List<Vehiculo> vehiculosOrdenadosPorPrecio =  garage.getListaVehiculos().stream().sorted( (v1, v2) -> v1.getCosto() - v2.getCosto()  ).collect(Collectors.toList());
//        System.out.println("--- Lista Ordenada por Costo ---");
//        vehiculosOrdenadosPorPrecio.forEach(vehiculo -> System.out.println(vehiculo));

        //Lista Ordenada por Marca y Costo
        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio =  garage.getListaVehiculos().stream()
                .sorted( (v1, v2) -> {
                    int i = v1.getMarca().compareTo(v2.getMarca());
                    if(i != 0) {
                        return i;
                    } else {
                        return  v1.getCosto() - v2.getCosto();
                    }
                }).collect(Collectors.toList());

//        System.out.println("--- Lista Ordenada por Marca y Costo ---");
//        vehiculosOrdenadosPorMarcaYPrecio.forEach(vehiculo -> System.out.println(vehiculo));

        //Listas de vehículos Menor a 1000, Mayor a 1000 y promedio de costos
        List<Vehiculo> vehiculosCostoMenorAMil =  garage.getListaVehiculos().stream()
                .filter( vehiculo -> vehiculo.getCosto() < 1000).collect(Collectors.toList());
        System.out.println("--- Lista Costo Menor a 1000 ---");
        vehiculosCostoMenorAMil.forEach(vehiculo -> System.out.println(vehiculo));

        List<Vehiculo> vehiculosCostoMayorAMil =  garage.getListaVehiculos().stream()
                .filter( vehiculo -> vehiculo.getCosto() > 1000).collect(Collectors.toList());
        System.out.println("--- Lista Costo Mayor a 1000 ---");
        vehiculosCostoMayorAMil.forEach(vehiculo -> System.out.println(vehiculo));

        double promedio = garage.getListaVehiculos().stream()
                .mapToInt( (Vehiculo v1) -> v1.getCosto())
                .average()
                .orElse(0.0);
        System.out.println("\nEl promedio de costo por vehículo es de $" + promedio);
    }

    
}