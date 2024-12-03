package Supermercado;

import java.util.List;

public class Factura {
   private Cliente cliente;
   private List<Item> listaItem;
   private double totalCompra;

    public Factura(Cliente cliente, List<Item> listaItem) {
        this.cliente = cliente;
        this.listaItem = listaItem;
        this.totalCompra = listaItem.stream()
                .mapToDouble(f -> f.getPrecioTotal())
                .sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItem() {
        return listaItem;
    }

    public void setListaItem(List<Item> listaItem) {
        this.listaItem = listaItem;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public void agregarItem(Item item){
        listaItem.add(item);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItem=" + listaItem +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
