package repositories;

import classes.Item;
import classes.Item;
import classes.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepositorio implements ICrud<Item>{
    List<Item> listaItems = new ArrayList<>();
    @Override
    public void guardar(Item props) {
        listaItems.add(props);
    }

    @Override
    public Item buscar(int codigo) {
        Item item =
                listaItems.stream().filter(it -> it.getCódigo() == codigo).toList().getFirst();
        if (item == null){
            throw new RuntimeException("Item no encontrado");
        }
        return item;
    }

    @Override
    public List<Item> buscartodos() {
        return listaItems;
    }

    @Override
    public void eliminar(int codigo) {
        boolean encontrado = false;
        for (Item item : listaItems) {
            if (item.getCódigo() == codigo) {
                listaItems.remove(item);
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            throw new RuntimeException("Item no encontrado");
        }
    }
}
