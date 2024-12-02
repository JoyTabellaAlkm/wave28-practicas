package ejercicios.ejerciciosJava.ejercicio2;

public class Inscripciones {
    private int numeroInscripciones;
    private Categoria categoria;
    private Participante participante;
    private double abonoTotal;

    public Inscripciones(int numeroInscripciones, Categoria categoria, Participante participante, double abonoTotal) {
        this.numeroInscripciones = numeroInscripciones;
        this.categoria = categoria;
        this.participante = participante;
        this.abonoTotal = abonoTotal;
    }

    @Override
    public String toString() {
        return "Inscripciones{" +
                "numeroInscripciones=" + numeroInscripciones +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", abonoTotal=" + abonoTotal +
                '}';
    }
}
