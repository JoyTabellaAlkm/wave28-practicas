import java.util.Scanner;
//Crear un programa que simule una calculadora básica.
//El programa debe pedir al usuario que ingrese dos números
//y una operación (suma, resta, multiplicación o división). Luego, debe realizar la operación correspondiente y mostrar el resultado por pantalla.

    public class Calculadora {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingresar primero numero:");
            int numero1 = scanner.nextInt();
            System.out.println("\n");
            System.out.println("Ingresar segundo numero:");
            int numero2 = scanner.nextInt();

            System.out.println("Ingresar operacion a realizar");
            String operacion = scanner.next();

            if (operacion.equals("suma")) {
                int resultado = numero1 + numero2;
                System.out.println("El resultado de la suma es: " + resultado);
            } else if (operacion.equals("resta")) {
                int resultado = numero1 - numero2;
                System.out.printf("El resultado de la resta es: " + resultado);
            } else if (operacion.equals("multiplicacion")) {
                int resultado = numero1 * numero2;
                System.out.println("El resultado de la multiplicación es: " + resultado);
            } else if (operacion.equals("division")) {
                if (numero2 != 0) { // Evitar división por cero
                    int resultado = numero1 / numero2;
                    System.out.println("El resultado de la división es: " + resultado);
                } else {
                    System.out.println("No se puede dividir por cero.");
                }
            } else {
                System.out.printf("Operación inválida.");
            }
        }
    }




