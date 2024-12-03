package repositories;

import java.util.List;

public interface ICrud<T> {

    public void guardar(T props);
    public T buscar(int id);
    public List<T> buscartodos();
    public void eliminar(int props);

}
