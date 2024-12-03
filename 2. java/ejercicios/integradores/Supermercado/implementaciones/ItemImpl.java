package ejercicios.integradores.Supermercado.implementaciones;

import ejercicios.integradores.Supermercado.modelo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImpl implements CRUD{
    List<Item> items = new ArrayList<>();

    @Override
    public void save(Object objeto) {
        items.add((Item) objeto);
    }

    @Override
    public void mostrar() {
        for(Item i : items){
            System.out.println(i.toString());
        };
    }

    @Override
    public Optional<Item> buscar(Long id) {
        return items.stream().filter(x -> x.getCodigo() == id).findFirst();
    }

    @Override
    public void eliminar(Long id) {
        items.removeIf(x -> x.getCodigo() == id);
    }

    @Override
    public List<Item> listar() {
        return items;
    }
}
