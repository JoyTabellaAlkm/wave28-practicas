package banco;

public class Transferencia implements ITransaccion {
    public Transferencia(Cliente clienteOrigen, Cliente clienteDestino, Double monto) {
        System.out.println("Realizando transferencia de " + clienteOrigen.getNombre() + " a " + clienteDestino.getNombre() + " de monto " + monto);
        if (clienteOrigen.puedeTransferir()) {
            this.transaccionOk();
        } else {
            this.transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transferencia no se pudo realizar");
    }
}
