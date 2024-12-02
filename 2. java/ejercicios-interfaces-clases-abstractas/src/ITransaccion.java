public interface ITransaccion {
    public default void transaccionOk() {
        System.out.println("La transaccion se realizo exitosamente");
    };
    public default void transaccionNoOk(){
        System.out.println("La transaccion falló");
    };
}
