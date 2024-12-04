package ejercicio1Banco;

import ejercicio1Banco.clientes.Basic;
import ejercicio1Banco.clientes.Cobrador;
import ejercicio1Banco.clientes.Ejecutivo;
import ejercicio1Banco.clientes.ICliente;
import ejercicio1Banco.transacciones.*;

public class MainEj1 {
    public static void main(String[] args){
        ITransaccion deposito = new Deposito();
        ITransaccion transferencia = new Transferencia();
        ITransaccion consultaSaldo = new ConsultaSaldo();
        ITransaccion pagoServicio = new PagoServicio();
        ITransaccion retiroEfectivo = new RetiroEfectivo();

        ICliente basic = new Basic();
        ICliente cobrador = new Cobrador();
        ICliente ejecutivo = new Ejecutivo();

        basic.realizarTransaccion(deposito);
        basic.realizarTransaccion(consultaSaldo);

        cobrador.realizarTransaccion(retiroEfectivo);
        cobrador.realizarTransaccion(pagoServicio);

        ejecutivo.realizarTransaccion(transferencia);
        ejecutivo.realizarTransaccion(consultaSaldo);

    }
}
