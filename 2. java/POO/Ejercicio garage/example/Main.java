package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        Instanciar vehiculos y garage
        Vehiculo fiesta = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo focus = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo explorer = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo uno = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo cronos = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo torino = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo aveo = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo spin = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo corola = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo fortuner = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo logan = new Vehiculo("Logan", "Renault", 950);

        Garage instancia1 = new Garage(1, List.of(fiesta,focus,explorer,uno,cronos,torino,aveo,spin,corola,fortuner,logan));

//        Ordenar por costo
        instancia1.getListaVehiculos().stream().sorted((a,b)->a.getCostos()-b.getCostos()).forEach(System.out::println);

        //        Ordenar por costo y marca

        System.out.println("Ordenado por marca y costo");
        instancia1.getListaVehiculos()
                .stream()
                .sorted((a,b)->{
                    int marca =a.getMarca().compareTo(b.getMarca());
                    if(marca != 0){
                        return marca;
                    }
                    return a.getCostos() - b.getCostos();
                })

                .forEach(System.out::println);


//        Mostrar vehiculos menores a mil
        List<Vehiculo> vehiculosMenoresA1000= instancia1.getListaVehiculos().stream().filter(v->v.getCostos()<1000).toList();
//        Mostrar vehiculos mayores o igual a mil

        List<Vehiculo> vehiculosMayoresA1000= instancia1.getListaVehiculos().stream().filter(v->v.getCostos()>=1000).toList();

//        Traer promedio
        double promedio = instancia1.getListaVehiculos()
                .stream()
                .mapToInt(Vehiculo::getCostos)
                .average()
                .orElse(0.0);

        System.out.println(promedio);








    }
}