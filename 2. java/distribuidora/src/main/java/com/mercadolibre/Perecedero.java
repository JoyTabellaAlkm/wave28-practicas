package com.mercadolibre;

public class Perecedero extends Producto {

    private int diasPorCaducar;

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
    public double calcular(int cantidadProductos) {
        double total = super.calcular(cantidadProductos);
        switch (diasPorCaducar) {
            case 1:
                return total / 4;
            case 2:
                return total / 3;
            case 3:
                return total / 2;
            default:
                return total;
        }
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() + '\'' +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }

}
