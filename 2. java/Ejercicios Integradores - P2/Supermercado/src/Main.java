import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear 3 clientes y guardarlos en una collection.
        Cliente cliente1 = new Cliente(123,"Bryan", "Muñoz");
        Cliente cliente2 = new Cliente(321,"Felipe", "Molina");
        Cliente cliente3 = new Cliente(213,"Leiner", "Manrique");
        List<Cliente> clientes = new ArrayList<>(List.of(cliente1,cliente2,cliente3));

        // Será necesario crear una lista de items
        Item manzana = new Item("C1", "Manzana", 1.0, 1000.0);
        Item banano = new Item("C2", "Banano", 1.0, 800.0);
        Item papasMargarita = new Item("C3", "Papas Margarita", 1.0, 2500.0);
        List<Item> items = new ArrayList<>(List.of(manzana,banano,papasMargarita));

        // crear cliente
        Factura nuevaFactura = new Factura(new Cliente())







    }
}