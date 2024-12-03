package modelos;

import interfaces.ITransaccion;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando retiro de efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puedo realizar el retiro de efectivo");

    }
}