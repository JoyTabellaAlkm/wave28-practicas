import classes.Cliente;
import classes.Factura;
import classes.Item;
import repositories.ClienteRepositorio;
import repositories.FacturaRepositorio;
import repositories.ItemsRepositorio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
        ItemsRepositorio itemsRepositorio = new ItemsRepositorio();
        FacturaRepositorio facturaRepositorio = new FacturaRepositorio();

        Cliente nico = new Cliente(1234, "Nico", "Dias");
        clienteRepositorio.guardar(nico);
        clienteRepositorio.guardar(new Cliente(5678, "Julian", "Alvarez"));
        clienteRepositorio.guardar(new Cliente(9012, "Enzo", "Perez"));
        clienteRepositorio.buscartodos().forEach(System.out::println);

        itemsRepositorio.guardar(new Item(9876, "leche", 1, 1000));
        itemsRepositorio.guardar(new Item(5432, "pan", 2, 1000));
        itemsRepositorio.guardar(new Item(1098, "azucar", 3, 1000));
        itemsRepositorio.guardar(new Item(7654, "cafe", 2, 1000));
        itemsRepositorio.guardar(new Item(3210, "mermelada", 1, 1000));
        itemsRepositorio.buscartodos().forEach(System.out::println);

        //CLIENTES
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni del Cliente que desea eliminar");
        int dniAEliminar = teclado.nextInt();
        clienteRepositorio.eliminar(dniAEliminar);
        clienteRepositorio.buscartodos().forEach(System.out::println);

        System.out.println("Ingrese el dni del Cliente que desea buscar");
        int dniABuscar = teclado.nextInt();

        Cliente cliente = clienteRepositorio.buscar(dniABuscar);
        System.out.println("Cliente encontrado");
        System.out.println(cliente);

        //FACTURA
        System.out.println("Ingrese el dni del Cliente al que le desea crear la factura");
        int dniABuscarParaFactura = teclado.nextInt();
        Cliente clienteFactura = clienteRepositorio.buscar(dniABuscar);
        System.out.println("Cliente encontrado");
        facturaRepositorio.guardar(new Factura(987654321, clienteFactura, itemsRepositorio.buscartodos()));

        Factura factura = facturaRepositorio.buscar(987654321);
        System.out.println("Factura encontrada");
        System.out.println(factura);
    }
}