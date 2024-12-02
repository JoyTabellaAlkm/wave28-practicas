package clases;

import interfaces.ITransaccion;

public class ConsultarSaldo implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Consulto el saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al consultar saldo");
    }

}
