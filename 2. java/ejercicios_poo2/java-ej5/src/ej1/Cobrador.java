package ej1;

public class Cobrador {
    public void retirarEfectivo() {
        Transaccion t = new RetiroEfectivo();
        t.transaccionOk();
    }

    public void consultarSaldo() {
        Transaccion t = new ConsultaSaldo();
        t.transaccionOk();
    }
}
