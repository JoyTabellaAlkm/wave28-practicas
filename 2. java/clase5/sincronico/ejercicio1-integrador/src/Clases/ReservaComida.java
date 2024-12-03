package Clases;

import java.util.Date;

public class ReservaComida extends Reserva{
    private boolean desayuno;
    private boolean almuerzo;
    private boolean cena;

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public boolean isAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(boolean almuerzo) {
        this.almuerzo = almuerzo;
    }

    public boolean isCena() {
        return cena;
    }

    public void setCena(boolean cena) {
        this.cena = cena;
    }

    public ReservaComida(Date fechaInicio, Date fechaFin, double costo, boolean desayuno, boolean almuerzo, boolean cena) {
        super(fechaInicio, fechaFin, costo);
        this.desayuno = desayuno;
        this.almuerzo = almuerzo;
        this.cena = cena;
    }
}
