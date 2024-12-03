import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Supermercado {
    public static void main(String[] args) {
        // Parte 1
       Cliente cliente1 = new Cliente("111", "Lucas", "Perez");
       Cliente cliente2 = new Cliente("222", "Juan", "Lopez");
       Cliente cliente3 = new Cliente("333", "Agustin", "Gomez");

        List<Cliente> clientes = new ArrayList<>(List.of(cliente1, cliente2, cliente3));
        System.out.println("Creacion y muestra 3 clientes");
        clientes.forEach(System.out::println);

        System.out.println("\nEliminación cliente y muestra clientes restantes");
        clientes.remove(cliente1);
        clientes.forEach(System.out::println);

        System.out.println("\nIngrese un dni para buscar al cliente deseado: ");
        Scanner scanner = new Scanner(System.in);
        String dniIngresado = scanner.nextLine();

        Optional<Cliente> clienteHallado = clientes.
                stream().
                filter(c -> c.getDni().equals(dniIngresado)).
                findFirst();

        if (clienteHallado.isPresent()) {
            System.out.println(clienteHallado.get());
        } else {
            System.out.println("El cliente no existe para el dni ingresado");
        }

        // Fin parte 1
    }
}