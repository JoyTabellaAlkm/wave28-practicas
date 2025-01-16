package org.example.ejercicio_practico_opcional.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrendaDTO {
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("marca")
    private String marca;

    @JsonProperty("color")
    private String color;

    @JsonProperty("talle")
    private String talle;

    @JsonProperty("cantidad")
    private int cantidad;

    @JsonProperty("precio_venta")
    private double precio_venta;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
}