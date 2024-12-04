import java.util.List;

public interface CRUD <T> {
    public void crear(T Objet);

    public T leer(T Objet);

    public void actualizar(T Objet);

    public void eliminar(T String);

    List<T> listar();
}
