import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // --------
        List<Cliente> clientes = new ArrayList<>(List.of(
         new Cliente(1234,"nadi","jasky"),
         new Cliente(456,"rosa","ferrari"),
         new Cliente(789,"ivanna","petrovna")
        ));
        System.out.println("Clientes");
        clientes.forEach(System.out::println);
        // --------
        clientes.removeFirst();

        System.out.println("Clientes con uno eliminado");
        clientes.forEach(System.out::println);

        // --------
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar DNI de cliente:");
        int dniIngresado = scanner.nextInt();
        scanner.nextLine();
        Cliente clienteEncontrado = clientes.stream()
                .filter(x -> x.getDni() == dniIngresado)
                .findFirst()
                .orElse(null);

        String mensaje = clienteEncontrado != null ? clienteEncontrado.toString() : "No se encontró el cliente";
        System.out.println(mensaje);
    }
}
