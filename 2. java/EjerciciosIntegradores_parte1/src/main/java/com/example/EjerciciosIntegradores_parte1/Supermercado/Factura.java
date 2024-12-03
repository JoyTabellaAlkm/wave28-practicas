package com.example.EjerciciosIntegradores_parte1.Supermercado;

import java.util.List;
import java.util.stream.Collectors;

public class Factura {
    private Cliente cliente;
    private List<Producto> listaProductos;
    private Double totalCompra;

    public Factura(Cliente cliente, List<Producto> listaProductos) {
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        this.totalCompra = calcularTotalCompra();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaItems(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Double calcularTotalCompra(){
           Double montoTotal = listaProductos.stream().collect(Collectors.summingDouble(Producto::setCostoTotal));
           return montoTotal;
    }
}
