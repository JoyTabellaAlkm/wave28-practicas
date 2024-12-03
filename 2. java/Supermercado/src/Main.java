import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("José", "Gómez", "11222333");
        Cliente cliente2 = new Cliente("Juan", "Fernández", "22333444");
        Cliente cliente3 = new Cliente("Pedro", "García", "33444555");

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        System.out.println("===== Lista de clientes original ======");
        listaClientes.forEach(System.out::println);

        listaClientes.remove(cliente1);
        System.out.println("===== Lista de clientes sin Cliente1 ======");
        listaClientes.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese DNI a buscar: ");
        String dni = scanner.next();

        //String dni = "33444555";
        Cliente clienteEncontrado = listaClientes.stream().filter((Cliente c) -> c.getDni().equals(dni)).findFirst().orElse(null);

        if(clienteEncontrado != null) {
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("Cliente no encontrado. Verifique el DNI.");
        }
    }
}