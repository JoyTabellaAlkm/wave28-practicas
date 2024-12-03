package ejIntegradores.ejIntegrador.repository;

import ejIntegradores.ejIntegrador.model.Cliente;
import ejIntegradores.ejIntegrador.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaRepository implements CRUDRepository<Factura>{

    List<Factura> facturas = new ArrayList<>();
    private ClienteRepository clienteRepository;

    public FacturaRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void crear(Factura factura) {
        Optional<Cliente> cliente = clienteRepository.buscar(factura.getCliente().getDni());
        boolean clienteOk = true, itemsOk = true;
        if(cliente.isEmpty()) {
            System.out.println("No se pudo agregar la factura porque no existe el cliente en el listado");
            clienteOk = false;
        }

        if(factura.getItems().isEmpty()) {
            System.out.println("No se pudo agregar la factura porque no tiene items");
            itemsOk = false;
        }

        if(itemsOk && clienteOk) {
            double totalFactura = factura.getItems()
                    .stream()
                    .mapToDouble(fac -> fac.getCantidadComprada() * fac.getCostoUnitario())
                    .sum();
            factura.setTotalFactura(totalFactura);
            facturas.add(factura);
        }
    }

    @Override
    public List<Factura> buscarTodos() {
       return facturas;
    }

    @Override
    public Optional<Factura> buscar(String codigo) {
        List<Factura> facturaBuscadas = facturas.stream().filter(c -> c.getCodigo().equals(codigo)).toList();

        if(facturaBuscadas.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(facturaBuscadas.getFirst());
        }
    }

    @Override
    public void eliminar(String codigo) {
        this.facturas = facturas.stream()
                .filter(factura -> !factura.getCodigo().equals(codigo))
                .toList();

    }

    @Override
    public void mostrarTodos() {
        facturas.forEach(factura -> System.out.println(factura.toString()));
    }
}
