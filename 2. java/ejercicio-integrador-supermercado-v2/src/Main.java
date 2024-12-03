import Model.Cliente;
import Model.Factura;
import Model.Item;
import Repository.RepositorioCliente;
import Repository.RepositorioFactura;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Inicializar repos
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioFactura repositorioFactura = new RepositorioFactura();

        // Creación de clientes
        repositorioCliente.create(new Cliente("00000000", "Juan", "Pérez"));
        repositorioCliente.create(new Cliente("00000001", "Rodrigo", "Martínez"));
        repositorioCliente.create(new Cliente("00000002", "Luis", "Miguel"));
        System.out.println("Clientes antes de la eliminación:");
        System.out.println(repositorioCliente.getAll());
        System.out.println(" ");

        // Eliminación de cliente
        repositorioCliente.delete("00000002");
        System.out.println("Clientes después de la eliminación:");
        System.out.println(repositorioCliente.getAll());

        // Creación de factura para el cliente 00000000
        Cliente cliente = repositorioCliente.getOne("00000000");
        repositorioFactura.create(new Factura("1", cliente, List.of(
                new Item("1", "Leche", 1, 1500),
                new Item("2", "Harina", 1, 1000),
                new Item("3", "Huevo", 6, 300)
        )));
        System.out.println("Costo total de la compra:");
        System.out.println(repositorioFactura.getOne("1").getTotalCompra());
    }
}