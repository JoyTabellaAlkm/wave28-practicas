import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Pepito","Perez","1231231");
        Cliente cliente2 = new Cliente("Maria","Salgado","2983232");
        Cliente cliente3 = new Cliente("Luna","Suarez","23429342");

        List<Cliente> clientes = new ArrayList<>(List.of(cliente1,cliente2,cliente3));

        System.out.println("\n*********====== Parte uno ======*********");
        System.out.println("\n====== Impresion de clientes ======");

        clientes.stream().forEach(System.out::println);

        System.out.println("\n====== Eliminacion de cliente dni 1231231 ======");

        clientes.removeIf(c -> c.getDni().equals("1231231"));
        clientes.stream().forEach(System.out::println);

        System.out.println("\n======  Consulta del clientes por dni ======");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Ingrese el dni del cliente que desea consultar: ");
        String  dni = scanner.next();

        Optional<Cliente> clienteConsulta = clientes.stream().filter((c) -> c.getDni().equals(dni)).findFirst();

        clienteConsulta.ifPresentOrElse(
            cliente->System.out.println("-> Cliente encontrado: "+ cliente),
            ()->System.out.println("-> Cliente no encontrado")
        );

    }
}