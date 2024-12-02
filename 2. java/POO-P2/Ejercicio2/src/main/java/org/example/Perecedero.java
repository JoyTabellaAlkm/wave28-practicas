package org.example;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcularPrecio(int cantidadDeProductos) {
        double total = super.calcularPrecio(cantidadDeProductos);
        return switch (diasPorCaducar) {
            case 1 -> total / 4;
            case 2 -> total / 3;
            case 3 -> total / 2;
            default -> total;
        };
    }
}