package Repository;

import Model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements IRepository<Cliente> {

    private final List<Cliente> listaClientes;

    public RepositorioCliente() {
        this.listaClientes = new ArrayList<>();
    }

    @Override
    public List<Cliente> getAll() {
        return this.listaClientes;
    }

    @Override
    public Cliente getOne(String dni) {
        for(Cliente cliente: listaClientes) {
            if(dni.equals(cliente.getDni())) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void create(Cliente c) {
        this.listaClientes.add(c);
    }

    @Override
    public void delete(String dni) {
        listaClientes.removeIf(cliente -> dni.equals(cliente.getDni()));
    }
}
