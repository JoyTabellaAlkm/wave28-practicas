package com.bootcamp;

    /*    Supermercado “El económico”

        Un supermercado desea implementar un sistema, que le permita almacenar los datos de sus clientes y distintas facturas
                de las compras que los mencionados realicen. Para esto,  necesita poder realizar operaciones de creación,
                consulta, eliminación o actualización de datos de  todos los clientes y sus respectivas facturas asociadas.

        De cada cliente se registran: dni, nombre y apellido. Por otro lado, las facturas que se generan cuando
                un cliente hace una compra contienen a un cliente, una lista de ítems y el total de la compra.
                De cada item o producto se guarda el código, nombre, cantidad comprada y costo unitario.

        Dada la complejidad que posee el sistema, el Project Manager que dirige el proyecto ha decidido realizarlo en dos
                sprints, donde cada uno de ellos tendrá como objetivo una entrega final de una serie de requerimientos.

        Parte I

        Se necesita:

        Crear el modelo de clases clases que conforman, una factura, los cuales son: Cliente, Item, Factura. listo
        Crear 3 clientes y guardarlos en una collection. listo
        Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos. listo
        Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente
        se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.

     */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Cliente buscarClientePorDni(ArrayList<Cliente> lista, String dni) {
        return lista.stream()
                .filter(cliente -> cliente.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        // write your code here

        // Crear 3 clientes y guardarlos en una collection.
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        Cliente cliente1 = new Cliente("11111111", "Fermin", "Gonzalez");
        Cliente cliente2 = new Cliente("22222222", "Lucas", "Tesla");
        Cliente cliente3 = new Cliente("33333333", "Martin", "Bianchi");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        // Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }

        // Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        listaClientes.remove(1);

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }

        // Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente
        // se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
        // Crear un objeto Scanner para leer datos de la consola
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el DNI del cliente que deseas buscar: ");
        String dniABuscar = scanner.nextLine();

        Cliente clienteEncontrado = buscarClientePorDni(listaClientes, dniABuscar);

        System.out.println( Cliente.mostrarCliente(clienteEncontrado));


    }
}
