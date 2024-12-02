package ejercicios.ejercicio2ClasesAbsInt;

public interface Imprimible {
    static String imprimir(Imprimible i) {
        return i.toString();
    }
}
