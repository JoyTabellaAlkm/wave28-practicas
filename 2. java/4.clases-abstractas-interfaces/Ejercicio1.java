package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        com.bootcamp.Ejecutivo ejecutivo = new com.bootcamp.Ejecutivo();
        com.bootcamp.Basic basic = new com.bootcamp.Basic();
        com.bootcamp.Cobrador cobrador = new com.bootcamp.Cobrador();
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

class Deposito implements com.bootcamp.ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Hago un deposito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al hacer un deposito");
    }
}

class Transferencia implements com.bootcamp.ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Hago una transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al hacer una transferencia");
    }
}

class ConsultarSaldo implements com.bootcamp.ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Consulto el saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al consultar saldo");
    }
}

class PagoServicios implements com.bootcamp.ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Pago servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo al pagar servicios");
    }
}

class RetiroEfectivo implements com.bootcamp.ITransaccion {

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
    com.bootcamp.Deposito deposito = new com.bootcamp.Deposito();
    com.bootcamp.Transferencia transferencia = new com.bootcamp.Transferencia();

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
    com.bootcamp.ConsultarSaldo cs = new com.bootcamp.ConsultarSaldo();
    com.bootcamp.PagoServicios ps = new com.bootcamp.PagoServicios();
    com.bootcamp.RetiroEfectivo re = new com.bootcamp.RetiroEfectivo();

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
    com.bootcamp.ConsultarSaldo cs = new com.bootcamp.ConsultarSaldo();
    com.bootcamp.RetiroEfectivo re = new com.bootcamp.RetiroEfectivo();

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



