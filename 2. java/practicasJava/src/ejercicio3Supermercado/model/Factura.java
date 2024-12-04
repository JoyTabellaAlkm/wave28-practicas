package ejercicio3Supermercado.model;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> listaItems;
    private int totalCompra;

    public Factura(Cliente cliente, List<Producto> listaItems, int totalCompra) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Producto> listaItems) {
        this.listaItems = listaItems;
    }

    public int getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra +
                '}';
    }

}
