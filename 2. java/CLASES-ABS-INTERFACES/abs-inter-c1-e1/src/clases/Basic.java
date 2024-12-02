package clases;

public class Basic {
    ConsultarSaldo cs = new ConsultarSaldo();
    PagoServicios ps = new PagoServicios();
    RetiroEfectivo re = new RetiroEfectivo();

    public void consultarSaldo() {
        try {
            this.cs.transaccionOk();
        } catch (Exception e) {
            this.cs.transaccionNoOk();

        }
    }

    public void pagarServicios(double monto) {
        if (monto > 0) {
            this.ps.transaccionOk();
        } else {
            this.ps.transaccionNoOk();
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
