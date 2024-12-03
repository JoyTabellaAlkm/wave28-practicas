package ejercicios.integradores.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente(4098263, "carolina", "schwab");
        Cliente cliente2 = new Cliente(4098863, "Mariana", "Rodriguez");
        Cliente cliente3 = new Cliente(4098663, "Luciana", "Gomez");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("Listado de clientes completos");
        for(Cliente cli : clientes){
            System.out.println(cli);
        }

        System.out.println("Eliminando cliente 1");
        clientes.remove(1);

        System.out.println("Listado de clientes actualziada");
        for(Cliente cli : clientes){
            System.out.println(cli);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar: ");
        int dni = sc.nextInt();

        Optional<Cliente> encontrado = clientes.stream()
                .filter(c -> c.getDni() == dni)
                .findFirst();

        if (encontrado.isPresent()){
            System.out.println(encontrado);
        }
        else {
            System.out.println("No se encontro a la persona");
        }
    }
}
