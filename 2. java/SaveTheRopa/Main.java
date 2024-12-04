import clases.GuardaRopa;
import clases.Prenda;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        GuardaRopa guardaRopa = new GuardaRopa(1, new HashMap<>());
        while (true){
            System.out.println("Ingrese una opcion valida:");
            System.out.println("1. Agregar prendas al guardaropa");
            System.out.println("2. Mostrar prendas");
            System.out.println("3. Devolver prendas");
            int option = Integer.parseInt(console.nextLine());
            System.out.println("-----------------------------------------");
            if (option == 1){
                System.out.println("cuantas prendas va a ingresar?");
                int numeroDePrendas = Integer.parseInt(console.nextLine());
                List<Prenda> listaDePrenda = new ArrayList();
                for (int i = 0; i < numeroDePrendas; i++) {
                    System.out.println("Ingrese la marca:");
                    String marca = console.nextLine();
                    System.out.println("Ingrese el modelo:");
                    String modelo = console.nextLine();
                    listaDePrenda.add(new Prenda(marca, modelo));
                    System.out.println("-----------------------------------------");
                }
                guardaRopa.guardarPrendas(listaDePrenda);
            } else if (option == 2) {
                guardaRopa.mostrarPrendas();
                System.out.println("-----------------------------------------");
            } else if (option == 3) {
                System.out.println("Ingrese el identificador de las prendas");
                int id = Integer.parseInt(console.nextLine());
                System.out.println(guardaRopa.devolverPrendas(id));
                System.out.println("-----------------------------------------");
            }else {
                break;
            }
        }
    }
}
