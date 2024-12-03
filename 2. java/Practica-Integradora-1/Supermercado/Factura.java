package com.ejemplo;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = this.calcularTotal(items);
    }

    private double calcularTotal(List<Item> items) {
        return items.stream().mapToDouble(item -> item.calcularCostoTotal()).sum();
    }

    @Override
    public String toString() {
        return "Factura [cliente=" + cliente + ", items=" + items + ", total=" + total + "]";
    }
}
