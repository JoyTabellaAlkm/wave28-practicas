package Transacciones;

public class PagarServicio extends Operacion  {
    public PagarServicio() {}
    @Override
    public void transaccionOk() {
        System.out.println("El servicio se pagó correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El servicio no e pudo pagar");
    }
}