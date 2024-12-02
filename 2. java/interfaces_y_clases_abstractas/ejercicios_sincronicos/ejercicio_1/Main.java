package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1;

import interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.clientes.Basic;
import interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.clientes.Cobrador;
import interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.clientes.Ejecutivo;

public class Main {

    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();

        System.out.println("=== TRANSACCIONES BANCARIAS ===");
        System.out.println("-- Ejecutivo");
        ejecutivo.hacerTransferencia();
        ejecutivo.transaccionOk();
        ejecutivo.hacerDeposito();
        ejecutivo.transaccionOk();
        System.out.println("-- Basic");
        basic.hacerConsultaDeSaldo();
        basic.transaccionOk();
        basic.hacerRetiroDeEfectivo();
        basic.transaccionNoOk();
        basic.hacerPagoDeServicios();
        basic.transaccionOk();
        System.out.println("-- Cobrador");
        cobrador.hacerConsultaDeSaldo();
        cobrador.transaccionOk();
        cobrador.hacerRetiroDeEfectivo();
        cobrador.transaccionNoOk();
    }
}
