package Entidades;

import Entidades.Productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    // ATTRIBUTES
    private List<Producto> productos;

    // CONSTRUCTOR
    public Reserva(List<Producto> productos) {
        this.productos = productos;
    }

    public Reserva(){
        this.productos = new ArrayList<>();
    }

    // METHOD

    public double obtenerCostoTotal(){
        return productos.stream()
                .mapToDouble(x -> x.getCosto())
                .sum();
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    // TO STRING


    @Override
    public String toString() {
        return "[Reserva] " +
                "Productos: " + productos.stream()
                .map(x -> x.toString());

    }

    // GETS & SETS
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
