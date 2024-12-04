package CRUD;

import Clases.Cliente;

import java.util.List;

public interface ICRUD <T> {

    public T create();
    public void delete(List<T> lista,int id);
    public T buscar(List<T> lista, int id);
    public void listarTodos(List<T> lista);

}
