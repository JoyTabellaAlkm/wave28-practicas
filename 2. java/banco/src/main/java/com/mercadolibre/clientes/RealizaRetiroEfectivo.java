package com.mercadolibre.clientes;

import com.mercadolibre.transacciones.RetiroEfectivo;
import com.mercadolibre.transacciones.Transaccion;

public interface RealizaRetiroEfectivo {

    public default void realizaRetiroEfectivo() {
        Transaccion t = new RetiroEfectivo();
        t.transaccionOk();
    }

}
