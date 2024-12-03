package Repository;

import Model.Factura;
import java.util.ArrayList;
import java.util.List;

public class RepositorioFactura implements IRepository<Factura> {

    private final List<Factura> listaFacturas;

    public RepositorioFactura() {
        this.listaFacturas = new ArrayList<>();
    }

    @Override
    public List<Factura> getAll() {
        return listaFacturas;
    }

    @Override
    public Factura getOne(String id) {
        for(Factura factura: listaFacturas) {
            if(id.equals(factura.getId())) {
                return factura;
            }
        }
        return null;
    }

    @Override
    public void create(Factura f) {
        listaFacturas.add(f);
    }

    @Override
    public void delete(String id) {
        listaFacturas.removeIf(factura -> id.equals(factura.getId()));
    }
}
