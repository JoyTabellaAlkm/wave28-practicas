package transacciones;

public class Deposito implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("El depósito ha sido realizado correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El depósito no ha sido realizado correctamente.");
    }

}
