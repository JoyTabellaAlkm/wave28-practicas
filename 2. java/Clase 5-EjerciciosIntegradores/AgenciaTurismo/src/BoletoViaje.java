public class BoletoViaje extends Reserva{
    private double precioViaje;

    public BoletoViaje(double precioViaje) {
        this.precioViaje = precioViaje;
        this.tipo = "BOLETO DE VIAJE";
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
