package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.clientes;

import interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.transaccion.Deposito;
import interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.transaccion.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void hacerDeposito() {
        System.out.println("Se realiza el deposito");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Se realiza la transferencia");
    }
}
