package clases;

import interfaces.ICrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrudCliente implements ICrud<Cliente, Integer> {

    private List<Cliente> clientes;

    public CrudCliente() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public Cliente create(Cliente cliente) throws Exception {
        Cliente clienteEncontrado = this.get(cliente.getDni());
        if(clienteEncontrado != null) {
            throw new Exception("El cliente ya existe en el repositorio");
        }
        this.clientes.add(cliente);
        return cliente;
    }

    @Override
    public Cliente delete(Integer id) throws Exception {
        Optional<Cliente> cliente = this.clientes.stream().filter(cl -> cl.getDni() == id).findFirst();
        if(cliente.isEmpty()) {
            throw new Exception("Cliente no encontrado");
        }
        return cliente.get();
    }

    @Override
    public Cliente get(Integer dni) {
        Optional<Cliente> cliente = this.clientes.stream().filter(cl -> cl.getDni() == dni).findFirst();
        return cliente.orElse(null);

    }
}
