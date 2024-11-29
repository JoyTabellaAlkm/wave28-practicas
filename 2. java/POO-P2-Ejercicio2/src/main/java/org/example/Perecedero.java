package org.example;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public double calcular(int cantProd) {
        return this.diasPorCaducar == 1 ? this.getPrecio() * (double)cantProd / (double)4.0F : (this.diasPorCaducar == 2 ? this.getPrecio() * (double)cantProd / (double)3.0F : (this.diasPorCaducar == 3 ? this.getPrecio() * (double)cantProd / (double)2.0F : this.getPrecio() * (double)cantProd));
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                "} " + super.toString();
    }
}
