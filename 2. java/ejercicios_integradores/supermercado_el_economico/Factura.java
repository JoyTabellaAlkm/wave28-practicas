package ejercicios_integradores.supermercado_el_economico;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Integer id;
    private Cliente cliente;
    private List<Item> itemList;
    private Double total;
    private static int TOTAL_FACTURAS = 0;

    public Factura(Cliente cliente) {
        this.id = TOTAL_FACTURAS;
        this.cliente = cliente;
        this.itemList = new ArrayList<>();
        this.total = 0.0;
        TOTAL_FACTURAS++;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void agregarItem(Item item) {
        this.itemList.add(item);
    }

    public void removerItem(Item item) {
        this.itemList.remove(item);
    }

    public void removerItem(int index) {
        this.itemList.remove(index);
    }

    public Double getTotal() {
        this.actualizarTotal();
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void actualizarTotal() {
        this.total = this.itemList.stream().mapToDouble(Item::getCosto).sum();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", itemList=" + itemList +
                ", total=" + this.getTotal() +
                '}';
    }
}
