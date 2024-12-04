package com.company.model;

import java.util.List;

public class Factura {
    private String codigo;
    private Cliente cleinte;
    private List<Producto> listaProductos;
    private double total;

    public Factura(String codigo, Cliente cleinte, List<Producto> listaProductos, double total) {
        this.codigo = codigo;
        this.cleinte = cleinte;
        this.listaProductos = listaProductos;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCleinte() {
        return cleinte;
    }

    public void setCleinte(Cliente cleinte) {
        this.cleinte = cleinte;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
