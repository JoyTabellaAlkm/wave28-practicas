import Clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("42517138", "Paloma", "Sosa");
        Cliente cliente2 = new Cliente("1234567", "Melania", "Simes");
        Cliente cliente3 = new Cliente("987654", "Mateo", "Ferre");

        //Agregando clientes a una collection
        List<Cliente> clientes = new ArrayList<>(List.of(cliente1, cliente2, cliente3));

        //Imprimiendo la lista
        System.out.println("Lista original");
        clientes.forEach(x -> System.out.println(x));

        //Borrando un cliente
        clientes.removeIf(x -> x.getDni().equals("42517138"));

        //Imprimiendo nuevamente la lista
        System.out.println("\nLista con un elemento borrado");
        clientes.forEach(System.out::println);

        //Solicitando un número por teclado para buscar un cliente con ese dni
        System.out.println("\nEscriba el dni");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        //boolean existe = clientes.stream().anyMatch(x->x.getDni().equals(input));

        //Buscando un cliente que matchee y mostrando el mensaje en consola
        Cliente c = clientes.stream()
                .filter(x->x.getDni().equals(input))
                .findFirst()
                .orElse(null);

        String mensaje = c == null ? "No hay un registro con el dni " + input : c.toString();
        System.out.println(mensaje);
    }
}
