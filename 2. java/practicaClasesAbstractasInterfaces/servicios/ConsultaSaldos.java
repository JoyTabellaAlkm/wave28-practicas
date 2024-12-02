package practicaClasesAbstractasInterfaces.servicios;

import practicaClasesAbstractasInterfaces.ITransaccion;

public class ConsultaSaldos implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Consulta de saldos, transaccion OK");

    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Cnsulta de saldos, no se puede realizar la transaccion");
    }
}
