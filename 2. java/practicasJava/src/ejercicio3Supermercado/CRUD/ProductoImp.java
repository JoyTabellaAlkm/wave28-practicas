package ejercicio3Supermercado.CRUD;

import ejercicio3Supermercado.model.Producto;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ProductoImp implements ICRUD<Producto> {
    Set<Producto> productoSet = new HashSet<Producto>();
    @Override
    public void crearInstancia(Producto obj) {
        productoSet.add(obj);
    }

    @Override
    public void eliminarInstancia(Long id) {

    }

    @Override
    public void mostrarInstancias() {

    }

    @Override
    public Optional<Producto> consultarInstancia(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Producto> consultarLista() {
        return List.of();
    }
}
