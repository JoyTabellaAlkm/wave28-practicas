import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("1234", "Cristhian", "Santamaria"));
        clientes.add(new Cliente("324", "Dayana", "Rodriguez"));
        clientes.add(new Cliente("9576", "Fernando", "Manero"));

        System.out.println("Lista de Clientes: ");
        clientes.forEach(System.out::println);

        System.out.println("Eliminar cliente: ");
        clientes.removeIf(cliente -> cliente.getDni().equals("1234"));

        System.out.println("Lista de clientes actualizada");
        clientes.forEach(System.out::println);

        System.out.println("Ingrese un numero para buscar un cliente");
        String dniBuscado = scanner.nextLine();

        Cliente clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniBuscado))
                .findFirst()
                .orElse(null);

        if(clienteEncontrado != null){
            System.out.println("Cliente encontrado: "+ clienteEncontrado);
        }else {
            System.out.println("Cliente con DNI "+ dniBuscado + " No encontrado.");
        }

        scanner.close();
    }
}