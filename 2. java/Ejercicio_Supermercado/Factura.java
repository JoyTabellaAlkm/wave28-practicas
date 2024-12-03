import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

}
