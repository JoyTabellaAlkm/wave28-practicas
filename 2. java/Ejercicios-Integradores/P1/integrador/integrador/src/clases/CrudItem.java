package clases;

import interfaces.ICrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrudItem implements ICrud<Item, Integer> {

    private List<Item> items;

    public CrudItem() {
        this.items = new ArrayList<>();
    }

    @Override
    public Item create(Item item) throws Exception {
        Item itemEncontrado = this.get(item.getCodigo());
        if(itemEncontrado != null) {
            throw new Exception("El item ya existe en el repositorio");
        }
        this.items.add(item);
        return item;
    }

    @Override
    public Item delete(Integer codigo) throws Exception {
        Optional<Item> item = this.items.stream().filter(it -> it.getCodigo() == codigo).findFirst();
        if(item.isEmpty()) {
            throw new Exception("Item no encontrada");
        }
        return item.get();
    }

    @Override
    public Item get(Integer codigo) {
        Optional<Item> item = this.items.stream().filter(it-> it.getCodigo() == codigo).findFirst();
        return item.orElse(null);
    }

    public List<Item> getItems() {
        return items;
    }
}
