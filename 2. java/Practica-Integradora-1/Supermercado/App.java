package com.ejemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // creo los clientes
        Cliente cliente1 = new Cliente("30.923.201", "Pedro", "Albornoz");
        Cliente cliente2 = new Cliente("32.828.307", "Angela", "Martinez");
        Cliente cliente3 = new Cliente("27.291.738", "Matias", "Perez");

        List<Cliente> clientes = new ArrayList<>(List.of(cliente1, cliente2, cliente3));

        // imprimo los datos de los 3 clientes
        clientes.stream().forEach(cliente -> System.out.println(cliente.toString()));
        ;

        // elimino el cliente 2 (Angela)
        boolean fueRemovido = clientes.remove(cliente2);
        if (!fueRemovido) {
            // manejar el caso que no se pudo remover (cliente not found / throw error)
        }

        // imprimo los datos de los clientes restantes
        clientes.stream().forEach(cliente -> System.out.println(cliente.toString()));
        ;

        // buscar cliente por DNI
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un DNI a buscar: ");
        String dniABuscar = scanner.nextLine();

        Optional<Cliente> clienteBuscado = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniABuscar))
                .findFirst();

        if (!clienteBuscado.isPresent()) {
            // no se encontro cliente, manejar esta situacion
            System.out.println("No se encontro el cliente.");
        } else {
            // imprimo por pantalla el cliente encontrado
            System.out.println(clienteBuscado.get().toString());
        }

        // ===== PARTE 2
        Cliente nuevoCliente = new Cliente("28.203.182", "Marco", "Marquez");
        boolean clienteYaRegistrado = clientes.contains(nuevoCliente);

        if (!clienteYaRegistrado) {
            // registrar al cliente
            clientes.add(nuevoCliente);
        }

        Item compra1 = new Item(1, "Alfajor", 5, 500);
        Item compra2 = new Item(2, "Chocolate", 2, 150);
        List<Item> comprasCliente = new ArrayList<>(List.of(compra1, compra2));

        Factura factura = new Factura(nuevoCliente, comprasCliente);

    }
}
