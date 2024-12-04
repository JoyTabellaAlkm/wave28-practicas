package practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.servicios;

import practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.ITransaccion;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Se realiza transferencia exitosamente");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se realiza transferencia exitosamente");
    }
}
