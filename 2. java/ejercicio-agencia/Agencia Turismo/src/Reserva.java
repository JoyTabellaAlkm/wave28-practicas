public class Reserva {
    private TipoReserva tipo;
    private double costo;

    public Reserva(TipoReserva tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public Reserva setTipo(TipoReserva tipo) {
        this.tipo = tipo;
        return this;
    }

    public double getCosto() {
        return costo;
    }

    public Reserva setCosto(double costo) {
        this.costo = costo;
        return this;
    }
}
