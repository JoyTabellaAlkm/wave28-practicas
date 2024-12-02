import java.util.Scanner;


public class pruebaswitch {

    public static void main(String[] args){

    Scanner scanner=new Scanner (System.in);
    System.out.println("Ingresar primer numero:");
    float numero1= scanner.nextFloat();

    System.out.println("Ingresar numero dos:");
    float numero2=scanner.nextFloat();

    System.out.println("Ingresar la oepracion a realizar:");
    String operacion= scanner.next();

    try {
        switch (operacion) {
            case "suma":
                System.out.println("el resultado de la operacion es:" + (numero1 + numero2));
                break;
            case "resta":
                System.out.println("El resulatdo de la oepracion es:" + (numero1 - numero2));
                break;
            case "multiplicar":
                System.out.println("El resulatdo de la operacion es:" + (numero1 * numero2));
                break;
            case "dividir":
                if(numero2!=0) {
                    System.out.println("El resultado de la oepracion es:" + (numero1 / numero2));
                }else {
                    throw new ArithmeticException("División por cero");
                }
                break;
            default:
                System.out.println("Ingreso invalido");
        }
    }catch (ArithmeticException e) {
        System.out.println("Error: " + e.getMessage());

        }

    }

}


