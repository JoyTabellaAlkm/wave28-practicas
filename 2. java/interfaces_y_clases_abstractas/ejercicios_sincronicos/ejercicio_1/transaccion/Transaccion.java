package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_1.transaccion;

public interface Transaccion {
    default void transaccionOk() {
        System.out.println("Se realizó la transacción exitosamente");
    };
    default void transaccionNoOk() {
        System.out.println("No se pudo realizar la transacción");
    }
}