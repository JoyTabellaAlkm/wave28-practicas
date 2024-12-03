package com.bootcamp.ejercicio_1.classes;

import com.bootcamp.ejercicio_1.interfaces.IConsultaSaldo;
import com.bootcamp.ejercicio_1.interfaces.IPagoServicio;
import com.bootcamp.ejercicio_1.interfaces.IRetiroEfec;


public class Basic implements IConsultaSaldo, IPagoServicio, IRetiroEfec {
    @Override
    public void consultarSaldo(boolean flag) {
        System.out.println("Consultando Saldo....");
        if (flag) {
            transaccionOk("consultarSaldo");
        } else {
            transaccionNoOk("consultarSaldo");
        }
    }


    @Override
    public void pagarServicio(String tipoServ, boolean flag) {
        System.out.println("Pagando servicio: " + tipoServ);
        if (flag) {
            transaccionOk("pagarServicio");
        } else {
            transaccionNoOk("pagarServicio");
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

    public Basic() {
    }
}
