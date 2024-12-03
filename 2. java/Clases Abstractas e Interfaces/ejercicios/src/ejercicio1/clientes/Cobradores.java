package ejercicio1.clientes;

import ejercicio1.transacciones.ConsultaSaldo;
import ejercicio1.transacciones.RetiroEfectivo;

public class Cobradores {
    public void retirarEfectivo(){
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        try{
            retiroEfectivo.transaccionOk();
        } catch (Exception e) {
            retiroEfectivo.transaccionNoOk();
        }
    }

    public void consultarSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        try {
            consultaSaldo.transaccionOk();
        } catch (Exception e) {
            consultaSaldo.transaccionNoOk();
        }
    }
}
