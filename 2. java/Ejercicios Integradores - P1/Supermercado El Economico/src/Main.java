import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear 3 clientes y guardarlos en una collection.
        Cliente cliente1 = new Cliente(123,"Bryan", "Muñoz");
        Cliente cliente2 = new Cliente(321,"Felipe", "Molina");
        Cliente cliente3 = new Cliente(213,"Leiner", "Manrique");
        List<Cliente> clientes = new ArrayList<>(List.of(cliente1,cliente2,cliente3));

        // Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        for(Cliente cliente: clientes){
            System.out.println(cliente);
        }
        System.out.println();

        //Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        clientes.remove(cliente2);
        for(Cliente cliente: clientes){
            System.out.println(cliente);
        }
        System.out.println();

        //Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingresa el dni del cliente: ");
        Integer dniEntrada = teclado.nextInt();

        Optional<Cliente> clienteEncontrado = clientes.stream().filter(cliente -> cliente.getDni().equals(dniEntrada)).findFirst();
        clienteEncontrado.ifPresent(System.out::println);
        if(clienteEncontrado.isEmpty()){
            System.out.println("Cliente con dni: " + dniEntrada + " no se encuentra en el sistema.");
        }



    }
}