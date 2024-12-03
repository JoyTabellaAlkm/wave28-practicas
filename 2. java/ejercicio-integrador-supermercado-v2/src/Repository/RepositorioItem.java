package Repository;
import Model.Item;
import java.util.ArrayList;
import java.util.List;

public class RepositorioItem implements IRepository<Item> {

    private final List<Item> listaItems;

    public RepositorioItem() {
        this.listaItems = new ArrayList<>();
    }

    @Override
    public List<Item> getAll() {
        return this.listaItems;
    }

    @Override
    public Item getOne(String codigo) {
        for(Item item: listaItems) {
            if(codigo.equals(item.getCodigo())) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void create(Item i) {
        listaItems.add(i);
    }

    @Override
    public void delete(String codigo) {
        listaItems.removeIf(item -> codigo.equals(item.getCodigo()));
    }
}
