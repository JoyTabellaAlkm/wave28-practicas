package com.bootcampJava.Clases;

import com.bootcampJava.Interfaces.ConsultaSaldo;
import com.bootcampJava.Interfaces.RetiroEfectivo;
import com.bootcampJava.Interfaces.Transaccion;

public class Cobradores extends Cliente {

    @Override
    public void realizarTransaccion(Transaccion transaccion){
        if (transaccion instanceof RetiroEfectivo || transaccion instanceof ConsultaSaldo) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
