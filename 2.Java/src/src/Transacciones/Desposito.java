package Transacciones;

public class Desposito extends Operacion {
    public Desposito() {}
    @Override
    public void transaccionOk() {
        System.out.println("El deposito se realizó correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El deposito no se realizó");
    }
}
