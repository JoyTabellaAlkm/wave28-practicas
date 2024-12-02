
import java.util.Scanner;

public class CalculadorConSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar primero numero:");
        int numero1 = scanner.nextInt();
        System.out.println("\n");
        System.out.println("Ingresar segundo numero:");
        int numero2 = scanner.nextInt();

        System.out.println("Ingresar operacion a realizar (+, -, *, /):");
        String operacion = scanner.next();

        try {
            switch (operacion) {
                case "suma":
                    System.out.println("El resultado de la suma es: " + (numero1 + numero2));
                    break;
                case "resta":
                    System.out.println("El resultado de la resta es: " + (numero1 - numero2));
                    break;
                case "multiplicar":
                    System.out.println("El resultado de la multiplicación es: " + (numero1 * numero2));
                    break;
                case "dividir":
                    if (numero2 != 0) {
                        System.out.println("El resultado de la división es: " + (numero1 / numero2));
                    } else {
                        throw new ArithmeticException("División por cero");
                    }
                    break;
                default:
                    System.out.println("Operación inválida.");
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}