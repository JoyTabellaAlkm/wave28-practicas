package supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Cliente cliente1 = new Cliente("Pilar", "Innocenti", 39267425);
        Cliente cliente2 = new Cliente("Lucas", "Charlab", 39278675);
        Cliente cliente3 = new Cliente("Maria", "Innocenti", 42000555);

        List<Cliente> clientes = new ArrayList<Cliente>();
    // Agrego los 3 clientes
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
    //Elimino un cliente
        clientes.remove(cliente2);

        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }

        Scanner scanner = new Scanner(System.in);

    //Solicito un número de DNI

        System.out.println("Introduce el DNI del cliente que quieres buscar");

        double dniIngresado = scanner.nextDouble();

        //Filtro por DNI, si no encuentra nada el count va a estar en cero ya que me cuenta la cantidad de elementos filtrados

        double count = clientes.stream().filter(c -> c.dni == dniIngresado).peek(System.out::println).count();

        if(count == 0){
            System.out.println("No se encontró un cliente con el DNI ingresado.");
        }
    }
}
