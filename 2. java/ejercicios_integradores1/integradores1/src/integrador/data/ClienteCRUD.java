package integrador.data;

import integrador.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD implements CRUD<Cliente> {

    private static ClienteCRUD INSTANCE;
    private List<Cliente> clientes = new ArrayList<>();

    private ClienteCRUD(){}

    public static ClienteCRUD getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ClienteCRUD();
        return INSTANCE;
    }

    @Override
    public void guardar(Cliente cliente) {
        if(clientes.contains(cliente)) {
            System.out.println("CLIENTE YA EXISTENTE");
            return;
        }
        clientes.add(cliente);
    }

    @Override
    public void eliminar(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        } else {
            clientes.get(clientes.indexOf(cliente)).setApellido(cliente.getApellido());
            clientes.get(clientes.indexOf(cliente)).setNombre(cliente.getNombre());
        }
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return new ArrayList<>(clientes);
    }
}
