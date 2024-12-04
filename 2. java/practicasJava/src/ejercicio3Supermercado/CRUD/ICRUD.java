package ejercicio3Supermercado.CRUD;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
    public void crearInstancia(T obj);
    public void eliminarInstancia(Long id);
    public void mostrarInstancias();
    public Optional<T> consultarInstancia(Long id);
    public List<T> consultarLista();
}
