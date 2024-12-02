package com.bootcampJava.Clases;

import com.bootcampJava.Clases.Cliente;
import com.bootcampJava.Interfaces.Deposito;
import com.bootcampJava.Interfaces.Transaccion;
import com.bootcampJava.Interfaces.Transferencia;

public class Ejecutivo extends Cliente {

    @Override
    public void realizarTransaccion(Transaccion transaccion){
        if(transaccion instanceof Deposito || transaccion instanceof Transferencia) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
