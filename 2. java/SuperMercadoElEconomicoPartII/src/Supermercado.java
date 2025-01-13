import model.Cliente;
import model.Factura;
import model.Item;
import repository.ClienteImp;
import repository.FacturaImp;
import repository.ItemImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {

        ClienteImp clienteImp = new ClienteImp();
        Scanner scanner = new Scanner(System.in);

        Cliente cliente1 = new Cliente(1234L, "Cristhian", "Santamaria");
        Cliente cliente2 = new Cliente(324L, "Dayana", "Rodriguez");
        Cliente cliente3 = new Cliente(9576L, "Fernando", "Manero");

        clienteImp.agregar(cliente1);
        clienteImp.agregar(cliente2);
        clienteImp.agregar(cliente3);

        System.out.println(clienteImp.listar());

        System.out.println("Ingrese el dni que desea eliminar");
        Long dniEliminado = scanner.nextLong();
        clienteImp.eliminar(dniEliminado);

        System.out.println(clienteImp.listar());

        System.out.println("Ingrese el dni que desea buscar");
        Long dniBuscar = scanner.nextLong();
        Cliente clienteEncontrado = clienteImp.buscar(dniBuscar);

        if (clienteEncontrado != null){
            System.out.println("El cliente ha sido encontrado\n"+ clienteEncontrado);
        }else {
            System.out.println("El cliente con dni "+ dniBuscar+" No ha sido encontrado.");
        }

        //Item
        Item item1 = new Item(6567L, "gaseosa", 2, 2500);
        Item item2 = new Item(653467L, "pan", 6, 600);
        Item item3 = new Item(65167L, "aceite", 1, 1600);

        ItemImp itemImp = new ItemImp();

        itemImp.agregar(item1);
        itemImp.agregar(item2);
        itemImp.agregar(item3);

        System.out.println(itemImp.listar());

        System.out.println("Ingrese el dni que desea eliminar");
        Long codigoItemEliminado = scanner.nextLong();
        itemImp.eliminar(codigoItemEliminado);

        System.out.println(itemImp.listar());

        System.out.println("Ingrese el dni que desea buscar");
        Long codigoItemBuscar = scanner.nextLong();
        Item itemEncontrado = itemImp.buscar(codigoItemBuscar);

        if (itemEncontrado != null){
            System.out.println("El item ha sido encontrado\n"+ itemEncontrado);
        }else {
            System.out.println("El item con dni "+ codigoItemBuscar+" No ha sido encontrado.");
        }

        //Factura
        Factura factura1 = new Factura(1001L, cliente1, List.of(item1, item2));
        Factura factura2 = new Factura(1002L, cliente2, List.of(item3));
        Factura factura3 = new Factura(1003L, cliente3, List.of(item1, item3));

        FacturaImp facturaImp = new FacturaImp();

        facturaImp.agregar(factura1);
        facturaImp.agregar(factura2);
        facturaImp.agregar(factura3);

        System.out.println(facturaImp.listar());

        System.out.println("Ingrese el código de factura que desea eliminar");
        Long codigoFacturaEliminada = scanner.nextLong();
        facturaImp.eliminar(codigoFacturaEliminada);

        System.out.println(facturaImp.listar());

        System.out.println("Ingrese el código de factura que desea buscar");
        Long codigoFacturaBuscar = scanner.nextLong();
        Factura facturaEncontrada = facturaImp.buscar(codigoFacturaBuscar);

        if (facturaEncontrada != null) {
            System.out.println("La factura ha sido encontrada\n" + facturaEncontrada);
        } else {
            System.out.println("La factura con código " + codigoFacturaBuscar + " No ha sido encontrada.");
        }

        scanner.close();
    }
}