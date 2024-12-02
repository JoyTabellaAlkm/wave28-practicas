package Clases.Transferencia;

import Interfaces.ITransaccion;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se realiza el deposito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realiza el deposito");
    }
}
