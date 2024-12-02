package com.bootcamp.ejercicio_1.classes;

import com.bootcamp.ejercicio_1.interfaces.IConsultaSaldo;
import com.bootcamp.ejercicio_1.interfaces.IRetiroEfec;

public class Cobrador implements IRetiroEfec, IConsultaSaldo {
    @Override
    public void consultarSaldo(boolean flag) {
        System.out.println("Consultando saldo...");
        if (flag) {
            transaccionOk("consultarSaldo");
        } else {
            transaccionNoOk("consultarSaldo");
        }
    }

    @Override
    public void retirarEfectivo(Double monto, boolean flag) {
        System.out.println("Intentando retirar: " + monto);
        if (flag) {
            transaccionOk("retirarEfectivo");
        } else {
            transaccionNoOk("retirarEfectivo");
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

    public Cobrador() {
    }
}
