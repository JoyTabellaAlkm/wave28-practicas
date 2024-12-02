package interfaces;

public interface ITransaccion {
    default void transaccionOk() {
        System.out.println("La transaccion fue exitosa");
    }
    default void transaccionNoOk() {
        System.out.println("La transaccion fue exitosa");
    }
}
