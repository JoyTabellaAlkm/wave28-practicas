package banco;

public class RetiroEfectivo implements ITransaccion {
    public RetiroEfectivo(Cliente cliente) {
        System.out.println("Retirando efectivo servicios");
        if (cliente.puedeRetirarEfectivo()) {
            this.transaccionOk();
        } else {
            this.transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El retiro de efectivo no se pudo realizar");
    }
}
