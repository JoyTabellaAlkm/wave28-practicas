package Interfaces;

import java.util.List;

public interface IRepository<T> {
    T buscarPorCodigo(int codigo);
    void crear(T t);
    void modificar(T t);
    void eliminar(T t);
}
