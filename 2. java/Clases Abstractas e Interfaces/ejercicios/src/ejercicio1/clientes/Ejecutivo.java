package ejercicio1.clientes;

import ejercicio1.transacciones.Deposito;
import ejercicio1.transacciones.Transferencia;

public class Ejecutivo {
    public void realizarDeposito(){
        Deposito deposito = new Deposito();
        try{
            deposito.transaccionOk();
        } catch (Exception e) {
            deposito.transaccionNoOk();
        }
    }

    public void realizarTransferencia(){
        Transferencia transferencia = new Transferencia();
        try {
            transferencia.transaccionOk();
        } catch (Exception e) {
            transferencia.transaccionNoOk();
        }
    }
}
