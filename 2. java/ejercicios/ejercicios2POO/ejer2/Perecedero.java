package ejercicios.ejercicios2POO.ejer2;

public class Perecedero extends Producto{
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
        return super.toString() + " Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double total = super.calcular(cantidadDeProductos);
        switch(diasPorCaducar){
            case 1:
                return total - (total * 0.75);
            case 2:
                return total - (total * 0.66);
            case 3:
                return total - (total * 0.5);
            default:
                return total;
        }
    }
}
