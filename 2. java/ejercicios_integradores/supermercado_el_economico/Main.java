package ejercicios_integradores.supermercado_el_economico;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // === PARTE 1 ===
        Scanner scanner = new Scanner(System.in);
        Cliente cliente1 = new Cliente("Caraballo", "11222333", "Lucas");
        Cliente cliente2 = new Cliente("Caraballo", "11222334", "Juan");
        Cliente cliente3 = new Cliente("Caraballo", "11222335", "Matias");

        Map<String, Cliente> clienteMap = new HashMap<>();
        clienteMap.put(cliente1.getDni(), cliente1);
        clienteMap.put(cliente2.getDni(), cliente2);
        clienteMap.put(cliente3.getDni(), cliente3);

        // Imprimir clientes
        System.out.println("========== Clientes ==========");
        clienteMap.values().forEach(System.out::println);

        // Eliminación por DNI
        System.out.println("========== Borrado de cliente por DNI ==========");
        System.out.print("Ingrese el DNI (sin guiones ni espacios): ");
        String dniBorrado = scanner.next();
        Cliente clienteEncontradoABorrar = clienteMap.get(dniBorrado);
        if(clienteEncontradoABorrar != null) {
            clienteMap.remove(clienteEncontradoABorrar.getDni());
        } else {
            System.out.println("No se encontró al cliente con el DNI: " + dniBorrado);
        }

        // Imprimir clientes
        System.out.println("========== Clientes ==========");
        clienteMap.values().forEach(System.out::println);

        // Busco por DNI

        System.out.println("========== Búsqueda cliente por DNI ==========");
        System.out.print("Ingrese el DNI (sin guiones ni espacios): ");
        String dni = scanner.next();
        Cliente clienteEncontrado = clienteMap.get(dni);
        if(clienteEncontrado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("No se encontró al cliente con el DNI: " + dni);
        }
        // === FIN PARTE 1 ===
    }
}
