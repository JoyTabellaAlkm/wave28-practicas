package org.example.model;

import org.example.Transacciones;

public class RetiroEfectivo implements Transacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando retiro de efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puedo realizar el retiro de efectivo");

    }
}
