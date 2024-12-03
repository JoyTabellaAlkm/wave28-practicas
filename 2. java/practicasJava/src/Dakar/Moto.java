package Dakar;

public class Moto extends Vehiculo {

    public Moto() {
    }

    public Moto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
        peso = 300.0;
        ruedas = 2;


    }
}
