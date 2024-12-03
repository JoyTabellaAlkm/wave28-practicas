package repository;

import model.Factura;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements ICRUDRepository<Item>
{
    List<Item> listaItems = new ArrayList<Item>();
    @Override
    public void save(Item objeto) {
        listaItems.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Item fact : listaItems){
            System.out.println(fact.toString());
        }
    }

    @Override
    public Optional<Item> buscar(Long codigoBuscado) {
        boolean bandera = false;
        for(Item f: listaItems){
            if(f.getCodigo().equals(codigoBuscado)){
                System.out.println("-------Item encontrada, sus datos son: -----");
                System.out.println(f.toString());
                return Optional.of(f);
            }
        }
        if(bandera == false){
            System.out.println("Item no encontrada");
        }
        return Optional.empty();
    }

    @Override
    public List<Item> traerTodos() {
        return listaItems;
    }

    @Override
    public void eliminar(Long codigoBorrado) {
        Optional<Item> fact = this.buscar(codigoBorrado);
        if (fact.isEmpty()){
            System.out.println("No se encontró el item a borrar");
        }else{
            System.out.println("Item borrado correctamente");
            listaItems.remove(fact.get());
        }

    }
}
