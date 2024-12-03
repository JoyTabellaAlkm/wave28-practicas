package practicaClasesAbstractasInterfaces.supermercadoElEconomico;

import practicaClasesAbstractasInterfaces.supermercadoElEconomico.entidades.Cliente;
import practicaClasesAbstractasInterfaces.supermercadoElEconomico.repositorio.RepoClientes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RepoClientes repoClientes = new RepoClientes();

        Scanner input = new Scanner(System.in);
        List<Cliente> listaClientes = repoClientes.getListaClientes();

        listaClientes.add(new Cliente("Dario", "31218999"));
        listaClientes.add(new Cliente("Mario", "31218888"));
        listaClientes.add(new Cliente("Wario", "31218777"));

        for(Cliente cliente : listaClientes){
            System.out.println(cliente);
        }
        System.out.println("---------------------------------");
        System.out.println("Eliminamos el primero de la lista");
        System.out.println("---------------------------------");

        listaClientes.removeFirst();

        for(Cliente cliente : listaClientes){
            System.out.println(cliente);
        }

        System.out.println("---------------------------------");
        System.out.println("ingresar el dni del cliente: ");

        String dni;
        while (true) {
            dni = input.nextLine().trim();
            if (!dni.isEmpty()) {
                final String dniX = dni;
                Optional<Cliente> cliente = listaClientes.stream()
                        .filter(c -> {
                            boolean match = c.getDni().trim().equalsIgnoreCase(dniX.trim());
                            return match;
                        })
                        .findFirst();

                cliente.ifPresentOrElse(
                        c -> System.out.println("Cliente encontrado: " + c),
                        () -> System.out.println("No se encontró un cliente con el DNI ingresado.")
                );

                break;
            } else {
                System.out.println("El DNI no puede estar vacío. Intenta de nuevo: ");
            }
        }

    }
}
