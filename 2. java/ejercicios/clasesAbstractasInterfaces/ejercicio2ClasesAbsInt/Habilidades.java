package ejercicios.clasesAbstractasInterfaces.ejercicio2ClasesAbsInt;

public class Habilidades {
    private String nombre;

    public Habilidades(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return STR."Habilidades: '\{nombre}'";
    }
}
