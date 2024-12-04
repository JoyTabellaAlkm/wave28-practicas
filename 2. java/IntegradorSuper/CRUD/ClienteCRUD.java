package CRUD;

import Clases.Cliente;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClienteCRUD implements ICRUD <Cliente> {

    public ClienteCRUD() {}

    @Override
    public Cliente create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("INgrese DNI");
        int dni = scanner.nextInt();
        scanner.nextLine();
        System.out.println("INgrese nombre");
        String nombre = scanner.nextLine();
        System.out.println("INgrese apellido");
        String apellido = scanner.nextLine();
        System.out.println();

        return new Cliente(dni,nombre,apellido);
    }

    @Override
    public void delete(List<Cliente> lista, int id) {

        Cliente c = buscar(lista,id);
        if(c != null){
            lista.remove(c);
            System.out.println("Eliminado correctmente");
        }
    }

    @Override
    public Cliente buscar(List<Cliente> clientes, int id) {
        List<Cliente> clie = clientes.stream().filter(c -> c.getDni() == id).toList();
        try {
            clie.getFirst();
            return clie.getFirst();
        }catch (NoSuchElementException ex){
            return null;
        }
    }

    @Override
    public void listarTodos(List<Cliente> lista) {
        System.out.println(lista);
    }
}
