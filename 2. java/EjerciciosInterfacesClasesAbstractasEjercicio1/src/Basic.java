public class Basic {
    void consultarSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaccionOk();
    }

    void pagarServicios(){
        PagoServicios pagoServicios = new PagoServicios();
        pagoServicios.transaccionOk();
    }

    void retirarEfectivo(){
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionNoOk();
    }
}
