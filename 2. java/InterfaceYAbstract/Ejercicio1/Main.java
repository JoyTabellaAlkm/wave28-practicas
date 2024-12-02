public class Main {
    public static void main(String[] args) {
        Cliente basic = new Basic();
        Cliente cobrador = new Cobrador();
        Cliente ejecutivo = new Ejecutivo();

        basic.realizarAccion(new PagoServicio());
        cobrador.realizarAccion(new RetiroEfectivo());
        ejecutivo.realizarAccion(new Deposito());

    }
}
