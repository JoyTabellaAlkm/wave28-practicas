import Model.Cliente;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente("00000000", "Juan", "Pérez");
        Cliente c2 = new Cliente("00000001", "Manuel", "López");
        Cliente c3 = new Cliente("00000002", "Martín", "Ramírez");

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        for(Cliente c: listaClientes) {
            System.out.println(c.toString());
        }

        System.out.println(" ");
        System.out.println("******Eliminar******");

        listaClientes.remove(2);
        for(Cliente c: listaClientes) {
            System.out.println(c.toString());
        }


        System.out.println("Ingresar DNI:");
        Scanner s = new Scanner(System.in);
        String dni = s.nextLine();

        boolean isClient = false;
        for(Cliente c: listaClientes) {
            if(c.getDni().equals(dni)){
                System.out.println(c.toString());
                isClient = true;
                break;
            }
        }

        if(!isClient) {
            System.out.println("No se ha encontrado el cliente.");
        }


    }
}