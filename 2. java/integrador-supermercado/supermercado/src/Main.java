import Model.Cliente;
import Model.Factura;
import Model.Producto;
import Repositorios.ClienteRepository;
import Repositorios.FacturaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        FacturaRepository facturaRepository = new FacturaRepository();

        //creamos 3 clientes
        Cliente cliente1 = new Cliente(12345L, "Noel", "Campos");
        Cliente cliente2 = new Cliente(67890L, "Simon", "Carvallo");
        Cliente cliente3 = new Cliente(11223L, "Toby", "Campos");

        //agregamos los clientes a una colleccion
        /*List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3); se comenta para la parte 2*/


        clienteRepository.crear(cliente1);
        clienteRepository.crear(cliente2);
        clienteRepository.crear(cliente3);
        clienteRepository.mostrarInformacion(); //con esto se muestra la info de clientes

        //imprimir clientes
        //clientes.forEach(System.out::println) se comenta para la parte2;

        //eliminar un cliente
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el dni para eliminar: ");
        Long dniEliminar = Long.valueOf(sc.next());
        /*clientes.removeIf(cliente -> cliente.getDni().equals(dniEliminar));
        clientes.forEach(System.out::println); se comenta para la parte2*/
        clienteRepository.eliminar(dniEliminar);

        //pedir DNI por consola
        System.out.println("Ingrese el dni de un cliente: ");
        Long dni = Long.valueOf(sc.next());

        //Cliente encontrarCliente = clientes.stream().filter(c-> c.getDni().equals(dni)).findFirst().orElse(null);
        /*if (encontrarCliente==null) {
            System.out.println("cliente no encontrado");
        } else {
            System.out.println("Cliente encontrado " + encontrarCliente);
        }*/

        clienteRepository.consultar(dni);


        //TODO PARTE2
        //crear un producto
        Producto producto1 = new Producto(1L,"arroz",2,100);
        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);


        //crear una factura

        Factura factura1 = new Factura(1L,cliente1, productos);
        facturaRepository.crear(factura1);
        facturaRepository.mostrarInformacion();

    }
}