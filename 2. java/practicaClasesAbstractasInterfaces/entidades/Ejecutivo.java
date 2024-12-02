package practicaClasesAbstractasInterfaces.entidades;


import practicaClasesAbstractasInterfaces.servicios.Depositar;
import practicaClasesAbstractasInterfaces.servicios.Transferencia;

public class Ejecutivo   {

    Depositar depositar;
    Transferencia transferencia;

    public Ejecutivo() {
        this.depositar = new Depositar();
        this.transferencia = new Transferencia();
    }

    public void depositar() {
        depositar.transaccionOK();
    }
    public void transferencia() {
        transferencia.transaccionOK();
    }


}
