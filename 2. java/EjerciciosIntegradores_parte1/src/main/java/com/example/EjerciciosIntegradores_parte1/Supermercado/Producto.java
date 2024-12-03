package com.example.EjerciciosIntegradores_parte1.Supermercado;

public class Producto {
    public String codigo;
    public String nombre;
    public int cantComprada;
    private Double costoUnitario;
    private Double costoTotal;

    public Producto(String codigo, String nombre, int cantComprada, Double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantComprada = cantComprada;
        this.costoUnitario = costoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
    public Double setCostoTotal(){
        return costoUnitario*cantComprada;
    }

}
