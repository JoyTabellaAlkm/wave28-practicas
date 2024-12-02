package com.mercadolibre;

public class Vehiculo {

    private String modelo;
    private String marca;
    private int costos;

    public Vehiculo(String modelo, String marca, int costos) {
        this.modelo = modelo;
        this.marca = marca;
        this.costos = costos;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCostos() {
        return costos;
    }

    public void setCostos(int costos) {
        this.costos = costos;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costos=" + costos +
                '}';
    }
}