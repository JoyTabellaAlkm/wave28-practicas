package Transacciones;

public class Basic {
    private ConsultaDeSaldo consultaDeSaldo = new ConsultaDeSaldo();
    private PagoDeServicios pagoDeServicios = new PagoDeServicios();
    private Retiro retiro = new Retiro();

    public void consultarSaldo(){
        System.out.println("Consulta de saldo");
        retiro.trasaccionOk();
    }

    public void pagarServicios(){
        System.out.println("Pago de Servicio");
        retiro.trasaccionOk();
    }

    public void retirarEfectivo(){
        System.out.println("Retiro en efectivo");
        retiro.trasaccionOk();
    }
}
