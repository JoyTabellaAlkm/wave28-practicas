package practicaVehiculos;

import java.util.List;

public class Main {
    @Override
    public String toString() {
        return "Main{}";
    }

    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Ford","Fiesta",1000.00);
        Vehiculo vehiculo2 = new Vehiculo("Ford","Focus",1200.00);
        Vehiculo vehiculo3 = new Vehiculo("Ford","Explorer",2500.00);
        Vehiculo vehiculo4 = new Vehiculo("Fiat","Uno",500.00);
        Vehiculo vehiculo5 = new Vehiculo("Fiat","Cronos",1000.00);
        Vehiculo vehiculo6 = new Vehiculo("Fiat","Torino",1250.00);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250.00);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500.00);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200.00);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000.00);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950.00);
        Garaje garaje = new Garaje("12432");

        List<Vehiculo> vehiculos = List.of(vehiculo1,vehiculo2,vehiculo3,vehiculo4,vehiculo5,vehiculo6,vehiculo7,vehiculo8,vehiculo9,vehiculo10,vehiculo11);
        
       List<Vehiculo> vehiculosOrdenados = vehiculos.stream().sorted((v1, v2)-> (int) (v1.getPrecio()-v2.getPrecio())).toList();
        System.out.println("vehiculosOrdenados = " + vehiculosOrdenados);

        

        List<Vehiculo> ordenadoMarcaPrecio = vehiculos.stream().sorted((v1, v2)-> (int) (v1.getMarca().compareTo(v2.getMarca()))).toList();
        System.out.println("ordenadoMarcaPrecio = " + vehiculosOrdenados);





    }
}
