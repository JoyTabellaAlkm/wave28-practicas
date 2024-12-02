package Clases.Cliente;

import Clases.Transferencia.ConsultaSaldo;
import Clases.Transferencia.PagoServicios;
import Clases.Transferencia.RetiroEfectivo;

public class Cobrador extends Cliente{
    public Cobrador(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion() {
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        System.out.println("Cobrador: "+ getNombre());
        consultaSaldo.transaccionOk();
        retiroEfectivo.transaccionNoOk();
    }
}
