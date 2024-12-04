package Transacciones;

public class Retiro implements ITrasacciones {
    @Override
    public void trasaccionOk() {
        System.out.println("Trasaccion con existo");
    }

    @Override
    public void trasaccionNoOk(){
        System.out.println("Trasaccion con existo");
    }
}
