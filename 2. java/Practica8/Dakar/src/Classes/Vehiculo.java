package Classes;

import java.util.Objects;

public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private int anguloDeGiro;
    private String patente;
    private int peso;
    private int ruedas;

    // Constructor
    public Vehiculo(double velocidad, double aceleracion, int anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    // Getters y Setters
    public double getVelocidad() {return velocidad;}
    public void setVelocidad(double velocidad) {this.velocidad = velocidad;}

    public double getAceleracion() {return aceleracion;}
    public void setAceleracion(double aceleracion) {this.aceleracion = aceleracion;}

    public int getAnguloDeGiro() {return anguloDeGiro;}
    public void setAnguloDeGiro(int anguloDeGiro) {this.anguloDeGiro = anguloDeGiro;}

    public String getPatente() {return patente;}
    public void setPatente(String patente) {this.patente = patente;}

    public int getPeso() {return peso;}
    public void setPeso(int peso) {this.peso = peso;}

    public int getRuedas() {return ruedas;}
    public void setRuedas(int ruedas) {this.ruedas = ruedas;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(patente, vehiculo.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(patente);
    }

    // Methods
    public double calculaValor(){
        double valor = (velocidad * (0.5 * aceleracion)) / (anguloDeGiro * (peso-ruedas * 100));
        System.out.println("Valor para: " + patente + " es " + valor);
        return valor;
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
