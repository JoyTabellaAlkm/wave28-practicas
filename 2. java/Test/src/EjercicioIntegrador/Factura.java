package EjercicioIntegrador;

import java.util.List;

public class Factura {
    Cliente cliente;
    List<Item> items;
    Double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = getTotal();
    }

    public Double getTotal() {
        return this.items.stream().mapToDouble(item->item.getCantidad()*item.getCosto()).sum();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
