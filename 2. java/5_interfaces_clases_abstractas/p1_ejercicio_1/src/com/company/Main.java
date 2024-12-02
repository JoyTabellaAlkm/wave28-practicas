package com.company;

public class Main {

    public static void main(String[] args) {

      Ejecutivo ejecutivo = new Ejecutivo();

      System.out.println("=====Resultados Ejecutivo=====");
      ejecutivo.depositar();
      ejecutivo.transaccionOk();
      ejecutivo.transferir();
      ejecutivo.transaccionNoOk();

      Basic basic = new Basic();

      System.out.println("=====Resultados Basic=====");
      basic.consultarSaldo();
      basic.transaccionOk();
      basic.pagarServicio();
      basic.retirar();
      basic.transaccionNoOk();

      Cobrador cobrador = new Cobrador();
      System.out.println("=====Resultados Cobrador=====");
      cobrador.consultarSaldo();
      cobrador.transaccionOk();
      cobrador.consultarSaldo();
      cobrador.transaccionNoOk();

    }
}
