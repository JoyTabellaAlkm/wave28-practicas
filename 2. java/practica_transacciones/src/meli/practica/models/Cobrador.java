package practica_transacciones.src.meli.practica.models;

public class Cobrador {

    public void retiroEfectivo(){
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionOk();
    }

    public void consultaSaldo(){
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaccionOk();
    }

}
