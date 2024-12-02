public class Perecedero extends Producto {

    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double total = 0;
        double precioSinDescuento = super.calcular(cantidadDeProductos);
        switch (this.diasPorCaducar){
            case 1:
                total = precioSinDescuento * 0.25;
                break;
            case 2:
                total = precioSinDescuento * 0.333333;
                break;
            case 3:
                total = precioSinDescuento * 0.5;
                break;
            default:
                total = precioSinDescuento;
                break;
        }
        return total;
    }
}
