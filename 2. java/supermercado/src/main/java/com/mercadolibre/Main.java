package com.mercadolibre;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("1234", "Andrés", "Baquero"));
        clientes.add(new Cliente("5678", "Leonardo", "Hernández"));
        clientes.add(new Cliente("9012", "Patricio", "Estrella"));

        System.out.println("Todos los clientes");
        clientes.stream().forEach(System.out::println);
        clientes.remove(0);
        System.out.println("Se elimina un cliente");
        clientes.stream().forEach(System.out::println);

        Scanner s = new Scanner(System.in);
        System.out.println("Digite el DNI del cliente a buscar: ");
        String dni = s.nextLine();

        clientes.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> {
                    System.out.println("El cliente no existe");
                });

        s.close();
    }
}
