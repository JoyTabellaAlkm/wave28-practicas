package practica_transacciones.src.meli.practica.models;

public class Basic {

    public void consultaSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaccionOk();
    }

    public void pagoServicios(){
        PagoServicios pagoServicios = new PagoServicios();
        pagoServicios.transaccionOk();
    }

    public void retiroEfectivo(){
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionOk();
    }

}
