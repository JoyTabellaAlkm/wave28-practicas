package integrador.data;

import java.util.List;

public interface CRUD<T> {
    void guardar(T t);
    void eliminar(T t);
    void actualizar(T t);
    List<T> obtenerTodos();
}
