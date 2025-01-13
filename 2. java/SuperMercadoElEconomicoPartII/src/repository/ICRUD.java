package repository;

import java.util.List;

public interface ICRUD<T> {
    void agregar(T objeto);
    void eliminar(Long id);
    T buscar(Long id);
    List<T> listar();
}
