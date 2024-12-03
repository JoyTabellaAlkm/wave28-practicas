package practicaClasesAbstractasInterfaces.PracticaReservas.Servicios;

import practicaClasesAbstractasInterfaces.PracticaReservas.entidades.Clientes;
import practicaClasesAbstractasInterfaces.PracticaReservas.repositorios.RepositorioLocalizadores;
import practicaClasesAbstractasInterfaces.PracticaReservas.repositorios.RespositorioClientes;

import java.util.Optional;

public class ClienteService implements Icliente {

    RespositorioClientes respositorioClientes = new RespositorioClientes();

    public ClienteService(RespositorioClientes respositorioClientes, RepositorioLocalizadores repositorioLocalizadores) {
        this.respositorioClientes = respositorioClientes;
    }

    public ClienteService() {
    }

    @Override
    public Clientes crearCliente(String nombre, String dni) {
        Clientes nuevoCliente = new Clientes(nombre, dni);
        respositorioClientes.listClientes.add(nuevoCliente);
        return nuevoCliente;
    }

    public Optional<Clientes> consultaCliente(String dni) {
        // Imprimir la lista de clientes para depuración
        System.out.println("Lista de clientes: " + respositorioClientes.getListClientes());
        // Realizar la búsqueda del cliente
        Optional<Clientes> cliente = respositorioClientes.getListClientes().stream()
                .filter(c -> c.getDni().trim().equalsIgnoreCase(dni.trim()))
                .findFirst();
        // Retornar el cliente encontrado (opcional)
        return cliente;
    }
}
