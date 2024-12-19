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

         if (clienteEncontrado.isEmpty()){
             throw  new IllegalArgumentException("Usuario no encontrado");
         }

        return clienteEncontrado.get();
    }

    public String crearCliente (Cliente cliente){
        clientes.add(cliente);
        return "Cliente creado correctamente.";
    }

    public String eliminarCliente(Cliente cliente){
        clientes.remove(cliente);
        return  "Cliente eliminado correctamente";
    }

}
