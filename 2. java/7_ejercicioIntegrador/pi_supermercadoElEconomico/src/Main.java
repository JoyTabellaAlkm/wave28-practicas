import model.Cliente;
import repository.ClienteRepository;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        Cliente cliente1 = new Cliente(123, "test", "demo");
        Cliente cliente2 = new Cliente(234, "test1", "demo1");
        Cliente cliente3 = new Cliente(654, "test3", "demo3");
        clienteRepository.crearCliente(cliente1);
        clienteRepository.crearCliente(cliente2);
        clienteRepository.crearCliente(cliente3);

        List<Cliente> clientes = clienteRepository.obtenerClientes();

        clientes.forEach(System.out::println);

        clienteRepository.eliminarCliente(cliente1);
        clientes.forEach(System.out::println);


        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el dni del cliente que desea buscar: ");
        Integer dni = teclado.nextInt();

        System.out.println(clienteRepository.buscarClientePorDNI(dni).toString());

    }
}