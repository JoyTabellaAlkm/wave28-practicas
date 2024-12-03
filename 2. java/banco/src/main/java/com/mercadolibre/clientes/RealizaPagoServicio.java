package com.mercadolibre.clientes;

import com.mercadolibre.transacciones.PagoServicio;
import com.mercadolibre.transacciones.Transaccion;

public interface RealizaPagoServicio {

    public default void realizaPagoServicio() {
        Transaccion t = new PagoServicio();
        t.transaccionOk();
    }

}
