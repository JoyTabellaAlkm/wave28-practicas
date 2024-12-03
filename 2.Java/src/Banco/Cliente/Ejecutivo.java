package Banco.Cliente;

import Banco.Transacciones.*;

public class Ejecutivo extends Cliente{
    // inicializo la operacion
    Operacion deposito= new Desposito();
    Operacion transferencia= new Transferencia();
    Operacion retirarEfectivo= new RetiroEfectivo();
    Operacion pagarServicio= new PagarServicio();

    // realizo la transaccion  dependiendo el usuario
    @Override
    public void realizarTransaccion(String operacion) {

        if (operacion.equals("deposito")) {
            deposito.transaccionOk();
        }else if (operacion.equals("transferencia")) {
            transferencia.transaccionOk();
        }else if (operacion.equals("retirarEfectivo")) {
            retirarEfectivo.transaccionOk();
        }else if (operacion.equals("pagarServicio")) {
            pagarServicio.transaccionOk();
        }else if(operacion.equals("consultarSaldo")){
            System.out.println("No tiene saldo actual");
        }


    }
}
