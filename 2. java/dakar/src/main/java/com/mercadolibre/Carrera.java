package com.mercadolibre;

import java.util.Comparator;
import java.util.List;

public class Carrera {
    private String nombre;
    private double distancia;
    private double premioEnDolares;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(String nombre, double distancia, double premioEnDolares, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos){
        this.nombre = nombre;
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion,double anguloDeGiro,String patente){
        if (this.cantidadDeVehiculosPermitidos >= this.vehiculos.size()){
            this.vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion,double anguloDeGiro,String patente){
        if (this.cantidadDeVehiculosPermitidos >= this.vehiculos.size()){
            this.vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }
    public void eliminarVehiculo(Vehiculo vehículo){
        this.vehiculos = this.vehiculos.stream().filter((v)-> !v.equals(vehículo)).toList();
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        this.vehiculos = this.vehiculos.stream().filter((v)-> !v.getPatente().equals(unaPatente)).toList();
    }

    public Vehiculo winner(){
        return this.vehiculos.stream().max(Comparator.comparing(Vehiculo::calcularVelocidad)).orElse(null);
    }

    public void socorrerAuto(String patente) {
        Vehiculo auto = this.vehiculos.stream().filter(v-> v.getPatente().equals(patente)).findFirst().orElse(null);
        socorristaAuto.socorrer((Auto) auto);
    }

    public void socorrerMoto(String patente){
        Vehiculo auto = this.vehiculos.stream().filter(v-> v.getPatente().equals(patente)).findFirst().orElse(null);
        socorristaMoto.socorrer((Moto) auto);
    }
}
