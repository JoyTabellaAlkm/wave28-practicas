
import ejIntegradores.ejIntegrador.model.Cliente;
import ejIntegradores.ejIntegrador.model.Factura;
import ejIntegradores.ejIntegrador.repository.ClienteRepository;
import ejIntegradores.ejIntegrador.repository.FacturaRepository;
import ejIntegradores.ejIntegrador.model.Item;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        FacturaRepository facturaRepository = new FacturaRepository(clienteRepository);
        Scanner scant = new Scanner(System.in);

        // Punto 2
        Cliente cliente1 = new Cliente("Rodriguez", "Juan", "42999282");
        Cliente cliente2 = new Cliente("Perez", "Maria", "42923122");
        Cliente cliente3 = new Cliente("Domingo", "Patricio", "429234324");

        clienteRepository.crear(cliente1);
        clienteRepository.crear(cliente2);
        clienteRepository.crear(cliente3);

        // Punto 3
        clienteRepository.mostrarTodos();

        // Punto 4
        System.out.println("Ingrese el DNI del cliente a eliminar: ");
        String dni = scant.nextLine();
        clienteRepository.eliminar(dni);
        clienteRepository.mostrarTodos();

        // Punto 5

        System.out.println("Ingrese el DNI del cliente a consultar: ");
        String otroDNI = scant.nextLine();
        Optional<Cliente> cliente = clienteRepository.buscar(otroDNI);
        if (cliente.isPresent()) {
            System.out.println(cliente.toString());
        } else {
            System.out.println("No se encontró un cliente con el DNI proporcionado");
        }

        // ---- PARTE 2 -----
        // Punto 6 y 7
        Item item1 = new Item("QSO", "Queso cremoso", 1.00, 4500.00);
        Item item2 = new Item("PAN", "Pan integral con semillas", 2.00, 1500.00);

        Factura facturaClienteBorrado = new Factura(cliente1, List.of(item1,item2), "21324");
        Factura facturaSinItems = new Factura(cliente2, List.of(), "123123");
        Factura facturaOk = new Factura(cliente2, List.of(item1,item2), "12341");
        facturaRepository.crear(facturaClienteBorrado);
        facturaRepository.crear(facturaSinItems);
        facturaRepository.crear(facturaOk);

        facturaRepository.mostrarTodos();

    }
}