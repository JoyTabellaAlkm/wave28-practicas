import java.util.ArrayList;

public class Main {
    public static void main(String [] argv){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000.00));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200.00));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500.00));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500.00));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000.00));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250.00));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250.00));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500.00));
        vehiculos.add(new Vehiculo("Toyota", "Corolla", 1200.00));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000.00));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950.00));
        Garaje garaje = new Garaje(1,vehiculos);
        System.out.println(garaje.getVehiculosMenorAMayor());
        System.out.println(garaje.getVehiculosMarcaYPrecio());
        System.out.println(garaje.getVehiculosMenor1000());
        System.out.println(garaje.getVehiculosMayorIgual1000());
        System.out.println(garaje.getPromedioCosto());
    }
}