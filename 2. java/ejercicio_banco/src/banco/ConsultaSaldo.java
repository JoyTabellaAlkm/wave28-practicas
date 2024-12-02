package banco;

public class ConsultaSaldo implements ITransaccion {
    public ConsultaSaldo(Cliente cliente) {
        System.out.println("Realizando consulta de saldo");
        if (cliente.puedeConsultarSaldo()) {
            this.transaccionOk();
        } else {
            this.transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizado con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La consulta de saldo no se pudo realizar");
    }
}
