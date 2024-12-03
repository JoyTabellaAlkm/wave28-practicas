package ejercicios.integradores.Supermercado.implementaciones;

import ejercicios.integradores.Supermercado.modelo.Facturas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUD{
    List<Facturas> facturas = new ArrayList<>();

    @Override
    public void save(Object objeto) {
        facturas.add((Facturas) objeto);
    }

    @Override
    public void mostrar() {
        for(Facturas f : facturas){
            System.out.println(f);
        }
    }

    @Override
    public Optional<Facturas> buscar(Long id) {
        return facturas.stream().filter(x -> x.getId() == id).findFirst();
    }

    @Override
    public void eliminar(Long id) {
        facturas.removeIf(x -> x.getId() == id);
    }

    @Override
    public List<Facturas> listar() {
        return facturas;
    }
}
