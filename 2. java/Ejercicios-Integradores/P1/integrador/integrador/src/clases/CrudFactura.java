package clases;

import interfaces.ICrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrudFactura implements ICrud<Factura, Integer> {
    private List<Factura> facturas;

    public CrudFactura() {
        this.facturas = new ArrayList<>();
    }

    @Override
    public Factura create(Factura factura) throws Exception {
        Factura clienteEncontrado = this.get(factura.getId());
        if(clienteEncontrado != null) {
            throw new Exception("La factura ya existe en el repositorio");
        }
        this.facturas.add(factura);
        return factura;
    }

    @Override
    public Factura delete(Integer id) throws Exception {
        Optional<Factura> factura = this.facturas.stream().filter(cl -> cl.getId() == id).findFirst();
        if(factura.isEmpty()) {
            throw new Exception("Factura no encontrada");
        }
        return factura.get();
    }

    @Override
    public Factura get(Integer id) {
        Optional<Factura> factura = this.facturas.stream().filter(fc-> fc.getId() == id).findFirst();
        return factura.orElse(null);

    }
}
