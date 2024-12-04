import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainSupermercado {
    //MAIN SECUENCIAL
    // public static void main(String[] args) {
    //     // ---- CREACIÓN DE CLIENTES ----
    //     Cliente c1 = new Cliente("43702625","Ignacio","Scocco");
    //     Cliente c2 = new Cliente("45214521","Pity","Martinez");
    //     Cliente c3 = new Cliente("42675679","Gabriel","Mercado");
    //     List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(c1,c2,c3));
    //     listaClientes.stream().forEach(System.out::println);
        
    //     //elimino el 2do cliente
    //     System.out.println("---- Lista con cliente eliminado ----");
    //     listaClientes.remove(c2);
    //     listaClientes.stream().forEach(System.out::println);

    //     // ---- SOLICITAR CLIENTE POR DNI ----
    //     // Scanner scanner = new Scanner(System.in);
    //     // System.out.print("Ingrese el DNI a buscar: ");
    //     // String dniBuscado = scanner.nextLine();    

    //     // Optional<Cliente> clienteEncontrado = listaClientes.stream().filter(a -> a.getDni().equals(dniBuscado))
    //     // .findFirst(); //Uso Optional o podría usar un .oerElse(null) para evitar valores nulos

    //     // if (clienteEncontrado.isPresent()) {
    //     //     System.out.println("Cliente encontrado: "+clienteEncontrado.get());
    //     // } else {
    //     //     System.out.println("No existe un cliente con el DNI ingresado");
    //     // }

    //     //PARTE 2
    //     System.out.println("\n---- Lista de facturas ----");
    //     // CREACIÓN DE ITEMS
    //     Item i1 = new Item("123", "PC",2,100.0);
    //     Item i2 = new Item("124", "Teclado",4,10.0);
    //     List<Item> listItem = new ArrayList<Item>(Arrays.asList(i1, i2));
    //     // CREACIÓN DE FACTURAS
    //     Factura fact1 = new Factura(c3, listItem);
    //     System.out.println(fact1);
    //     // Colección de facturas
    //     List<Factura> listaFacturas = new ArrayList<>();
    //     if(listaClientes.contains(fact1.getCliente())){
    //         listaFacturas.add(fact1);
    //     }else{
    //         listaClientes.add(fact1.getCliente());
    //         listaFacturas.add(fact1);
    //     }     
    // }

    //MAIN CON CRUD;
    public static void main(String[] args) {
        System.out.println("------- Creación de clientes --------");
        Cliente c1 = new Cliente(123L, "Mateo", "Ferradans");
        Cliente c2 = new Cliente(456L, "Jorge", "Fausto");
        ClienteCRUD c_crud= new ClienteCRUD();
        c_crud.create(c1.getDni(), c1);
        c_crud.read(c1.getDni());
        c_crud.read(c2.getDni());
        
    }
}
