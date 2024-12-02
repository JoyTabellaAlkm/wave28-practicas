package banco;

public class Deposito implements ITransaccion {
    public Deposito(Cliente clienteOrigen, Cliente clienteDestino, Double monto) {
        System.out.println("Realizando depósito de " + clienteOrigen.getNombre() + " a " + clienteDestino.getNombre() + " de monto " + monto);

        if (clienteOrigen.puedeDepositar()) {
            this.transaccionOk();
        } else {
            this.transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El depósito no se pudo realizar");
    }
}
