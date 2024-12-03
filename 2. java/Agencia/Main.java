import clases.Repositorio;
import clases.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables
        Scanner console = new Scanner(System.in);
        Repositorio agencia = new Repositorio("Agencia nueva", new ArrayList(), new ArrayList());
        boolean run = true;
        while (run){
            System.out.println("Escoge una opcion");
            System.out.println("1. Crear un cliente");
            System.out.println("2. Crear un localizador");
            System.out.println("3. Ver localizadores por cliente");
            System.out.println("4. Calcular precio del localizador");
            System.out.println("5. Reservas totales");
            System.out.println("6. Salir");
            Integer option = Integer.parseInt(console.nextLine());
            System.out.println("---------------------------------------");
            if (option.equals(1)){
                System.out.println("Ingresa el nombre:");
                String name = console.nextLine();
                System.out.println("Ingresa el apellido:");
                String lastName = console.nextLine();
                System.out.println(agencia.addCliente(name, lastName));
            } else if (option.equals(2)) {
                System.out.println("Cuantos paquetes vas a agregar?");
                int paquetes = Integer.parseInt(console.nextLine());
                System.out.println("Ingresa el id del cliente:");
                int clienteId = Integer.parseInt(console.nextLine());
                System.out.println();
                List<Reserva> reservas = new ArrayList();
                for (int i = 0; i < paquetes; i++) {
                    System.out.println("tiene hotel? (true/false)");
                    boolean haveHotel = Boolean.parseBoolean(console.nextLine());
                    System.out.println("tiene vuelos? (true/false)");
                    boolean haveVuelos = Boolean.parseBoolean(console.nextLine());
                    System.out.println("tiene comida? (true/false)");
                    boolean haveComida = Boolean.parseBoolean(console.nextLine());
                    System.out.println("tiene transporte? (true/false)");
                    boolean haveTransporte = Boolean.parseBoolean(console.nextLine());
                    System.out.println("Ingresa el precio:");
                    double price = Double.parseDouble(console.nextLine());
                    reservas.add(new Reserva(price, haveHotel, haveComida, haveVuelos, haveTransporte));
                    System.out.println("---------------------------------------");
                }
                System.out.println(agencia.addLocalizador(clienteId, reservas));
            } else if (option.equals(3)) {
                System.out.println("Ingresa el id del cliente:");
                int clienteId = Integer.parseInt(console.nextLine());
                agencia.filterLocalizadoresByClient(clienteId);
                System.out.println("---------------------------------------");
            } else if (option.equals(4)) {
                System.out.println("Ingresa el id del localizador:");
                int localizadorId = Integer.parseInt(console.nextLine());
                agencia.calculatePriceByLocalizador(localizadorId);
            } else if (option.equals(5)) {
                System.out.println("Ingresa el id del cliente:");
                int clienteId = Integer.parseInt(console.nextLine());
            } else {
                break;
            }
        }
    }
}
