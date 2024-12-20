package model;

import repository.ClienteRepository;

import java.util.List;
import java.util.stream.DoubleStream;

public class Factura {
    Cliente cliente;
    List<Item> items;
    Double totalCompra;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        ClienteRepository clienteRepository = new ClienteRepository();

        if (clienteRepository.buscarClientePorDNI(cliente.getDni()) == null){
            clienteRepository.crearCliente(cliente);
        }
        this.items = items;
        calcularCosto();
    }

    private void calcularCosto(){
        totalCompra = items.stream()
                           .flatMapToDouble(item -> DoubleStream.of(item.getCantidadComprada() * item.getCostoUnitario())).sum();
    }


    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
