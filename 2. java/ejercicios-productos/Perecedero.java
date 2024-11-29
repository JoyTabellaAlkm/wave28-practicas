public class Perecedero extends Producto {
    private int diasPorCalcular;

    public Perecedero(String nombre, double precio, int diasPorCalcular) {
        super(nombre, precio);
        this.diasPorCalcular = diasPorCalcular;
    }

    public Perecedero setDiasPorCalcular(int diasPorCalcular) {
        this.diasPorCalcular = diasPorCalcular;
        return this;
    }

    public int getDiasPorCalcular() {
        return diasPorCalcular;
    }

    @Override
    public double calcular(int cantidadProductos) {
        double precioBase = super.calcular(cantidadProductos);
        switch (diasPorCalcular) {
            case 1:
                return precioBase * 0.25;
            case 2:
                return precioBase  * 0.33;
            case 3:
                return precioBase  * 0.5;
            default:
                return precioBase;
        }
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCalcular=" + diasPorCalcular +
                '}';
    }
}
