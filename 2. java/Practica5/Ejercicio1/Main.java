package com.bootcamp.ejercicio_1;

import com.bootcamp.ejercicio_1.classes.Basic;
import com.bootcamp.ejercicio_1.classes.Cobrador;
import com.bootcamp.ejercicio_1.classes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic basic1 = new Basic();
        basic1.pagarServicio("Luz",true);
        System.out.println();

        basic1.retirarEfectivo(2000.0,true);
        System.out.println();

        basic1.consultarSaldo(false);
        System.out.println();

        Ejecutivo ejecutivo= new Ejecutivo();
        ejecutivo.hacerDeposito(true);
        System.out.println();

        ejecutivo.hacerTransferencia(true);
        System.out.println();

        ejecutivo.hacerTransferencia(false);
        System.out.println();

        Cobrador cobrador=new Cobrador();
        cobrador.consultarSaldo(true);
        System.out.println();
        cobrador.retirarEfectivo(2000.0,true);
        System.out.println();
        cobrador.retirarEfectivo(2000.0,false);
        System.out.println();

    }
}