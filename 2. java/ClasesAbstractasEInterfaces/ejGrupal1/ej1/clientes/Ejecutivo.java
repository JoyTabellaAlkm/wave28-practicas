package clasesAbstractas.ejGrupal1.ej1.clientes;

import clasesAbstractas.ejGrupal1.ej1.clientes.transacciones.Deposito;
import clasesAbstractas.ejGrupal1.ej1.clientes.transacciones.Transferencia;

public class Ejecutivo {
    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo(Deposito deposito, Transferencia transferencia) {
        this.deposito = deposito;
        this.transferencia = transferencia;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }
}
