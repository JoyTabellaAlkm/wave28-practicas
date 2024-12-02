package clases;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id, List<Vehiculo> vehiculos){
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void shortByPrice(){
        List vehiculos = this.vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getPrecio)).toList();
        System.out.println("""
                Ordenado por precio de menor a mayor:
                %s""".formatted(vehiculos));
    }

    public void shortByPriceAndMarca(){
        List vehiculos = this.vehiculos.stream().sorted(
                Comparator.comparing(Vehiculo::getPrecio)
        ).sorted((v1,v2) -> v1.getMarca().compareTo(v2.getMarca())).toList();
        System.out.println("""
                Ordenado por precio y marca:
                %s""".formatted(vehiculos));
    }

    public void vehiculosPrecioNoMayorMil(){
        List vehiculos = this.vehiculos.stream().filter((v) -> v.getPrecio() < 1000).toList();
        System.out.println("""
                Vehiculos con precio no mayotr a 1000:
                %s""".formatted(vehiculos));
    }

    public void vehiculosPrecioIgualMayorMayorMil(){
        List vehiculos = this.vehiculos.stream().filter((v) -> v.getPrecio() >= 1000).toList();
        System.out.println("""
                Vehiculos con precio mayor o igual a  1000:
                %s""".formatted(vehiculos));
    }

    public void promedio(){
        double promedio = this.vehiculos.stream().mapToInt(Vehiculo::getPrecio).average().orElse(0);
        System.out.println("""
               Promedio de precios:
               %s""".formatted(promedio));
    }
}
