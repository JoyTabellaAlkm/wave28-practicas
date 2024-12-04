public class Vehiculo {

    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;

    /**
     * Constructor de Vehiculo
     * @param unaVelocidad
     * @param unaAceleracion
     * @param unAnguloDeGiro
     * @param unaPatente
     * @param unPeso
     * @param ruedas
     */
    public Vehiculo(Double unaVelocidad, Double unaAceleracion, Double unAnguloDeGiro, String unaPatente, Double unPeso, Integer ruedas){
        this.velocidad = unaVelocidad;
        this.aceleracion = unaAceleracion;
        this.anguloDeGiro = unAnguloDeGiro;
        this.patente = unaPatente;
        this.peso = unPeso;
        this.ruedas = ruedas;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    @Override
    public int hashCode() {
        return patente.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof Vehiculo)){
            return false;
        }

        Vehiculo otroVehiculo = (Vehiculo) obj;

        return otroVehiculo.getPatente().equals(this.patente);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
