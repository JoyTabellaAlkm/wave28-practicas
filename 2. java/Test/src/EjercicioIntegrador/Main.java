package EjercicioIntegrador;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("123","Pepe","Argento");
        Cliente cliente2 = new Cliente("456","Pedro","Ramirez");
        Cliente cliente3 = new Cliente("789","Tomas","Gonzalez");

        //CREAR CLIENTES
        List<Cliente> clientes = new ArrayList<>(List.of(cliente1, cliente2, cliente3));
        //MOSTRAR CLIENTES
        clientes.stream().forEach(System.out::println);

        //ELIMINAR CLIENTE
        System.out.println("ELIMINO CLIENTE");
        clientes.remove(cliente1);
        clientes.stream().forEach(System.out::println);

        buscarCliente(clientes);



       Item item1 = new Item("999","Leche",5, 850.0);
       Item item2 = new Item("888","Queso",2, 500.0);
       Item item3 = new Item("777","Pan",1, 200.0);

       List<Item> items = new ArrayList<>(List.of(item1, item2, item3));

       Factura factura = new Factura(cliente2, items);
       System.out.println(factura);




    }

    public static void buscarCliente(List<Cliente> clientes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente:");
        String dniBuscado = sc.nextLine();

        Cliente clienteBuscado = clientes.stream().filter(cliente -> dniBuscado.equals(cliente.getDni())).findFirst().orElse(null);
        if (clienteBuscado != null)
            System.out.println(clienteBuscado);
        else
            System.out.println("El dni del cliente no existe");

    }
}
