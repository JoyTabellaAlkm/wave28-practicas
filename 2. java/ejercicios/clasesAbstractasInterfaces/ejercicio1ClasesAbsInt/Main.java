package ejercicios.clasesAbstractasInterfaces.ejercicio1ClasesAbsInt;

public class Main {
    public static void main(String[] args) {
        Basic persona1 = new Basic();
        Cobrador persona2 = new Cobrador();
        Ejecutivo persona3 = new Ejecutivo();

        Transaccion cp = new ConsultaPago();
        Transaccion re = new RetiroEfectivo();
        Transaccion d = new Deposito();

        persona1.hacerTransaccion(cp);
        persona2.hacerTransaccion(re);
        persona3.hacerTransaccion(d);
        persona1.hacerTransaccion(d);
    }
}
