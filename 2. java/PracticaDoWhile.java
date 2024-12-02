
//4-Pedir números al usuario hasta que ingrese 0:Utiliza un bucle do-while para pedir números al usuario y sumarlos hasta
// que el usuario ingrese 0.Utiliza un bucle do-while para pedir números al usuario y sumarlos hasta que el usuario ingrese 0.

import java.util.Scanner;
public class PracticaDoWhile {

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        int suma=0;
        int numero;
        System.out.println("Ingres números (ingresa 0 para terminar):");

        do {
            numero = scanner.nextInt();
            suma += numero;
        } while (numero != 0);

        System.out.println("La suma total de los números ingresados es: " + suma);


    }
}







