package ej1;

public class Basic {
    public void retirar(int monto) {
        Transaccion t = new RetiroEfectivo();
        t.transaccionOk();
    }

    public void pagarServicio() {
        Transaccion t = new PagoServicio();
        t.transaccionNoOk();
    }

    public void consultarSaldo() {
        Transaccion t = new ConsultaSaldo();
        t.transaccionOk();
    }
}
