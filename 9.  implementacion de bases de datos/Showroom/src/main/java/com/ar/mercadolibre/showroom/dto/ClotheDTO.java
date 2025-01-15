package com.ar.mercadolibre.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class ClotheDTO {

    private Long codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talla;
    private int cantidad;
    @JsonProperty("precio_venta")
    private double precioVenta;

    public ClotheDTO() {
    }

    public ClotheDTO(Long codigo, String nombre, String tipo, String marca, String color, String talla, int cantidad, double precioVenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

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

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
