package ejercicio3Supermercado.CRUD;

import ejercicio3Supermercado.model.Factura;
import ejercicio3Supermercado.model.Producto;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FacturaImp implements ICRUD<Factura> {
    Set<Factura> facturaSet = new HashSet<Factura>();
    @Override
    public void crearInstancia(Factura obj) {
        int total = obj.getListaItems().stream().mapToInt(Producto::CalcularTotal).sum();
        obj.setTotalCompra(total);
        facturaSet.add(obj);
    }

    @Override
    public void eliminarInstancia(Long id) {

    }

    @Override
    public void mostrarInstancias() {
        facturaSet.stream()
                .forEach(factura -> {
                    System.out.println("Cliente: " + factura.getCliente().getNombre());
                    System.out.println("Productos:");
                    factura.getListaItems().forEach(producto ->
                            System.out.println(" - " + producto.getNombre() + ": $" + producto.getCostoUnitario())
                    );
                    System.out.println("Total: $" + factura.getTotalCompra());
                    System.out.println("---------");
                });
    }

    @Override
    public Optional<Factura> consultarInstancia(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Factura> consultarLista() {

        return List.of();
    }
}
