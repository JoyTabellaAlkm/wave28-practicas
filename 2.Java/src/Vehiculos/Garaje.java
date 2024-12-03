package Vehiculos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Garaje {
    int id;
    List<Vehiculo> vehiculos;

    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }

    public List<Vehiculo> ordenarVehiculosPorPrecio(){
        return this.vehiculos.stream().sorted((v1, v2) -> v1.getPrecio() - v2.getPrecio() ).toList();
    }

    public List<Vehiculo> ordenarVehiculosPorMarcaYPrecio() {
        return this.vehiculos.stream()
                .sorted(Comparator.comparing((Vehiculo::getMarca)).thenComparing(Vehiculo::getPrecio))
                .toList();
    }

    public List<Vehiculo> precioMenorAMil(){
        return this.vehiculos.stream().filter((vehiculo -> vehiculo.getPrecio() < 1000)).toList();
    }

    public List<Vehiculo> precioMayorAMil(){
        return this.vehiculos.stream().filter((vehiculo -> vehiculo.getPrecio() >= 1000)).toList();
    }

    public double promedioPrecios(){
        return this.vehiculos.stream().mapToDouble(Vehiculo::getPrecio).average().orElse(0.0);
    }
}
