import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        recalcularTotalCompra();
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

    public void agregarItem(Item item){
        this.items.add(item);
        recalcularTotalCompra();
    }

    public void recalcularTotalCompra() {
        this.totalCompra = items.stream()
                .mapToDouble(Item::getMontoTotal)
                .sum();
    }

}
