package Model;

import Model.Cliente;

import java.util.List;

public class Factura {
    private Long id;
    private Cliente cliente;
    private List<Producto> productos;

    double totalCompra;

    public Factura(Long id, Cliente cliente, List<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        calcularTotal();
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", totalCompra=" + totalCompra +
                '}';
    }

    public double calcularTotal() {
        this.totalCompra = productos.stream()
                .mapToDouble(p -> p.getCostoUnitario() * p.getCantidadComprada())
                .sum();
        return totalCompra;
    }
}
