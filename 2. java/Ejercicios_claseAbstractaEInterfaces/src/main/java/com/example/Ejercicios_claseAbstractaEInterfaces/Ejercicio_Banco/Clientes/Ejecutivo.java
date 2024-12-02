package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Banco.Clientes;

import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Banco.ITransaccion;

public class Ejecutivo implements ITransaccion {
    private int id;

    public Ejecutivo(int id) {
        this.id = id;
    }

    @Override
    public String depositar() {
        return transaccionOk();
    }

    @Override
    public String tranferir() {
        return transaccionOk();
    }

    @Override
    public String retirarEfectivo() {
        return transaccionNoOk();
    }

    @Override
    public String cosnutlarSaldo() {
        return transaccionNoOk();
    }

    @Override
    public String pagarServicio() {
        return transaccionNoOk();
    }
}
