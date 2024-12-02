package practica_transacciones.src.meli.practica;

import practica_transacciones.src.meli.practica.models.Basic;
import practica_transacciones.src.meli.practica.models.Cobrador;
import practica_transacciones.src.meli.practica.models.Ejecutivo;

public class Main {

    public static void main(String[] args) {

        System.out.println("Ejecutivo");

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.deposito();

        System.out.println("----------------");
        System.out.println("Basic");

        Basic basic = new Basic();
        basic.consultaSaldo();

        System.out.println("----------------");
        System.out.println("Cobrador");

        Cobrador cobrador = new Cobrador();
        cobrador.retiroEfectivo();

    }

}
