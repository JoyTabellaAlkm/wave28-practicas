package ejIntegradores.ejIntegrador.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository <T> {
    public void crear(T objeto);
    public List<T> buscarTodos();
    public Optional<T> buscar(String identificador);
    public void eliminar(String identificador);
    public void mostrarTodos();
}
