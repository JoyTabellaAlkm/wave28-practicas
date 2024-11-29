package poo.p2.ejercicios_sincronicos.productoEjercicio;

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
        if (this.diasPorCaducar == 1) {
            return (this.getPrecio() * cantidadDeProductos) * 0.25;
        } else if (this.diasPorCaducar == 2) {
            return (this.getPrecio() * cantidadDeProductos) * 0.33;
        } else if (this.diasPorCaducar == 3) {
            return (this.getPrecio() * cantidadDeProductos) * 0.50;
        } else if (this.diasPorCaducar > 3) {
            return this.getPrecio() * cantidadDeProductos;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                "nombre=" + this.getNombre() +
                "precio=" + this.getPrecio() +
                "} ";
    }
}
