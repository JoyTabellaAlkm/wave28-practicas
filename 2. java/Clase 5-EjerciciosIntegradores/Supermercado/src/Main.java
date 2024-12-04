import com.company.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("123","Luisina","Gomez");
        Cliente cliente2 = new Cliente("456","Camil","Perez");
        Cliente cliente3 = new Cliente("789","Joha","Bella");

        List<Cliente> listaCliente = new ArrayList<Cliente>();
        listaCliente.add(cliente1);
        listaCliente.add(cliente2);
        listaCliente.add(cliente3);

        for(Cliente cliente : listaCliente ){
            System.out.println(cliente.toString());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI de la persona a eliminar: ");
        String dniEliminado = scanner.next();

        for(Cliente cliente : listaCliente ){
            if(cliente.getDni().equals(dniEliminado)){
                listaCliente.remove(cliente);
                break;
            }
        }
    }
}