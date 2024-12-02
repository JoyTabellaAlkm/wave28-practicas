public class Main {
    public static void main(String[] args) {
        Basico b = new Basico();
        Cobradores c = new Cobradores();
        Ejecutivo e = new Ejecutivo();
        System.out.println("-----------------");
        System.out.println("Transacciones de usuario basic");
        b.getConsultaSaldos();
        b.getPagoServicio();
        b.getPagoServicio();

        System.out.println("-----------------");
        System.out.println("Transacciones de usuario cobrador");

        c.retiro();
        c.consultaSaldos();

        System.out.println("-----------------");
        System.out.println("Transacciones de usuario ejecutivo");

        e.depositar();
        e.transferencia();
    }
}