package Clases;

import Interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository implements IRepository<Item> {
    private List<Item> items;

    public ItemRepository() {
        this.items = new ArrayList<>();
    }

    @Override
    public Item buscarPorCodigo(int codigo) {
        return items.stream()
                .filter(item -> item.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void crear(Item item) {
        items.add(item);
    }

    @Override
    public void modificar(Item item) {
        Item itemExistente = buscarPorCodigo(item.getCodigo());
        if (itemExistente != null) {
            itemExistente.setNombre(item.getNombre());
            itemExistente.setCostoUnitario(item.getCantComprada());
        }
    }

    @Override
    public void eliminar(Item item) {
        items.removeIf(c -> c.getCodigo() == item.getCodigo());
    }
}
