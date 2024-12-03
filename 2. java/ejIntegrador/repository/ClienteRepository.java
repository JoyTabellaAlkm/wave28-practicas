package ejIntegradores.ejIntegrador.repository;

import ejIntegradores.ejIntegrador.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClienteRepository implements CRUDRepository<Cliente>{

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void crear(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clientes;
    }

    @Override
    public Optional<Cliente> buscar(String dni) {
        List<Cliente> clientesBuscados = clientes.stream().filter(c -> c.getDni().equals(dni)).toList();

        if(clientesBuscados.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(clientesBuscados.getFirst());
        }
    }

    @Override
    public void eliminar(String dni) {
        this.clientes = clientes.stream()
                .filter(cliente -> !cliente.getDni().equals(dni))
                .toList();
    }

    @Override
    public void mostrarTodos() {
        clientes.forEach(cliente -> System.out.println(cliente.toString()));
    }
}
