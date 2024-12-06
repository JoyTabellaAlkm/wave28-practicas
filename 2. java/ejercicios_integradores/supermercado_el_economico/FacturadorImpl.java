package ejercicios_integradores.supermercado_el_economico;

import java.util.List;

public class FacturadorImpl implements Facturador {
    @Override
    public void actualizarFactura(Factura factura) {

    }

    @Override
    public Factura eliminarFactura(int id) {
        return null;
    }

    @Override
    public Factura obtenerFacturaPorId(int id) {
        return null;
    }

    @Override
    public List<Factura> obtenerTodasLasFacturas() {
        return List.of();
    }

    @Override
    public Factura crearFactura(Cliente cliente) {
        return new Factura(cliente);
    }
}
