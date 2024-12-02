
//Ejercicios básicos
//1-Imprimir los números del 1 al 10:
//2-Calcular la suma de los números del 1 al 100:
// 3-Imprimir la tabla de multiplicar de un número: Pide al usuario que ingrese un número y utiliza un bucle for
// para imprimir la tabla de multiplicar de ese número.


import java.util.Scanner;

public class PracticaBucles {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);

        }
int suma=0;
        for(int j=1;j<=100;j++){

            suma=suma+j;

        }
        System.out.println("La suma total de los numeros del 1 al 100 es:" + suma);

        Scanner scanner=new Scanner (System.in);

        System.out.println("Ingresa un numero por pantalla:");
        int numero= scanner.nextInt();

        System.out.println("Tabla de multiplicar:");
        for(int l=0;l<=10;l++) {

            int multiplicar=numero*l;
            System.out.println(multiplicar);
        }

    }
}















