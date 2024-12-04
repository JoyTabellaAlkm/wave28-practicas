
import java.util.*;
import java.util.Optional;

import javax.swing.tree.VariableHeightLayoutCache;


public class Main {

  public static void main(String[] args) {
    Garaje g = new Garaje(0);
    Vehiculo carrito1 = new Vehiculo("Fiesta", "Ford", 1000);
    Vehiculo carrito2 = new Vehiculo("Focus", "Ford", 1200);
    Vehiculo carrito3 = new Vehiculo("Explorer", "Ford", 2500);
    Vehiculo carrito4 = new Vehiculo("Uno", "Fiat", 500);
    Vehiculo carrito5 = new Vehiculo("Cronos", "Fiat", 1000);
    Vehiculo carrito6 = new Vehiculo("Torino", "Fiat", 1250);
    Vehiculo carrito7 = new Vehiculo("Aveo", "Chevrolet", 1250);
    Vehiculo carrito8 = new Vehiculo("Spin", "Chevrolet", 2500);
    Vehiculo carrito9 = new Vehiculo("Corola", "Toyota", 1200);
    Vehiculo carrito10 = new Vehiculo("Fortuner", "Toyota", 3000);
    Vehiculo carrito11 = new Vehiculo("Logan", "Renault", 950);
    g.agregarVehiculo(carrito1);
    g.agregarVehiculo(carrito2);
    g.agregarVehiculo(carrito3);
    g.agregarVehiculo(carrito4);
    g.agregarVehiculo(carrito5);
    g.agregarVehiculo(carrito6);
    g.agregarVehiculo(carrito7);
    g.agregarVehiculo(carrito8);
    g.agregarVehiculo(carrito9);
    g.agregarVehiculo(carrito10);
    g.agregarVehiculo(carrito11);

    //Punto 1
    System.out.println("============================================================");
    List<Vehiculo> sort_precio = g.getVehiculos();
    sort_precio.sort((a, b) -> { return a.getCosto() - b.getCosto();});
    for(Vehiculo v : sort_precio){
      System.out.println(v);
    }



    //Punto 2
    System.out.println("============================================================");
    List<Vehiculo> sort_marca_precio = g.getVehiculos();
    sort_precio.sort((a, b) -> {
      int dif = a.getMarca().compareTo(b.getMarca());
      return ( dif == 0 ? a.getCosto() - a.getCosto() : dif);
    });
    for(Vehiculo v : sort_precio){
      System.out.println(v);
    }



    //Punto 3
    System.out.println("============================================================");
    List<Vehiculo> leq_100 = g.getVehiculos().stream().filter( a -> a.getCosto() <= 1000 ).toList(); 
    for(Vehiculo v : leq_100){
      System.out.println(v);
    }
    System.out.println("============================================================");
    List<Vehiculo> geq_100 = g.getVehiculos().stream().filter( a -> a.getCosto() >= 1000  ).toList(); 
    for(Vehiculo v : leq_100){
      System.out.println(v);
    }
    System.out.println("============================================================");
    Double avg = g.getVehiculos().stream().mapToDouble(a -> a.getCosto()).average().orElse(Double.NaN);
    System.out.println("Promedio es: " + avg);
  }
  
}
