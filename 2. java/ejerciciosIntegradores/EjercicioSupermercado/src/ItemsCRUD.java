import java.util.ArrayList;
import java.util.List;

public class ItemsCRUD implements CRUD<Items>{

    List<Items> allItems = new ArrayList<>();

    @Override
    public void crear(Items item) {
        this.allItems.add(item);
    }

    @Override
    public void eliminar(Items String) {

    }

    @Override
    public Items leer(Items Objet) {
        return null;
    }

    @Override
    public void actualizar(Items Objet) {

    }

    @Override
    public List<Items> listar() {
        return allItems;
    }
}
