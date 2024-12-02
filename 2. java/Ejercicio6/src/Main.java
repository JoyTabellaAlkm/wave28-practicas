public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();

        System.out.println("Ejecutivo:");
        ejecutivo.depositar(1000);
        ejecutivo.transferir(0);

        System.out.println("Basic:");
        basic.consultarSaldo();
        basic.pagarServicios(1000);
        basic.retirarEfectivo(0);

        System.out.println("Cobrador:");
        basic.consultarSaldo();
        basic.retirarEfectivo(10);
    }
}

interface ITransaccion {
    void transaccionOk();
    void transaccionNoOk();
}

class Deposito implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Hago un deposito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al hacer un deposito");
    }
}

class Transferencia implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Hago una transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al hacer una transferencia");
    }
}

class ConsultarSaldo implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Consulto el saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al consultar saldo");
    }
}

class PagoServicios implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Pago servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al pagar servicios");
    }
}

class RetiroEfectivo implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Retiro efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al retirar efectivo");
    }
}


class Ejecutivo {
    Deposito deposito = new Deposito();
    Transferencia transferencia = new Transferencia();

    public void depositar(double monto) {
        if (monto > 0) {
            this.deposito.transaccionOk();
        } else {
            this.deposito.transaccionNoOk();
        }
    }

    public void transferir(double monto) {
        if (monto > 0) {
            this.transferencia.transaccionOk();
        } else {
            this.transferencia.transaccionNoOk();
        }
    }
}

class Basic {
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

class Cobrador {
    ConsultarSaldo cs = new ConsultarSaldo();
    RetiroEfectivo re = new RetiroEfectivo();

    public void consultarSaldo() {
        try {
            this.cs.transaccionOk();
        } catch (Exception e) {
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