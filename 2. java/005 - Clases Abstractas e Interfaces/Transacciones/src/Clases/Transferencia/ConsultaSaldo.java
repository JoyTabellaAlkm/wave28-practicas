package Clases.Transferencia;

import Interfaces.ITransaccion;

public class ConsultaSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Se realiza la consulta saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realiza la consulta saldo");
    }
}
