package practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades;


import practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.servicios.ConsultaSaldos;
import practicaClasesAbstractasInterfaces.transaccionesBancarias.entidades.servicios.Retiro;

public class Cobradores  {
    ConsultaSaldos consultaSaldos;
    Retiro retiroDeEfectivo;

    public Cobradores() {
        this.consultaSaldos = new ConsultaSaldos();
        this.retiroDeEfectivo = new Retiro();
    }

    public void consultarSados() {
        consultaSaldos.transaccionOK();
    }
    public void retiroDeEfectivo() {
        retiroDeEfectivo.transaccionNoOK();
    }
}
