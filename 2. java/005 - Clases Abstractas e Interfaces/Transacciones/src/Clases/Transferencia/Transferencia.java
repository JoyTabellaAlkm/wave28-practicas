package Clases.Transferencia;

import Interfaces.ITransaccion;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se realiza la transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realiza la transferencia");
    }
}
