import model.Cliente;
import repository.ClienteImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //region Ejercicio 1
    /*public class Ejercicio1 {

        public static int[] burbuja(int[] array) {
            int n = array.length;
            boolean intercambio;

            for (int paso = 0; paso < n - 1; paso++) {
                intercambio = false;
                for (int i = 0; i < n - paso - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        intercambio = true;
                    }
                }
                if (!intercambio) {
                    break;
                }
            }

            return array;
        }

        public static void main(String[] args) {
            int[] array = {5, 2, 9, 1, 5, 6};
            burbuja(array);
            imprimirArreglo(array);
        }

        public static void imprimirArreglo(int[] array) {
            for (int elemento : array) {
                System.out.print(elemento + " ");
            }
        }
    }*/
    //endregion
    public static <clienteImp> void main(String[] args) {


        //region Ejercicio 3
        ClienteImp cliImp = new ClienteImp();
        Scanner teclado = new Scanner(System.in);
        //creamos 3 clientes
        Cliente cli1 = new Cliente(12345678L, "Luisina", "De Paula");
        Cliente cli2 = new Cliente(762836745L, "Zlatan", "Ibrahimovic");
        Cliente cli3 = new Cliente(90987653L, "Avril", "Lavigne");

        cliImp.save(cli1);
        cliImp.mostrarPantalla();
        Long dniBuscado = teclado.nextLong();
        cliImp.buscar(dniBuscado);

        System.out.println("Ingrese el dni para eliminar");
        Long dniBorrado = teclado.nextLong();
        cliImp.eliminar(dniBorrado);

    }

}