import java.util.HashMap;
import java.util.Map;

public class ClienteCRUD implements ICRUD<Cliente> {

    Map<Long, Cliente> bd = new HashMap<>();

    @Override
    public void create(Long id, Cliente cliente) {
        if (bd.containsKey(id)) {
            throw new IllegalArgumentException("Cliente con ID " + id + " ya existe.");
        }
        bd.put(id, cliente);
    }

    @Override
    public Cliente read(Long id) {
        try {
            if (!bd.containsKey(id)) {
                throw new IllegalArgumentException("Cliente con ID " + id + " no encontrado.");
            }
            System.out.println("Cliente encontrado: "+ bd.get(id));
            return bd.get(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null; // Retornar null si ocurre la excepción
        }
    }
    

    @Override
    public void update(Long id, Cliente clienteActualizado) {
        if (!bd.containsKey(id)) {
            throw new IllegalArgumentException("Cliente con ID " + id + " no encontrado para actualizar.");
        }
        bd.put(id, clienteActualizado);
    }

    @Override
    public void delete(Long id) {
        if (bd.remove(id) == null) {
            throw new IllegalArgumentException("Cliente con ID " + id + " no encontrado para eliminar.");
        }
    }
}
