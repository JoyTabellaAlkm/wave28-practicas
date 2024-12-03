package ejercicios.integradores.Supermercado.implementaciones;

import ejercicios.integradores.Supermercado.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUD{
    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Object objeto) {
        clientes.add((Cliente)objeto);
    }

    @Override
    public void mostrar() {
        for (Cliente cli : clientes){
            System.out.println(cli);
        }
    }

    @Override
    public Optional<Cliente> buscar(Long id) {
        return clientes.stream().filter(x -> x.getDni() == id).findFirst();
    }

    @Override
    public void eliminar(Long id) {
        clientes.removeIf(x -> x.getDni()==id);
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }
}
