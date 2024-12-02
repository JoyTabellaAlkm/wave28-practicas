package com.mercadolibre.clientes;

import com.mercadolibre.transacciones.Deposito;
import com.mercadolibre.transacciones.Transferencia;

public class Ejecutivo extends Cliente {

    public Ejecutivo() {
        super("Ejecutivo");
        transacciones.add(new Deposito());
        transacciones.add(new Transferencia());
    }

}
