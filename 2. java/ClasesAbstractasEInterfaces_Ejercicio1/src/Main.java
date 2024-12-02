public class Main {
    public static void main(String[] args) {
        Basic clienteBasic1 = new Basic();
        System.out.println("--------- Transacciones bancarias ---------");
        clienteBasic1.retirarEfectivo(25000);
        clienteBasic1.transaccionOK("Retiro de Efectivo");


    }
}