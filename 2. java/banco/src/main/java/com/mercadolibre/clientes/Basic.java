package com.mercadolibre.clientes;

import com.mercadolibre.transacciones.ConsultaSaldo;
import com.mercadolibre.transacciones.PagoServicios;
import com.mercadolibre.transacciones.RetiroEfectivo;

public class Basic extends Cliente {

    public Basic() {
        super("Basic");
        transacciones.add(new ConsultaSaldo());
        transacciones.add(new PagoServicios());
        transacciones.add(new RetiroEfectivo());
    }

}
