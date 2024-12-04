package Classes;

public class Auto extends Vehiculo{
    public Auto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }

    @Override
    public String toString() {
        return "Auto{} " + super.toString();
    }
}
