package com.ejemplo;

public class Item {
    private int codigo;
    private String nombre;
    private int cantidadComprada;
    private double costo;

    public Item(int codigo, String nombre, int cantidadComprada, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costo = costo;
    }

    public double calcularCostoTotal() {
        return cantidadComprada * costo;
    }

    @Override
    public String toString() {
        return "Item [codigo=" + codigo + ", nombre=" + nombre + ", cantidadComprada=" + cantidadComprada + ", costo="
                + costo + "]";
    }
}
