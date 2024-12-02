package interfaces;

public interface Transferencia extends State{

    default void transferirDinero(){
        this.transaccionOk();
    }
}
