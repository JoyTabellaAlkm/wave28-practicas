package com.bootcampJava;

public class Perecedero extends Producto{
    int diasPorCaducar;

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precioFinal = super.calcular(cantidadDeProductos);

        switch (diasPorCaducar) {
            case 1:
                return precioFinal/4;

            case 2:
                return precioFinal/3;
            case 3:
                return precioFinal/2;

        }
        return precioFinal;
    }
}
