public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void quotient(){
        try {
            if(this.a == 0) throw new IllegalArgumentException("No se puede dividir por cero");
            double quotient = this.b/ this.a;
            System.out.println(quotient);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones data = new PracticaExcepciones();
        data.quotient();
    }
}
