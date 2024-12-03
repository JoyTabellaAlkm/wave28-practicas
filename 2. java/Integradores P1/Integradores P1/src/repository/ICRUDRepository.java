package repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
public interface ICRUDRepository<T> {

    public void save(T objeto);
    public void mostrarPantalla();
    public Optional<T> buscar(Long id);
    public List<T> traerTodos();
    public void eliminar(Long id);
}
