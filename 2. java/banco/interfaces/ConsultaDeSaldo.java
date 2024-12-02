package interfaces;

public interface ConsultaDeSaldo extends State{
    default void consultarSaldo(){
        this.transaccionNoOk();
    }
}
