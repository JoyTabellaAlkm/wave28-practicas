package com.mercadolibre;

public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public  Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas){
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }


    public double getAceleracion() {
        return aceleracion;
    }

    public double getPeso() {
        return peso;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public int getRuedas() {
        return ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public double calcularVelocidad(){
        double velocidad = (this.getVelocidad()*(this.getAceleracion()*0.5))/(this.getAnguloDeGiro()*(this.getPeso()-(this.getRuedas()*100)));
        return velocidad;
    }
}
