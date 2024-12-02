package clases;

import interfaces.ITransaccion;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al retirar efectivo");
    }
}
