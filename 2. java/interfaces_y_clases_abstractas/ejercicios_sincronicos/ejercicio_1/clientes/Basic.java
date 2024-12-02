package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.clientes;

import interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.transaccion.ConsultaDeSaldo;
import interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.transaccion.PagoDeServicios;
import interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.transaccion.RetiroDeEfectivo;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {
    @Override
    public void hacerConsultaDeSaldo() {
        System.out.println("Se realiza consulta de saldo");
    }

    @Override
    public void hacerPagoDeServicios() {
        System.out.println("Se realiza pago de servicios");
    }

    @Override
    public void hacerRetiroDeEfectivo() {
        System.out.println("Se realiza retiro de efectivo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Se realiza la transacción correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar la transacción");
    }
}
