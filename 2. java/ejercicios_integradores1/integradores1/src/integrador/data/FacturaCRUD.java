package integrador.data;

import integrador.Factura;

import java.util.ArrayList;
import java.util.List;

public class FacturaCRUD implements CRUD<Factura> {

    private static FacturaCRUD INSTANCE;
    private List<Factura> facturas = new ArrayList<>();

    private FacturaCRUD(){}

    public static FacturaCRUD getInstance() {
        if (INSTANCE == null)
            INSTANCE = new FacturaCRUD();
        return INSTANCE;
    }

    @Override
    public void guardar(Factura factura) {
        if(facturas.contains(factura)) {
            System.out.println("FACTURA YA EXISTENTE");
            return;
        }
        facturas.add(factura);
    }

    @Override
    public void eliminar(Factura factura) {
        facturas.remove(factura);
    }

    @Override
    public void actualizar(Factura factura) {
        if (!facturas.contains(factura)) {
            facturas.add(factura);
        } else {
            facturas.get(facturas.indexOf(factura)).setCliente(factura.getCliente());
            facturas.get(facturas.indexOf(factura)).setItems(factura.getItems());
            facturas.get(facturas.indexOf(factura)).setTotal(factura.getTotal());

        }
    }

    @Override
    public List<Factura> obtenerTodos() {
        return new ArrayList<>(facturas);
    }
}