import java.util.Scanner;
//Calcula el perímetro y el área de un rectángulo dadas su base y altura.

public class OperacionesAritmeticas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la base del rectángulo: ");
        float base = scanner.nextFloat();
        System.out.print("Ingrese la altura del rectángulo: ");
        float altura = scanner.nextFloat();

        float perimetro = 2 * (base + altura);
        float area = base * altura;

        System.out.println("El perímetro del rectángulo es: " + perimetro);
        System.out.println("El área del rectángulo es: " + area);


    }
}