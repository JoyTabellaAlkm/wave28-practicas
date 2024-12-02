import banco.Basic;
import banco.Cliente;
import banco.Cobrador;
import banco.Ejecutivo;

class Main {
    public static void main(String[] args) {
        Cliente ejecutivo = new Ejecutivo("Pablo Diaz");
        Cliente basic = new Basic("Gimena Perez");
        Cliente cobrador = new Cobrador("Juan Sanchez");

        ejecutivo.realizarTransferencia(basic, 20.5);
        ejecutivo.realizarDeposito(basic, 20.5);
        ejecutivo.consultarSaldo();
        ejecutivo.pagarServicios();
        ejecutivo.retirarEfectivo();

        System.out.println("------------------------------------------------------");

        basic.realizarTransferencia(ejecutivo, 20.5);
        basic.realizarDeposito(ejecutivo, 20.5);
        basic.consultarSaldo();
        basic.pagarServicios();
        basic.retirarEfectivo();

        System.out.println("------------------------------------------------------");

        cobrador.realizarTransferencia(ejecutivo, 20.5);
        cobrador.realizarDeposito(ejecutivo, 20.5);
        cobrador.consultarSaldo();
        cobrador.pagarServicios();
        cobrador.retirarEfectivo();

        System.out.println("------------------------------------------------------");

    }
}