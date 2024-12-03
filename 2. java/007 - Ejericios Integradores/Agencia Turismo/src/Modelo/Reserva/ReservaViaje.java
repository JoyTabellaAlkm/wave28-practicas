package Modelo;

public class ReservaViaje extends Reserva{
    private String medioViaje;

    public ReservaViaje(String medioViaje) {
        this.medioViaje = medioViaje;
    }

    public ReservaViaje(String detalle, Double costo, String medioViaje) {
        super(detalle, costo);
        this.medioViaje = medioViaje;
    }

    public String getMedioViaje() {
        return medioViaje;
    }

    public void setMedioViaje(String medioViaje) {
        this.medioViaje = medioViaje;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ReservaViaje{" +
                "medioViaje='" + medioViaje + '\'' +
                '}';
    }
}
