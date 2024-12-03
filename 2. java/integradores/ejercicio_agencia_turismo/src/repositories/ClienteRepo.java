package repositories;

import classes.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepo {
    private List<Cliente> clientes = new ArrayList<>();

    public void guardar(Cliente c) {
        clientes.add(c);
    }

    public void eliminar(Cliente c) {
        clientes.remove(c);
    }

    //static public  encontrarPorId
}
