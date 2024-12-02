package perecedero;

import producto.Producto;

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
    public double calcular(int cantidadDeProductos) {
        if(this.diasPorCaducar <= 0) {
            throw new IllegalArgumentException("El producto esta vencido");
        }
        double total = cantidadDeProductos * this.getPrecio();
        return this.diasPorCaducar < 4?  total / (5 - this.diasPorCaducar): total;
    }
}
