package org.example.model;

import org.example.Transacciones;

public class ConsultaSaldo implements Transacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando consulta de saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puedo realizar la consulta de saldo");

    }
}
