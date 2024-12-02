public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double valorBase = super.calcular(cantidadDeProductos);
        return valorBase - descuentoPorCaducidad();
    }

    public double descuentoPorCaducidad() {
        if (diasPorCaducar <= 1) {
            return this.getPrecio() / 4;
        }
        if (diasPorCaducar <= 2) {
            return this.getPrecio() / 3;
        }
        if (diasPorCaducar <= 3) {
            return this.getPrecio() / 2;
        }
        return this.getPrecio();
    }

    @Override
    public String toString() {
        return "Producto Perecedero: " + this.getNombre() + " Precio: " + this.getPrecio() + " Caduca en (dias): "
                + this.diasPorCaducar;
    }
}
