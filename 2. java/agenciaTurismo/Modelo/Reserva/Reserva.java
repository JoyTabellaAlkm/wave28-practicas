public class Reserva {
    private String detalle;
    private Double costo;

    public Reserva() {
    }

    public Reserva(String detalle, Double costo) {
        this.detalle = detalle;
        this.costo = costo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "detalle='" + detalle + '\'' +
                ", costo=" + costo +
                '}';
    }
}