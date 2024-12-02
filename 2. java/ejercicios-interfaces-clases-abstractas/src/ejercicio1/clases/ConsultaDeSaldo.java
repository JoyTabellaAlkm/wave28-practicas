package ejercicio1.clases;

import ejercicio1.interfaces.ITransaccion;

public class ConsultaDeSaldo implements ITransaccion {


    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo fallida");
    }
}
