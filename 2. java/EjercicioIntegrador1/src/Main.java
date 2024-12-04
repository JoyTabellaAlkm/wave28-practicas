import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Clases.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1234, "Pedro", "Mosquera");
        Cliente cliente2 = new Cliente(4321, "Juan", "Dominguez");
        Cliente cliente3 = new Cliente(3142, "Gaston", "Suso");

        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.crear(cliente1);
        clienteRepository.crear(cliente2);
        clienteRepository.crear(cliente3);

        List<Item> items = new ArrayList<>();

        System.out.print("Ingresa un dni de cliente: ");
        Scanner dniInput = new Scanner(System.in);
        int dni = dniInput.nextInt();

        Cliente clienteEncontrado = clienteRepository.buscarPorCodigo(dni);

        if (clienteEncontrado != null) {
            System.out.print("Cliente encontrado: " + clienteEncontrado);
        } else {
            System.out.print("No se encontro el cliente");
            System.out.println("Creando el cliente nuevo");
            System.out.println("Ingresar nombre del cliente: ");
            Scanner nombre = new Scanner(System.in);
            String nombreStr = nombre.next();
            System.out.println("Ingresar apellido del cliente: ");
            Scanner apellido = new Scanner(System.in);
            String apellidoStr = apellido.next();
            clienteEncontrado = new Cliente(dni, nombreStr, apellidoStr);
            clienteRepository.crear(clienteEncontrado);
        }

        List<Item> itemsFactura = new ArrayList<>(List.of(
                new Item(1, "Tomate", 1, 5),
                new Item(2, "Arroz", 1, 2),
                new Item(3, "Harina", 1, 7)
        ));

        double total = itemsFactura.stream()
                .mapToDouble(i -> i.getCostoUnitario() * i.getCantComprada())
                .sum();

        Factura factura = new Factura(1, clienteEncontrado, itemsFactura, total);

        System.out.println(factura);

        /* System.out.println();
        System.out.println("Eliminamos un cliente");
        clientes.remove(cliente1);
        clientes.forEach(System.out::println);*/


    }
}