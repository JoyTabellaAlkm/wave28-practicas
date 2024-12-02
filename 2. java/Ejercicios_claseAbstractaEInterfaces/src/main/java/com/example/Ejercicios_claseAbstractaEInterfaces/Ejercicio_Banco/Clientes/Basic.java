package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Banco.Clientes;

import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Banco.ITransaccion;

public class Basic implements ITransaccion {
    private int id;

    public Basic(int id) {
        this.id = id;
    }

    @Override
    public String depositar() {
        return transaccionNoOk();
    }

    @Override
    public String tranferir() {
        return transaccionNoOk();
    }

    @Override
    public String retirarEfectivo() {
        return transaccionOk();
    }

    @Override
    public String cosnutlarSaldo() {
        return transaccionOk();
    }

    @Override
    public String pagarServicio() {
        return transaccionOk();
    }
}
