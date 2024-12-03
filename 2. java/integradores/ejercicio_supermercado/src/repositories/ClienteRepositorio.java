package repositories;

import classes.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio implements ICrud<Cliente>{
    List<Cliente> listaClientes = new ArrayList<>();

    @Override
    public void guardar(Cliente props) {
        listaClientes.add(props);
    }

    @Override
    public Cliente buscar(int id) {
        Cliente cliente =
                listaClientes.stream().filter(cli -> cli.getDni() == id).toList().getFirst();
        if (cliente == null){
            throw new RuntimeException("Cliente no encontrado");
        }
        return cliente;
    }

    @Override
    public List<Cliente> buscartodos() {
        return listaClientes;
    }

    @Override
    public void eliminar(int id) {
        boolean encontrado = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni() == id) {
                listaClientes.remove(cliente);
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

}
