package repositorios;

import clases.Cliente;

import java.util.List;

public class RepositorioCliente {

    private static List<Cliente> clientes;

    public RepositorioCliente(List<Cliente> clientesLista) {
        clientes = clientesLista;
    }

    public static Cliente encontrarPorDNI(int dni) {
        return clientes.stream().filter(cliente -> cliente.getDni() == dni).toList().getFirst();
    }

    public void guardar(Cliente c) {
        clientes.add(c);
    }

    public void eliminar(Cliente c) {
        clientes.remove(c);
    }

}
