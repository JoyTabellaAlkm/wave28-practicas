import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // --------
        List<Cliente> clientes = new ArrayList<>(List.of(
                new Cliente(1234, "nadi", "jasky"),
                new Cliente(456, "rosa", "ferrari"),
                new Cliente(789, "ivanna", "petrovna")
        ));
        System.out.println("Clientes");
        clientes.forEach(System.out::println);
        // --------
        clientes.removeFirst();

        System.out.println("Clientes con uno eliminado");
        clientes.forEach(System.out::println);

        // --------
        //voy a reutilizar este punto para la parte II, y usar el siguiente cliente para crearle la factura
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar DNI de cliente a realizar factura:");
        int dniIngresado = scanner.nextInt();
        scanner.nextLine();
        Cliente clienteEncontrado = clientes.stream()
                .filter(x -> x.getDni() == dniIngresado)
                .findFirst()
                .orElse(null);

        System.out.println(clienteEncontrado != null ? clienteEncontrado.toString() :
                "No se encontró el cliente, será creado para crearle la factura");

        // PARTE II
        if (clienteEncontrado == null) {
            System.out.println("Ingresar nombre para nuevo cliente:");
            String nombre = scanner.nextLine();
            System.out.println("Ingresar apellido para nuevo cliente:");
            String apellido = scanner.nextLine();
            clienteEncontrado = new Cliente(dniIngresado, nombre, apellido);
        }

        // creo lista de items
        List<Item> items = new ArrayList<Item>(List.of(new Item("12321412", "tomate", 22, 1),
                new Item("123", "queso rallado", 100, 2),
                new Item("1", "agua", 25, 5),
                new Item("12", "servilletas", 10, 4)));

        Factura factura = new Factura(clienteEncontrado, items);

        // BONUS
        // CRUD
        while (true){

        }

    }
}
