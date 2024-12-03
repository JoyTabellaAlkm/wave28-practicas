package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    List<Cliente> clientes = new ArrayList<>();

    public void agregar(Cliente cliente) {
        clientes.add(cliente);
    }
}