public abstract class Vehiculo {
    private int velocidad, aceleracion, ruedas;
    private double anguloDeGiro, peso;
    private String patente;

    public Vehiculo(int velocidad, int aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "Velocidad=" + velocidad +
                ", Aceleracion=" + aceleracion +
                ", AnguloDeGiro=" + anguloDeGiro +
                ", Patente='" + patente + '\'' +
                ", Peso=" + peso +
                ", Ruedas=" + ruedas +
                '}';
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public double getPeso() {
        return peso;
    }

    public int getRuedas() {
        return ruedas;
    }
}
