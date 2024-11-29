public class Main {
    public static void main(String[] args) {
        class PracticaExcepciones{
            private int a;
            private int b;

            public PracticaExcepciones(int a, int b) {
                this.a = a;
                this.b = b;
            }

            void calcularCociente(){
                double resultado;
                try {
                    resultado = this.b/this.a;
                    System.out.println(resultado);
                }catch (Exception e){
                    System.out.println("Se ha producido un error");
                }finally {
                    System.out.println("Programa finalizado");
                }
            }

            //Opcion 1
            void calcularCocienteIllExc(){
                double resultado;
                try {
                    resultado = this.b/this.a;
                    System.out.println(resultado);
                }catch (ArithmeticException e){
                    throw new IllegalArgumentException("No se puede dividir por 0");
                }finally {
                    System.out.println("Programa finalizado");
                }
            }

            //Opcion 2
            void calcularCocienteIllExc2(){
                double resultado;
                try {
                    if(a==0){throw new IllegalArgumentException("No se puede dividir por 0");}
                    resultado = b/a;
                    System.out.println(resultado);
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }finally {
                    System.out.println("Programa finalizado");
                }
            }
        }

        PracticaExcepciones practica = new PracticaExcepciones(0,300);
        practica.calcularCociente();
        practica.calcularCocienteIllExc2();
    }
}
