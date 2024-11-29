public class Perecedero extends Producto {
    private int diasPorCaducar;

    // Constructor
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    // Getters y Setters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    // Sobreescribir el método calcular
    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);
        switch (diasPorCaducar) {
            case 1:
                precioFinal /= 4;
                break;
            case 2:
                precioFinal /= 3;
                break;
            case 3:
                precioFinal /= 2;
                break;
            default:
                break;
        }
        return precioFinal;
    }

    // Método toString
    @Override
    public String toString() {
        return super.toString() + ", Dias por caducar=" + diasPorCaducar;
    }
}
