package ejercicios.integradores.Supermercado.implementaciones;

import java.util.List;
import java.util.Optional;

public interface CRUD <T>{
    public void save(T objeto);
    public void mostrar();
    public Optional<T> buscar (Long id);
    public void eliminar (Long id);
    public List<T> listar();
}
