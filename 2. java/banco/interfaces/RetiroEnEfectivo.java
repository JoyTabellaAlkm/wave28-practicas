package interfaces;

public interface RetiroEnEfectivo extends State{
    default void retirar(){
        this.transaccionOk();
    }
}
