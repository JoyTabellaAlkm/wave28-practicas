package banco;

public class Banco {
    public static void realizarTransferencia(Cliente clienteOrigen, Cliente clienteDestino, Double monto) {
        System.out.println("Realizando transferencia");
        Transferencia transferencia = new Transferencia(clienteOrigen, clienteDestino, monto);
    }
}
