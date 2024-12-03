package com.example.EjerciciosIntegradores_parte1.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupermercadoMain {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("22333555", "Maria", "Nunez");
        Cliente cliente2 = new Cliente("44666888", "Paloma", "Sosa");
        Cliente cliente3 = new Cliente("11555888", "Alejandra", "Sanchez");

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        listaClientes.forEach(c -> System.out.println(c.toString()));

        System.out.println("---------------------------- se elimina un cliente:");
        listaClientes.remove(cliente2);
        listaClientes.forEach(c -> System.out.println(c.toString()));

        System.out.println("---------------------------- ingresar un dni para buscar:");
        Scanner scanner = new Scanner(System.in);
        String dniIngresado = scanner.nextLine();
        Cliente clienteEncontrado = listaClientes.stream().filter(c -> c.getDni().equals(dniIngresado)).findFirst().orElse(null);
        if (clienteEncontrado == null){
            System.out.println("Cliente no encontrado");
        }
        System.out.println(clienteEncontrado);

        //---------------PARTE DOS -------------------------------------------
        RepoClientes repoClientes = new RepoClientes();

        repoClientes.agregarCliente(cliente1);
        repoClientes.agregarCliente(cliente1);

        Producto p1 = new Producto("A1-2345", "Papitas fritas", 2, 100.0);
        Producto p2 = new Producto("A1-6789", "Coca Cola Light", 1, 1500.0);
        Producto p3 = new Producto("A1-7789", "Pan de molde", 1, 500.0);

        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);

        Factura factura = new Factura(cliente1,listaProductos);


    }
}
