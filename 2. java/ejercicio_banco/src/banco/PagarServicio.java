package banco;

public class PagarServicio implements ITransaccion {
    public PagarServicio(Cliente cliente) {
        System.out.println("Pagando servicios");
        if (cliente.puedePagarServicios()) {
            this.transaccionOk();
        } else {
            this.transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("El servicio se pagó correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El servicio no se pudo pagar");
    }
}
