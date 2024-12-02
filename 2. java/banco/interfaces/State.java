package interfaces;

public interface State {
    default void transaccionOk(){
        System.out.println("Transaccion se ejecuto con exito");
    };

    default void transaccionNoOk(){
        System.out.println("Transaccion fallo");
    };
}
