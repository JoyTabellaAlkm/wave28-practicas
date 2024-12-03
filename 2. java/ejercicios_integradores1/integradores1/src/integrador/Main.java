package integrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>(List.of(
                new Cliente("123456789", "Tomas", "Peiretti"),
                new Cliente("987654321", "Juan", "Perez"),
                new Cliente("471926592", "Fran", "Pepe")
        ));
        clientes.forEach(c -> System.out.println(String.format("%s %s - %s", c.getNombre(), c.getApellido(), c.getDni())));
        clientes.remove(1);
        clientes.forEach(c -> System.out.println(String.format("%s %s - %s", c.getNombre(), c.getApellido(), c.getDni())));

        buscarCliente(clientes);

        // PARTE 2
        Item i1 = new Item(1l, "Queso", 10, 100);
        Item i2 = new Item(2l, "Milanesa", 2, 300);
        Cliente cli = new Cliente("884712", "Pepe", "Francisco");
        List<Item> listaItems = List.of(i1, i2);

        if (!clientes.contains(cli))
            clientes.add(cli);
        Factura factura = new Factura(cli, listaItems,
                listaItems.stream().map(i -> i.getCantidad()*i.getCostoUnitario()).reduce(Double::sum).orElse(0d));

    }

    public static void buscarCliente(List<Cliente> clientes) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese un DNI:");
        String dni = in.next();

        clientes.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst()
                .ifPresentOrElse(c -> System.out.println(String.format("Cliente encontrado: %s %s", c.getNombre(), c.getApellido())),
                        () -> System.out.println("El cliente con el DNI indicado no existe"));
    }
}
