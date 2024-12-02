package org.example;

import org.example.model.*;

public class Main {
    public static void main(String[] args) {

        Deposito deposito = new Deposito();
        Transferencia transferencia = new Transferencia();
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        PagoServicio pagoServicio = new PagoServicio();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();

        Usuario ejecutivo = new Ejecutivos();
        Usuario cobrador = new Cobradores();
        Usuario basico = new Basic();


//        Las permitidas
        ejecutivo.agregarTransaccion(deposito);
        ejecutivo.agregarTransaccion(transferencia);

        cobrador.agregarTransaccion(retiroEfectivo);
        cobrador.agregarTransaccion(consultaSaldo);


        basico.agregarTransaccion(consultaSaldo);
        basico.agregarTransaccion(retiroEfectivo);
        basico.agregarTransaccion(pagoServicio);


        System.out.println("");

        //        Las no permitidas
        cobrador.agregarTransaccion(deposito);
        basico.agregarTransaccion(transferencia);
        ejecutivo.agregarTransaccion(consultaSaldo);




    }
}