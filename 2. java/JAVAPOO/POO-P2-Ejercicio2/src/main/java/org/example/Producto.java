
package org.example;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Producto{nombre='" + this.nombre + "', precio=" + this.precio + "}";
    }

    public double calcular(int cantProd) {
        return this.precio * (double)cantProd;
    }
}
