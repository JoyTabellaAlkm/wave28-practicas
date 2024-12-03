package Modelo;

public class Moto extends Vehiculo{
    public Moto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, 300.00, patente, 2);
    }

    public Moto() {
    }
}
