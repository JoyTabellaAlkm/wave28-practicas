package clientes;

import transacciones.ConsultaSaldo;
import transacciones.PagoServicios;
import transacciones.RetiroEfectivo;

public class Basic extends Cliente {

    public Basic() {
        super("Basic");
        transacciones.add(new ConsultaSaldo());
        transacciones.add(new PagoServicios());
        transacciones.add(new RetiroEfectivo());
    }

}
