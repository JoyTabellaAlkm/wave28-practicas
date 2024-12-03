package ejercicios_integradores.supermercado_el_economico;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> itemList;
    private Double total;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.total = 0.0;
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
