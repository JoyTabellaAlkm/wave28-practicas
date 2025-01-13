package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemImp implements ICRUD<Item>{
    List<Item> items = new ArrayList<>();

    @Override
    public void agregar(Item item) {
        items.add(item);
    }

    @Override
    public void eliminar(Long id) {
        items.removeIf(item -> item.getCodigo().equals(id));
    }

    @Override
    public Item buscar(Long id) {
        return items.stream()
                .filter(item -> item.getCodigo().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Item> listar() {
        return items;
    }
}
