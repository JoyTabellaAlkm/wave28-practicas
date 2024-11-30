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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double calculoPrecio = super.calcular(cantidadDeProductos);

        calculoPrecio = switch (diasPorCaducar) {
            case 3 -> calculoPrecio * 0.50;
            case 2 -> calculoPrecio * 0.33;
            case 1 -> calculoPrecio * 0.25;
            default -> calculoPrecio;
        };

        return  calculoPrecio;
    }
}
