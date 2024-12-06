package ejercicios_integradores.supermercado_el_economico;

import java.util.List;

public interface Facturador {

    Factura obtenerFacturaPorId(int id);
    List<Factura> obtenerTodasLasFacturas();
    void actualizarFactura(Factura factura);
    Factura eliminarFactura(int id);
    Factura crearFactura(Cliente cliente);

}
