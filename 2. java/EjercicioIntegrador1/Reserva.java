public class Reserva {
    private double costo;
    private String tipo;
    public Reserva(double costo, String tipo) {
        this.costo = costo;
        this.tipo = tipo;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Reserva [costo=" + costo + ", tipo=" + tipo + "]";
    }

}