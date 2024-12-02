import java.util.Scanner;


public class EjercicioWhile {

    public static void main (String [] args) {
        Scanner scanner=new Scanner(System.in);
        int suma=0;
        System.out.println("ingresar numero:");
        int numero=scanner.nextInt();
        while(numero!=0){

            suma+=numero;
            System.out.println("ingresar numero:");
             numero=scanner.nextInt();
        }
        System.out.println("la suma total de los numeros ingresados es:"+ suma);


    }

}
