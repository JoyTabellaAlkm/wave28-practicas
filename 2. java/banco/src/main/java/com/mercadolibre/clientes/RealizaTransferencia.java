package com.mercadolibre.clientes;

import com.mercadolibre.transacciones.Transaccion;
import com.mercadolibre.transacciones.Transferencia;

public interface RealizaTransferencia {

    public default void realizaTransferencia() {
        Transaccion t = new Transferencia();
        t.transaccionOk();
    }

}
