public class Main {
    public static void main(String[] args) {
        TransaccionBasic basic = new TransaccionBasic();
        TransaccionEjecutiva ejecutiva = new TransaccionEjecutiva();
        TransaccionCobradores cobradores = new TransaccionCobradores();

        basic.consultaSaldo();
        ejecutiva.deposito();
        cobradores.retiroEfectivo();

        System.out.println(ejecutiva.transaccionOk());
        System.out.println(cobradores.transaccionNoOk());
    }
}