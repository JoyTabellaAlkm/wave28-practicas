package Modelo;

public class Auto extends Vehiculo{
    public Auto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, 1000.00, patente, 4);
    }

    public Auto() {
    }
}
