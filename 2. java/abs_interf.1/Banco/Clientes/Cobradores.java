package Banco.Clientes;

import Banco.Consulta_de_Saldo;
import Banco.Retiro_de_Efectivo;
import Banco.Transaccion;

public class Cobradores extends Cliente{

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof Retiro_de_Efectivo ||
        transaccion instanceof Consulta_de_Saldo){
            transaccion.transaccionOk();
        }else{transaccion.transaccionNoOk();}
    }
}
