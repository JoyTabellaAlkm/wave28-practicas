package interfaces;

public interface Deposito extends State{

    default void enviarDinero(){
        this.transaccionNoOk();
    }
}
