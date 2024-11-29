public class PracticaExepciones {

    int a = 0;
    int b = 300;

    public int divide() {
        if (a != 0){
            return b / a;
        }
        else {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }
}
