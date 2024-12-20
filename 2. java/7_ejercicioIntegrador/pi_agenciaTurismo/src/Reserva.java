public class Reserva {
    private String tipo;
    private double costo;

    public Reserva(String tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }
}
