import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = calcularCosto();
    }

    private double calcularCosto() {
        return this.items.
                stream().
                mapToDouble(Item::getCostoUnitario).
                sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getProductos() {
        return items;
    }

    public void setProductos(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", productos=" + items +
                ", total=" + total +
                '}';
    }
}
