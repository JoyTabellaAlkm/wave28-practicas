package Clases.Transferencia;

import Interfaces.ITransaccion;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se realiza el retiro efetivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realiza el retiro efectivo");
    }
}
