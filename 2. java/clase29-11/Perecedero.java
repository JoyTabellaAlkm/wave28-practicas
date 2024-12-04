public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, Double precio) {
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
                "diasPorCaducar=" + this.diasPorCaducar +
                '}';
    }

    @Override
    public Double calcular(int cantidadDeProductos) {
        return this.diasPorCaducar == 1 ? super.calcular(cantidadDeProductos)/4 :
                this.diasPorCaducar == 2 ? super.calcular(cantidadDeProductos)/3 :
                        this.diasPorCaducar == 3 ? super.calcular(cantidadDeProductos)/2 :
                                super.calcular(cantidadDeProductos);
    }
}
