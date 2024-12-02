package Clases.Cliente;

import Clases.Transferencia.*;

public class Basic extends Cliente{
    public Basic(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion() {
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        PagoServicios pagoServicios = new PagoServicios();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        System.out.println("Basic: "+ getNombre());
        consultaSaldo.transaccionOk();
        pagoServicios.transaccionNoOk();
        retiroEfectivo.transaccionNoOk();
    }
}
