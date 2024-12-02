package Clases.Cliente;

import Clases.Transferencia.Deposito;
import Clases.Transferencia.Transferencia;

public class Ejecutivo extends Cliente {
    public Ejecutivo(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion() {
        Deposito deposito = new Deposito();
        Transferencia transferencia = new Transferencia();
        System.out.println("Ejecutivo: "+getNombre());
        deposito.transaccionOk();
        transferencia.transaccionNoOk();
    }
}
