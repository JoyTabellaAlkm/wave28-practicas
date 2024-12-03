package practicaClasesAbstractasInterfaces.PracticaReservas;

import practicaClasesAbstractasInterfaces.PracticaReservas.Servicios.ClienteService;
import practicaClasesAbstractasInterfaces.PracticaReservas.entidades.Clientes;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();

        System.out.println("inicio del programa");
        Clientes nuevoCliente = clienteService.crearCliente("4040404040", "luciana");

        System.out.println("nuevo cliente: " + nuevoCliente);

        Optional<Clientes> clienteEncontrado = clienteService.consultaCliente("4040404040");

        System.out.println("busqueda de cliente: " + clienteEncontrado);

    }
}
