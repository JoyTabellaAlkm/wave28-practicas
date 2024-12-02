package com.mercadolibre.clientes;

import com.mercadolibre.transacciones.ConsultaSaldo;
import com.mercadolibre.transacciones.RetiroEfectivo;

public class Cobradores extends Cliente {

    public Cobradores() {
        super("Cobradores");
        transacciones.add(new RetiroEfectivo());
        transacciones.add(new ConsultaSaldo());
    }

}
