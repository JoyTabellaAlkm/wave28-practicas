package com.bootcamp.ejercicio_1.classes;

import com.bootcamp.ejercicio_1.interfaces.IDeposito;
import com.bootcamp.ejercicio_1.interfaces.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {
    @Override
    public void hacerDeposito(boolean flag) {
        System.out.println("Realizando deposito...");
        if (flag) {
            transaccionOk("hacerDeposito");
        } else {
            transaccionNoOk("hacerDeposito");
        }
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println(tipoTransacc + " realizado correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transaccion " + tipoTransacc + " no se pudo concluir");
    }

    @Override
    public void hacerTransferencia(boolean flag) {
        System.out.println("Realizando transferencia...");
        if (flag) {
            transaccionOk("hacerTransferencia");
        } else {
            transaccionNoOk("hacerTransferencia");
        }
    }

    public Ejecutivo() {
    }
}
