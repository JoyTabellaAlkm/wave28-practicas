package Transacciones;

public class Cobrador {
    private final Retiro retiro = new Retiro();
    private final ConsultaDeSaldo consultaDeSaldo = new ConsultaDeSaldo();

    public void retirarEfectivo(){
        System.out.println("Retiro en efectivo");
        retiro.trasaccionOk();
    }

    public void consultarSaldo(){
        System.out.println("Consulta de saldo");
        retiro.trasaccionOk();
    }

}
