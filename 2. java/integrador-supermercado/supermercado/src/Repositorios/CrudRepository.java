package Repositorios;

public interface CrudRepository <T>{

    public void crear(T objeto);
    void mostrarInformacion();
    public void consultar(Long id);

    public void eliminar(Long id);
}
