package repository;

import model.Factura;

import java.util.ArrayList;
import java.util.List;

public class FacturaImp implements ICRUD<Factura> {
    private List<Factura> facturas = new ArrayList<>();

    @Override
    public void agregar(Factura factura){

        facturas.add(factura);
    }

    public void eliminar(Long id){

        facturas.removeIf(factura -> factura.getCodigo().equals(id));
    }

    @Override
    public Factura buscar (Long id){
        return facturas.stream()
                .filter(factura -> factura.getCodigo().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Factura> listar(){

        return facturas;
    }
}
