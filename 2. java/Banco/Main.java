
import java.util.ArrayList;
import java.util.List;

import clientes.Basic;
import clientes.Cliente;
import clientes.Cobradores;
import clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Ejecutivo());
        clientes.add(new Basic());
        clientes.add(new Cobradores());

        for (Cliente cliente : clientes) {
            cliente.realizarTransacciones();
        }
    }
}