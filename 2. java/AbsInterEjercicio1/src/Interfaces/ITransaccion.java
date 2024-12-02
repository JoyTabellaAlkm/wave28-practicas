package Interfaces;

public interface ITransaccion {
    void transaccionOk();
    default void transaccionNoOk() {
        System.out.println("No se pudo completar la operacion.");
    }
}
