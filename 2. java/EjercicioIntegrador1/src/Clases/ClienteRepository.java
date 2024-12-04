package Clases;

import Interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements IRepository<Cliente> {
    private List<Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public Cliente buscarPorCodigo(int dni) {
        return clientes.stream()
                .filter(cliente -> cliente.getDni() == dni)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void crear(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void modificar(Cliente cliente) {
        Cliente clienteExistente = buscarPorCodigo(cliente.getDni());
        if (clienteExistente != null) {
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
        }
    }

    @Override
    public void eliminar(Cliente cliente) {
        clientes.removeIf(c -> c.getDni() == cliente.getDni());
    }
}
