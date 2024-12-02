import java.util.Scanner;
//Escribe un programa en Java que solicite al usuario un número entero y determine si ese número es par o impar.


public class CalculoParImpar {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.println("Ingresar un numero entero");
        int numero=scanner.nextInt();
        if(numero%2==0){
            System.out.println("El numero es par");


        }
else {

System.out.println("El numero es impar");
        }
    }
}
