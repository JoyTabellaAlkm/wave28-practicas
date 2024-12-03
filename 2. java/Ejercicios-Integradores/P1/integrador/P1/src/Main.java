import clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Cliente cliente1 = new Cliente(11111111, "Juan", "Perez");
        Cliente cliente2 = new Cliente(22222222, "Maria", "Lopez");
        Cliente cliente3 = new Cliente(33333333, "Pedro", "Rodriguez");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        clientes.forEach(System.out::println);

        clientes.remove(cliente2);
        clientes.forEach(System.out::println);

        System.out.print("Ingrese el dni del cliente: ");
        int dniIngresado = scanner.nextInt();

        encontrarCliente(dniIngresado, clientes);

    }

    public static void encontrarCliente(int dni, List<Cliente> clientes) {
        Optional<Cliente> cliente = clientes.stream().filter(cl -> cl.getDni() == dni).findFirst();

        if(cliente.isEmpty()) {
            System.out.println("El cliente no se encuentra en la lista");
        }
        else {
            System.out.println(cliente);
        }
    }
}