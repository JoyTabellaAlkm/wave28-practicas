package org.example;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Items> listaItems;
    private int total;

    public Factura(Cliente cliente, List<Items> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Items> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Items> listaItems) {
        this.listaItems = listaItems;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", total=" + total +
                '}';
    }
}
