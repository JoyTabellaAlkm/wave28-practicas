import java.util.List;

public class Factura {
    Cliente cliente;
    List<Item> listaItems;
    double totalCompra;
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
    public void setTotalCompra() {
        this.totalCompra = listaItems.stream().mapToDouble(item -> item.getCostoUnitario()*item.getCantidadComprada()).sum();
    }
    public Factura(Cliente cliente, List<Item> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = listaItems.stream().mapToDouble(item -> item.getCostoUnitario()*item.getCantidadComprada()).sum();
    }
    @Override
    public String toString() {
        return "Factura [cliente=" + cliente + ", listaItems=" + listaItems + ", totalCompra=" + totalCompra + "]";
    }
    
}
