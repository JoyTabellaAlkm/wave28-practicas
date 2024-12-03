import Clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1234, "Pedro", "Mosquera");
        Cliente cliente2 = new Cliente(4321, "Juan", "Dominguez");
        Cliente cliente3 = new Cliente(3142, "Gaston", "Suso");

        List<Cliente> clientes = new ArrayList<>(List.of(cliente1, cliente2, cliente3));

        clientes.forEach(System.out::println);

        System.out.print("Ingresa un dni de cliente: ");
        Scanner dniInput = new Scanner(System.in);
        int dni = dniInput.nextInt();

        Cliente clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getDni() == dni)
                .findFirst()
                .orElse(null);

        if (clienteEncontrado != null) {
            System.out.print("Cliente encontrado: " + clienteEncontrado);
        } else {
            System.out.print("No se encontro el cliente");
        }

        System.out.println();
        System.out.println("Eliminamos un cliente");
        clientes.remove(cliente1);
        clientes.forEach(System.out::println);
    }
}