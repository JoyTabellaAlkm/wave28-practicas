package com.bootcampJava.Clases;

import com.bootcampJava.Interfaces.*;

public class Banco {

    public static void main(String[] args) {
        Cliente ejecutivo = new Ejecutivo();
        Cliente basic = new Basic();
        Cliente cobradores = new Cobradores();

        Transaccion deposito = new Deposito();
        Transaccion transferencia = new Transferencia();
        Transaccion consultaSaldo = new ConsultaSaldo();
        Transaccion pagoServicio = new PagoServicios();
        Transaccion retirarEfectivo = new RetiroEfectivo();

        ejecutivo.realizarTransaccion(deposito);
        ejecutivo.realizarTransaccion(consultaSaldo);

        basic.realizarTransaccion(pagoServicio);
        basic.realizarTransaccion(retirarEfectivo);
        basic.realizarTransaccion(deposito);

        cobradores.realizarTransaccion(retirarEfectivo);
        cobradores.realizarTransaccion(transferencia);

    }
}
