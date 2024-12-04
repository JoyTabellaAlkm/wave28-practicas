package com.mercadolibre;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteRepository();

        clienteRepository.save(new Cliente("1234", "Andrés", "Baquero"));
        clienteRepository.save(new Cliente("5678", "Leonardo", "Hernández"));
        clienteRepository.save(new Cliente("9012", "Patricio", "Estrella"));

        System.out.println("Todos los clientes");
        clienteRepository.findAll()
                .stream()
                .forEach(System.out::println);
        clienteRepository.delete("9012");

        System.out.println("Se elimina un cliente");
        clienteRepository.findAll()
                .stream()
                .forEach(System.out::println);

        Scanner s = new Scanner(System.in);
        System.out.println("Digite el DNI del cliente a buscar: ");
        String dni = s.nextLine();

        Cliente cliente = clienteRepository.findByKey(dni);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("El cliente no existe.");
        }

        s.close();

        List<Factura> facturas = List.of();
        List<Item> facturaItems = List.of(new Item(3, "Tomate", 2, 200), new Item(15, "Cebolla", 5, 400));
        facturas.add(new Factura(clienteRepository.findByKey(dni), facturaItems));
    }
}
