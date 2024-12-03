package Modelo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Cliente> clientes = new ArrayList<>();
    public Cliente findClientePorDNI(String dni){
        try{
            List<Cliente> cliente = clientes.stream().filter(c -> c.getDni().equals(dni)).toList();
            if(!cliente.isEmpty()){
                return cliente.get(0);
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }
    public List<Cliente> addCliente (Cliente cliente){
        clientes.add(cliente);
        return clientes;
    }
}
