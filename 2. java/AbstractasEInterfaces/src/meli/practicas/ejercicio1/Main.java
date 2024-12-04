package meli.practicas.ejercicio1;

public class Main {
    public static void main(String[] args) {
        Cobrador cobrador = new Cobrador();
        cobrador.retiroEfectivo();
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.transferencia();
        ejecutivo.deposito();
        Basic basic = new Basic();
        basic.pagoServicios();
        basic.realizaConsultaSaldo();
        basic.retiroEfectivo();
    }
}
