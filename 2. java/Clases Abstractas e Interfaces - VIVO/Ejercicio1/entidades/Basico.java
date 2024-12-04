package practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades;

import practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.servicios.ConsultaSaldos;
import practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.servicios.Depositar;
import practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.servicios.PagoServicio;

public class Basico {
    ConsultaSaldos consultaSaldos;
    PagoServicio pagoServicio;
    Depositar depositar;

    public Basico() {
        this.consultaSaldos = new ConsultaSaldos();
        this.pagoServicio = new PagoServicio();
        this.depositar = new Depositar();
    }

    public void getConsultaSaldos() {
        consultaSaldos.transaccionOK();
    }
    public void getPagoServicio() {
        pagoServicio.transaccionNoOK();
    }
    public void getDepositar() {
        depositar.transaccionOK();
    }
}
