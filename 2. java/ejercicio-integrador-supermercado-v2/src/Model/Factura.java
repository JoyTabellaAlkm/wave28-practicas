package Model;

import java.util.List;

public class Factura {

    private String id;

    private Cliente cliente;

    private List<Item> listaItems;

    private double totalCompra;

    public Factura(String id, Cliente cliente, List<Item> listaItems) {
        this.id = id;
        this.cliente = cliente;
        this.listaItems = listaItems;
        calcularTotal();
    }

    private void calcularTotal() {
        double total = 0.0;
        for(Item item: listaItems) {
            total += item.getCostoUnitario() * item.getCantidadComprada();
        }
        this.totalCompra = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
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
