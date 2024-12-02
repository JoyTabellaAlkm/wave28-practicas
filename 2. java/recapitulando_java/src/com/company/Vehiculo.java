package com.company;

public class Vehiculo {
    private String modelo;
    private String marca;
    private int precio;

    public Vehiculo(String modelo, String marca, int precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca.toLowerCase();
    }

    public int getPrecio() {
        return precio;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return ("marca=" + marca +" precio=" + precio);
    }
}