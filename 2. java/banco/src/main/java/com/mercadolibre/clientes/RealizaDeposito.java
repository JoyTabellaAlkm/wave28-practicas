package com.mercadolibre.clientes;

import com.mercadolibre.transacciones.Deposito;
import com.mercadolibre.transacciones.Transaccion;

public interface RealizaDeposito {

    public default void realizaDeposito() {
        Transaccion t = new Deposito();
        t.transaccionOk();
    }

}
