package ejercicios.ejerciciosLambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[]args){
        List<Vehiculo> garage = new ArrayList<>();

        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "corolla", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "fortuna", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "logan", 950);

        garage.add(v1);
        garage.add(v2);
        garage.add(v3);
        garage.add(v4);
        garage.add(v5);
        garage.add(v6);
        garage.add(v7);
        garage.add(v8);
        garage.add(v9);
        garage.add(v10);
        garage.add(v11);

        List<Vehiculo> listaOrdenada = garage.stream()
                .sorted((ve1,ve2) -> ve1.getPrecio() - ve2.getPrecio())
                .toList();

        for (Vehiculo lista : listaOrdenada){
            System.out.println(lista.toString());
        }

        List<Vehiculo> listaOrdenadaMarca = garage.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .toList();

        for (Vehiculo lista : listaOrdenadaMarca){
            System.out.println(lista.toString());
        }

        List<Vehiculo> listaMayorMil = garage.stream()
                .filter( a -> a.getPrecio() >= 1000)
                .toList();

        List<Vehiculo> listaMenorMil = garage.stream()
                .filter( a -> a.getPrecio() <= 1000)
                .toList();

        Double Promedio = garage.stream()
                .mapToDouble(Vehiculo::getPrecio)
                .average()
                .getAsDouble();

        System.out.printf("Promedio:  %,.2f\n" , Promedio);


    }
}
