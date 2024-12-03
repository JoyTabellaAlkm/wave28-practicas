package ejercicio1.clientes;

import ejercicio1.transacciones.ConsultaSaldo;
import ejercicio1.transacciones.PagoServicios;
import ejercicio1.transacciones.RetiroEfectivo;

public class Basic {
    public void consultarSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        try {
            consultaSaldo.transaccionOk();
        } catch (Exception e) {
            consultaSaldo.transaccionNoOk();
        }
    }

    public void retirarEfectivo(){
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        try{
            retiroEfectivo.transaccionOk();
        } catch (Exception e) {
            retiroEfectivo.transaccionNoOk();
        }
    }

    public void pagarServicios(){
        PagoServicios pagoServicios = new PagoServicios();
        try{
            pagoServicios.transaccionOk();
        } catch (Exception e) {
            pagoServicios.transaccionNoOk();
        }
    }
}
