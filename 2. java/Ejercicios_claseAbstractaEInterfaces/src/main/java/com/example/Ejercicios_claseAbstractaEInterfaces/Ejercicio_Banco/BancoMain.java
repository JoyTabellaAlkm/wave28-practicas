package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Banco;

import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Banco.Clientes.Basic;
import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Banco.Clientes.Cobrador;
import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Banco.Clientes.Ejecutivo;

public class BancoMain {

    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo(123);
        System.out.println(ejecutivo.depositar());

        Basic basic = new Basic(345);
        System.out.println(basic.tranferir());

        Cobrador cobrador = new Cobrador(678);
        System.out.println(cobrador.retirarEfectivo());

    }
}
