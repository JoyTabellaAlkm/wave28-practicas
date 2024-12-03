import model.Cliente;

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
    public static void main(String[] args) {
        //region Ejercicio 2


        //endregion


        //region Ejercicio 3

        /*//creamos 3 clientes
        Cliente cli1 = new Cliente(12345678L, "Luisina", "De Paula");
        Cliente cli2 = new Cliente(762836745L, "Zlatan", "Ibrahimovic");
        Cliente cli3 = new Cliente(90987653L, "Avril", "Lavigne");
        //agregamos una collection
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cli1);
        listaClientes.add(cli2);
        listaClientes.add(cli3);

        for (Cliente c : listaClientes){
            System.out.printf("Dni: " + c.getDni());
            System.out.printf("Nombre: " + c.getNombre());
            System.out.printf("Apellido: " + c.getApellido());
        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a borrar");
        Long dniBorrado = teclado.nextLong();
        boolean bandera = false;

        for (Cliente c : listaClientes){
            if(c.getDni().equals(dniBorrado)){
                listaClientes.remove(c);
                bandera = true;
                break;
            }
        }
        if(bandera == false){
            System.out.println("No se encontro el cliente a borrar");
        }else{
            System.out.println("Cliente borrado correctamente");
        }

        System.out.println("Ingrese el dni buscar");
        Long dniBuscado = teclado.nextLong();

        bandera = false;
        for(Cliente c : listaClientes){
            if(c.getDni().equals(dniBuscado)){
                System.out.println("----Cliente encontrado, sus datos son: ");
                System.out.printf("Dni: " + c.getDni());
                System.out.printf("Nombre: " + c.getNombre());
                System.out.printf("Apellido: " + c.getApellido());
                break;
            }
        }
        if(bandera == false){
            System.out.println("Cliente no encontrado");
        }
*/
        //endregion Ejercicio 3

    }

}