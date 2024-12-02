package practicaClasesAbstractasInterfaces.servicios;

import practicaClasesAbstractasInterfaces.ITransaccion;

public class PagoServicio implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Pago de servicios,transaccion OK");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Pago de servicios,transaccion No OK");
    }
}
