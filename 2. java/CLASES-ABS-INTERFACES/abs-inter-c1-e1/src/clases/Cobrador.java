package clases;

public class Cobrador {
    ConsultarSaldo cs = new ConsultarSaldo();
    RetiroEfectivo re = new RetiroEfectivo();

    public void consultarSaldo() {
        try {
            this.cs.transaccionOk();
        } catch (Exception) {
            this.cs.transaccionNoOk();
        }
    }

    public void retirarEfectivo(double monto) {
        if (monto > 0) {
            this.re.transaccionOk();
        } else {
            this.re.transaccionNoOk();
        }
    }
}
