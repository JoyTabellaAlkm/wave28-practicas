package ejercicios.integradores.Supermercado.modelo;

import java.util.ArrayList;
import java.util.List;

public class Facturas {
    private int id;
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Facturas(Cliente cliente, int id) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void agregarItemsLista(List<Item> item){
        this.items = item;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void calcularFactura(){
        this.total = items.stream().mapToDouble(Item::getCosto).sum();

    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return STR."Facturas{cliente=\{cliente}, items=\{items}, total=\{total}}";
    }
}
