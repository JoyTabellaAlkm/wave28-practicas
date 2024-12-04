import java.util.ArrayList;
import java.util.List;

public class ClientesCRUD implements CRUD<Clientes>{

    private List<Clientes> allClientes = new ArrayList<>();

    @Override
    public void crear(Clientes cliente) {
        allClientes.add(cliente);
    }

    @Override
    public Clientes leer(Clientes cliente) {
     return this.allClientes.stream()
             .filter(x -> x.getDni().equals(cliente.getDni()))
             .findFirst()
             .orElse(null);
    }

    @Override
    public void actualizar(Clientes clientes) {

    }

    @Override
    public void eliminar(Clientes String) {

    }

    @Override
    public List<Clientes> listar() {
        return this.allClientes;
    }
}
