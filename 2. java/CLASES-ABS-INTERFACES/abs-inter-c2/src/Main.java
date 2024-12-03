import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*Ejercicio 3

Haciendo uso del metodo sort en la lista de Vehículos con expresiones lambda, obtén una lista de vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado.



 Ejercicio 4

De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.



Ejercicio 5

Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000 y por último, obtén el promedio total de precios de toda la lista de vehículos. */

public class Main {
    public static void main(String[] args) {

       List<Vehicle> vehicleList = new ArrayList<>();
       vehicleList.add(new Vehicle("Ford", "Fiesta", 1000));
       vehicleList.add(new Vehicle("Ford", "Focus", 1200));
       vehicleList.add(new Vehicle("Ford", "Explorer", 2500));
       vehicleList.add(new Vehicle("Fiat", "Uno", 500));
       vehicleList.add(new Vehicle("Fiat", "Cronos", 1000));
       vehicleList.add(new Vehicle("Fiat", "Torino", 1250));
       vehicleList.add(new Vehicle("Chevrolet", "Aveo", 1250));
       vehicleList.add(new Vehicle("Chevrolet", "Spin", 2500));
       vehicleList.add(new Vehicle("Toyota", "Corolla", 1200));
       vehicleList.add(new Vehicle("Toyota", "Fortuner", 3000));
       vehicleList.add(new Vehicle("Renault", "Logan", 950));
       Garage garage = new Garage(1, vehicleList);
       garage.printSortedByCost();
       System.out.println("=================");
       garage.printSortedByBrandAndCost();
       System.out.println("=================");
       garage.extractVehiclesBasedOnPrice(true);
       System.out.println("=================");
       garage.extractVehiclesBasedOnPrice(false);
       System.out.println("=================");
       garage.getAverageCost();
    }
}