package ejercicios.ejercicio2ClasesAbsInt;

public class Curriculum implements Imprimible{
    private Persona p;

    public Curriculum(Persona p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return STR."Curriculum: \{p}";

    }
}
