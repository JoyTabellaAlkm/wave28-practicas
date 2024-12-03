package Clases;

import java.util.Date;

public class ReservaHotel extends Reserva{
    private String nombreHotel;

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public ReservaHotel(Date fechaInicio, Date fechaFin, double costo, String nombreHotel) {
        super(fechaInicio, fechaFin, costo);
        this.nombreHotel = nombreHotel;
    }
}
