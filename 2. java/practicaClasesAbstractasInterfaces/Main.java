package practicaClasesAbstractasInterfaces;

import practicaClasesAbstractasInterfaces.entidades.Basico;
import practicaClasesAbstractasInterfaces.entidades.Cobradores;
import practicaClasesAbstractasInterfaces.entidades.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basico b = new Basico();
        Cobradores c = new Cobradores();
        Ejecutivo e = new Ejecutivo();

        System.out.println("-----------------");
        System.out.println("Transacciones de usuario basic");
        b.getConsultaSaldos();
        b.getPagoServicio();
        b.getPagoServicio();

        System.out.println("-----------------");
        System.out.println("Transacciones de usuario cobrador");

        c.retiroDeEfectivo();
        c.consultarSados();

        System.out.println("-----------------");
        System.out.println("Transacciones de usuario ejecutivo");

        e.depositar();
        e.transferencia();

    }
}
