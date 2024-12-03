package Banco.Clientes;

import Banco.Consulta_de_Saldo;
import Banco.Pago_de_Servicios;
import Banco.Retiro_de_Efectivo;
import Banco.Transaccion;

public class Basic extends Cliente{

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof Consulta_de_Saldo ||
        transaccion instanceof Pago_de_Servicios ||
        transaccion instanceof Retiro_de_Efectivo){
            transaccion.transaccionOk();
        }else{transaccion.transaccionNoOk();}
    }
    
}
