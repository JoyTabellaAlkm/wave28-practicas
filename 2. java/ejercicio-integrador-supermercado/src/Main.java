import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Parte 1
        Cliente cliente1 = new Cliente("111", "Lucas", "Perez");
        Cliente cliente2 = new Cliente("222", "Juan", "Lopez");
        Cliente cliente3 = new Cliente("333", "Agustin", "Gomez");

        List<Cliente> clientes = new ArrayList<>(List.of(cliente1, cliente2, cliente3));
        System.out.println("Creacion y muestra 3 clientes");
        clientes.forEach(System.out::println);

        System.out.println("\nEliminación cliente y muestra clientes restantes");
        clientes.remove(cliente1);
        clientes.forEach(System.out::println);

        System.out.println("\nIngrese un dni para buscar al cliente deseado: ");
        Scanner scanner = new Scanner(System.in);
        String dniIngresado = scanner.nextLine();

        Optional<Cliente> clienteHallado = clientes.
                stream().
                filter(c -> c.getDni().equals(dniIngresado)).
                findFirst();

        if (clienteHallado.isPresent()) {
            System.out.println(clienteHallado.get());
        } else {
            System.out.println("El cliente no existe para el dni ingresado");
        }

        // Fin parte 1

        // Parte 2
        Supermercado supermercado = new Supermercado();
        Item item1 = new Item("ABC", "Celular", 5, 2000.0);
        Item item2 = new Item("DCE", "Arroz", 2, 100.0);

        List<Item> items = new ArrayList<>(List.of(item1, item2));

        supermercado.setClientes(clientes);
        supermercado.setItems(items);

        try {

            // Creamos una factura valida, con cliente valido (existente)
            Factura facturaValida = new Factura(cliente2, items);
            supermercado.crearFactura(facturaValida);

            System.out.println("\nFacturas creadas: ");
            System.out.println(supermercado.getFacturas());

            // Creamos factura invalida, con cliente no existente
            Factura facturaInvalida = new Factura(cliente1, items);
            supermercado.crearFactura(facturaInvalida);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
