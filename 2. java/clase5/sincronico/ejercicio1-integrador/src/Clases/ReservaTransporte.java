package Clases;

import java.util.Date;

public class ReservaTransporte extends Reserva{
    private String tipoTransporte;

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public ReservaTransporte(Date fechaInicio, Date fechaFin, double costo, String tipoTransporte) {
        super(fechaInicio, fechaFin, costo);
        this.tipoTransporte = tipoTransporte;
    }
}
