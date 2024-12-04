package org.example.model;

import org.example.Transacciones;

public class Transferencia implements Transacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puedo realizar transferencia");

    }
}
