package Repositorios;

import Model.Factura;

import java.util.ArrayList;
import java.util.List;

public class FacturaRepository implements CrudRepository<Factura> {

    List<Factura> facturas = new ArrayList<>();
    @Override
    public void crear(Factura objeto) {
        facturas.add(objeto);
    }

    @Override
    public void mostrarInformacion() {
        //facturas.forEach(System.out::println);

        for (Factura fact : facturas) {
            System.out.println(fact.toString());
        }
    }

    @Override
    public void eliminar(Long id) {
        facturas.removeIf(f -> f.getId().equals(id));
        facturas.forEach(System.out::println);
    }

    @Override
    public void consultar(Long id) {
        Factura encontrarFactura = facturas.stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
        if (encontrarFactura==null) {
            System.out.println("Factura no encontrado");
        } else {
            System.out.println("Factura encontrada " + encontrarFactura);
        }
    }
}
