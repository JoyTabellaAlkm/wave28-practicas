package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteImp implements ICRUD<Cliente> {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void agregar(Cliente cliente){

        clientes.add(cliente);
    }

    @Override
    public void eliminar(Long dni){

        clientes.removeIf(cliente -> cliente.getDni().equals(dni));
    }

    @Override
    public Cliente buscar(Long dni){
        return clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst().orElse(null);
    }

    @Override
    public List<Cliente> listar(){

        return clientes;
    }
}
