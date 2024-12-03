package Banco;

import Banco.Cliente.Basic;
import Banco.Cliente.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----BANCO INTERFACES DEL PAÍS : EJECUTIVO -----");
        Ejecutivo ejec = new Ejecutivo();
        ejec.realizarTransaccion("deposito");
        ejec.realizarTransaccion("transferencia");

        System.out.println("-----BANCO INTERFACES DEL PAÍS : BASIC -----");
        Basic basic = new Basic();
        basic.realizarTransaccion("deposito");
        basic.realizarTransaccion("consultarSaldo");



    }


}
