public class Comida extends Reserva{
    private int cantidadComidas;
    private double precioComida;

    public Comida(int cantidadComidas, double precioComida) {
        this.cantidadComidas = cantidadComidas;
        this.precioComida = precioComida;
        this.tipo = "COMIDA";
    }

    public int getCantidadComidas() {
        return cantidadComidas;
    }

    public void setCantidadComidas(int cantidadComidas) {
        this.cantidadComidas = cantidadComidas;
    }

    public double getPrecioComida() {
        return precioComida;
    }

    public void setPrecioComida(double precioComida) {
        this.precioComida = precioComida;
    }

    @Override
    public void calcularPrecio() {
        double total = cantidadComidas * precioComida;
        this.costoTotal = total;
    }
}
