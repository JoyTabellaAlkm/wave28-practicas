package com.bootcampJava.Clases;

import com.bootcampJava.Interfaces.ConsultaSaldo;
import com.bootcampJava.Interfaces.PagoServicios;
import com.bootcampJava.Interfaces.RetiroEfectivo;
import com.bootcampJava.Interfaces.Transaccion;

public class Basic extends Cliente {

    @Override
    public void realizarTransaccion(Transaccion transaccion){
        if(transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetiroEfectivo) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
