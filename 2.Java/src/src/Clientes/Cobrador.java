package Clientes;

import Transacciones.*;

public class Cobrador extends Cliente{
    // inicializo la operacion
    Operacion deposito= new Desposito();
    Operacion transferencia= new Transferencia();
    Operacion retirarEfectivo= new RetiroEfectivo();
    Operacion pagarServicio= new PagarServicio();

   // realizo la transaccion  dependiendo el usuario
    @Override
    public void realizarTransaccion(String operacion) {

        if (operacion.equals("deposito")) {
            deposito.transaccionNoOk();
        }else if (operacion.equals("transferencia")) {
            transferencia.transaccionNoOk();
        }else if (operacion.equals("retirarEfectivo")) {
            retirarEfectivo.transaccionOk();
        }else if (operacion.equals("pagarServicio")) {
            pagarServicio.transaccionNoOk();
        }else if(operacion.equals("consultarSaldo")){
            super.verSaldoActual();
        }
    }
}
