package Repositorios;

import Model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements CrudRepository<Cliente>{
    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void crear(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrarInformacion() {
        clientes.forEach(System.out::println);

        /*for (Cliente c : clientes) {
            System.out.println("Dni: " + c.getDni() + "Nombre: " + c.getNombre() + "Apellido: " + c.getApellido());
        }*/
    }

    @Override
    public void eliminar(Long dni) {
        clientes.removeIf(cliente -> cliente.getDni().equals(dni));
        clientes.forEach(System.out::println);

    }

    @Override
    public void consultar(Long dni) {
        Cliente encontrarCliente = clientes.stream().filter(c-> c.getDni().equals(dni)).findFirst().orElse(null);
        if (encontrarCliente==null) {
            System.out.println("cliente no encontrado");
        } else {
            System.out.println("Cliente encontrado " + encontrarCliente);
        }
    }
}
