package Dakar;

public class Auto extends Vehiculo{


    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        peso = 1000;
        ruedas = 4;
    }
}
