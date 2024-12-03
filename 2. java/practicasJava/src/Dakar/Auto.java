package Dakar;

public class Auto extends Vehiculo{

    public Auto() {
    }

    public Auto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
        peso = 1000.0;
        ruedas = 4;


    }
}
