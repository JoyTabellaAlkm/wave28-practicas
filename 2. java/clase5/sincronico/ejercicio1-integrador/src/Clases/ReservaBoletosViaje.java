package Clases;

import java.util.Date;

public class ReservaBoletosViaje extends Reserva {
    private String aerolinea;
    private int numeroBoleto;

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public int getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(int numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public ReservaBoletosViaje(String aerolinea, int numeroBoleto, Date fechaInicio, Date fechaFin, double costo) {
        super(fechaInicio,fechaFin,costo);
        this.aerolinea = aerolinea;
        this.numeroBoleto = numeroBoleto;
    }
}
