package POO.Productos;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
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
                '}';
    }

    @Override
    public double calcular(int cantidaDeProductos) {
        double total = super.calcular(cantidaDeProductos);
        switch (diasPorCaducar){
            case 1:
                return total-(total/4);
            case 2:
                return total -(total/3);
            case 3:
                return total -(total/2);
            default:
                return total;
        }

    }
}
