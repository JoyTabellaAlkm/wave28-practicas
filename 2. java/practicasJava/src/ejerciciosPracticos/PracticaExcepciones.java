package ejerciciosPracticos;

public class PracticaExcepciones {


    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            if(a==0){
                throw new IllegalArgumentException("No se puede dividir por 0.");
            }
            double cociente = b / a;
        }catch(ArithmeticException e) {
            System.out.println("Se ha producido un error");

        }finally {
            System.out.println("Programa finalizado");
        }
    }



}
