import clases.*;

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


        // P2 de ejercicios de integracion
        CrudCliente repositorioCliente = new CrudCliente();
        guardarCliente(repositorioCliente, cliente1);
        guardarCliente(repositorioCliente, cliente2);
        guardarCliente(repositorioCliente, cliente3);

        // probar excepcion
        guardarCliente(repositorioCliente, cliente1);

        // creo items
        CrudItem repositorioItem = new CrudItem();
        Item item1 = new Item(1, "Galletitas", 10, 10);
        Item item2 = new Item(2, "Pan", 5, 5);
        Item item3 = new Item(3, "Gaseosa", 3, 20.5);
        Item item4 = new Item(4, "Carne", 10, 100);
        Item item5 = new Item(5, "Lapiz", 2, 5);

        agregarItem(repositorioItem, item1);
        agregarItem(repositorioItem, item2);
        agregarItem(repositorioItem, item3);
        agregarItem(repositorioItem, item4);
        agregarItem(repositorioItem, item5);

        CrudFactura repositorioFactura = new CrudFactura();
        double total = calcularTotalFactura(repositorioItem.getItems());
        Factura factura = new Factura(1, cliente1, repositorioItem.getItems(), total);
        guardarFactura(repositorioFactura, factura);

        System.out.println(factura);

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

    public static void guardarCliente(CrudCliente repositorio, Cliente cliente) {
        try {
            repositorio.create(cliente);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void guardarFactura(CrudFactura repositorio, Factura factura) {
        try {
            repositorio.create(factura);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void agregarItem(CrudItem repositorio, Item item) {
        try {
            repositorio.create(item);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static double calcularTotalFactura(List<Item> items) {
        return items.stream().mapToDouble(item -> item.getCantComprada() * item.getCostoUnitario()).reduce(0, Double::sum);
    }

}