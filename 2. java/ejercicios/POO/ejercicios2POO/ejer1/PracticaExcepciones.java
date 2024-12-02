package ejercicios.POO.ejercicios2POO.ejer1;

public class PracticaExcepciones {


    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        try {
            if(a==0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            double res = b/a;
        }
        catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }

}
