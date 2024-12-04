public class Hotel extends Reserva{
    private int cantidadDias;
    private double precioDia;

    public Hotel(int cantidadDias, double precioDia) {
        this.cantidadDias = cantidadDias;
        this.precioDia = precioDia;
        this.tipo = "HOTEL";
    }

    @Override
    public void calcularPrecio() {
        double total = cantidadDias * precioDia;
        this.costoTotal = total;
    }


}
