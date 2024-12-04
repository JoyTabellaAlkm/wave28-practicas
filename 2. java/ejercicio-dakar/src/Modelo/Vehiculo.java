package Modelo;

public class Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Double anguloGiro;
    private Double peso;
    private String patente;
    private Integer ruedas;

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloGiro, Double peso, String patente, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.peso = peso;
        this.patente = patente;
        this.ruedas = ruedas;
    }

    public Vehiculo() {
    }

    public Double calcularLlegada(){
        return velocidad*aceleracion*0.5/(anguloGiro*(peso-ruedas*100));
    }
    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Double getAnguloGiro() {
        return anguloGiro;
    }

    public void setAnguloGiro(Double anguloGiro) {
        this.anguloGiro = anguloGiro;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }
}
