public class Perecedero extends Producto {

    private int diasxCaducar;

    public Perecedero(String nombre, double precio, int diasxCaducar) {
        super(nombre, precio);
        this.diasxCaducar = diasxCaducar;
    }

    public int getDiasxCaducar() {
        return diasxCaducar;
    }

    public void setDiasxCaducar(int diasxCaducar) {
        this.diasxCaducar = diasxCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasxCaducar=" + diasxCaducar +
                '}';
    }

    @Override
    public double calcular(int cantProductos) {
        double descuento = 1;
        switch (diasxCaducar) {
            case 1:
                descuento = 0.25;
                break;
            case 2:
                descuento = 0.33;
                break;
            case 3:
                descuento = 0.5;
                break;
        }

        return super.calcular(cantProductos) * descuento;
    }
}