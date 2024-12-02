package transacciones;

public class Transferencia implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("La transferencia ha sido realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transferencia no ha sido realizada correctamente.");
    }

}
