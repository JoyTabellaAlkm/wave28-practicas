public class Cobrador {
    void retirarEfectivo(){
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionOk();
    }

    void consultarSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaccionOk();
    }
}
