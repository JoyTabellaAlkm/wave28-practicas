package com.mercadolibre.clientes;

import com.mercadolibre.transacciones.ConsultaSaldo;
import com.mercadolibre.transacciones.Transaccion;

public interface RealizaConsultaSaldo {

    public default void consultarSaldo() {
        Transaccion t = new ConsultaSaldo();
        t.transaccionOk();
    };

}
