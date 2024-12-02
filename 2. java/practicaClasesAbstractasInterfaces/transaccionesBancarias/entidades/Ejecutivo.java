package practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades;


import practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.servicios.Depositar;
import practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.servicios.Transferencia;

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
