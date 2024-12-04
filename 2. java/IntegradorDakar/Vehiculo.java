public abstract class Vehiculo {

    private double velocidad;
    private double aceleracion;
    private double anguloGiro;
    private String patente;
    private double peso;
    private int cantidadRuedas;

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloGiro=" + anguloGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", cantidadRuedas=" + cantidadRuedas +
                '}';
    }

    public Vehiculo(double velocidad, double aceleracion, double anguloGiro, String patente, double peso, int cantidadRuedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.cantidadRuedas = cantidadRuedas;
    }

    public double getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    public double getAceleracion() {
        return aceleracion;
    }
    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }
    public double getAnguloGiro() {
        return anguloGiro;
    }
    public void setAnguloGiro(double anguloGiro) {
        this.anguloGiro = anguloGiro;
    }
    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getCantidadRuedas() {
        return cantidadRuedas;
    }
    public void setCantidadRuedas(int cantidadRuedas) {
        this.cantidadRuedas = cantidadRuedas;
    }
}
