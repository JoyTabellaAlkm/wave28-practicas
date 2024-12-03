public class Reserva {
    private TiposReserva tipo;
    private double precio;

    public Reserva(TiposReserva tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public TiposReserva getTipo() {
        return tipo;
    }

    public void setTipo(TiposReserva tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombre='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
