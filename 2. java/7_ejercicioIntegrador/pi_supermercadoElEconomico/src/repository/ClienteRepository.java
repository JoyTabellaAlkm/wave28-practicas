package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {

    public List<Cliente> clientes = new ArrayList<>();


    public List<Cliente> obtenerClientes(){
        return clientes;
    }


    public Cliente buscarClientePorDNI(Integer dni){

         Optional<Cliente> clienteEncontrado = clientes.stream()
                                                       .filter(cliente -> cliente.getDni().equals(dni))
                                                       .findFirst();

        return clienteEncontrado.orElse(null);

    }

    public void crearCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente){
        clientes.remove(cliente);
    }

}
