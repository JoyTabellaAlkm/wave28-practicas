public class Transporte extends Reserva{
    private double precioViaje;

    public Transporte(double precioViaje) {
        this.precioViaje = precioViaje;
        this.tipo = "TRANSPORTE";
    }

    public double getPrecioViaje() {
        return precioViaje;
    }

    public void setPrecioViaje(double precioViaje) {
        this.precioViaje = precioViaje;
    }

    @Override
    public void calcularPrecio() {
        this.costoTotal = precioViaje;
    }
}
