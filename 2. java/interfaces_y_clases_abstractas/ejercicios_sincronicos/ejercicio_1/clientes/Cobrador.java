package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.clientes;

import interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.transaccion.ConsultaDeSaldo;
import interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.transaccion.RetiroDeEfectivo;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo {
    @Override
    public void hacerConsultaDeSaldo() {
        System.out.println("Se realiza consulta de saldo");
    }

    @Override
    public void hacerRetiroDeEfectivo() {
        System.out.println("Se realiza retiro de efectivo");
    }
}
