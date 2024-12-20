import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {
    private List<Cliente> clientes;

    public ClienteRepositorio() {
        this.clientes = new ArrayList<>();
    }

    public Cliente buscarCliente(Integer dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente agregarCliente(Integer dni, String nombre) {
        Cliente nuevoCliente = new Cliente(dni, nombre);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }
}
