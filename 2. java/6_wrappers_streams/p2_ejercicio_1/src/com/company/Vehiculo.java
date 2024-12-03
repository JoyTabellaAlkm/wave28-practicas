package com.company;

public class Vehiculo {
    String moldelo;
    String marca;
    double costo;

    public Vehiculo(String moldelo, String marca, double costo) {
        this.moldelo = moldelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getMoldelo() {
        return moldelo;
    }

    public void setMoldelo(String moldelo) {
        this.moldelo = moldelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "moldelo='" + moldelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }
}
