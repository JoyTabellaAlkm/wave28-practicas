package com.mercadolibre;

import com.mercadolibre.clientes.Basic;
import com.mercadolibre.clientes.Cobrador;
import com.mercadolibre.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizaDeposito();
        ejecutivo.realizaTransferencia();

        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.realizaPagoServicio();
        basic.realizaRetiroEfectivo();

        Cobrador cobrador = new Cobrador();
        cobrador.consultarSaldo();
        cobrador.realizaRetiroEfectivo();
    }
}
