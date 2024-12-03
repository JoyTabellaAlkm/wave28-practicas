import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Supermercado {
    List<Factura> facturas;
    List<Item> items;
    List<Cliente> clientes;

    public Supermercado() {
        this.facturas = new ArrayList<>();
        this.items = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void crearFactura(Factura factura) {
        if (!existeCliente(factura.getCliente())) {
            throw new IllegalArgumentException("El cliente asociado a la factura no esta registrado, asigne uno válido");
        }
        facturas.add(factura);
    }

    public boolean existeCliente(Cliente cliente) {
        return clientes.contains(cliente);
    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }


}