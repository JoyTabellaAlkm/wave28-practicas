package Clases;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> carrito;
    private double totalCompra;

    public Factura(Cliente cliente, List<Item> carrito, double totalCompra) {
        this.cliente = cliente;
        this.carrito = carrito;
        this.totalCompra = totalCompra;
    }

    public Factura() {
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Item> getCarrito() {
        return carrito;
    }
    public void setCarrito(List<Item> carrito) {
        this.carrito = carrito;
    }
    public double getTotalCompra() {
        return totalCompra;
    }
    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", carrito=" + carrito +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
