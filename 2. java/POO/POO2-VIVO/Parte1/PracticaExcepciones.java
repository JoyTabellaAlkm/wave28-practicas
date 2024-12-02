public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public int calcular() {
        if (a == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero!");
        }
        return b / a;
    }
}
