package practica_carrera_selva.src.meli.practica.models;

public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    private double calcularMonto() {
        int edad = participante.getEdad();
        int categoriaId = categoria.getId();

        switch (categoriaId) {
            case 1:
                return (edad < 18) ? 1300 : 1500;
            case 2:
                return (edad < 18) ? 2000 : 2300;
            case 3:
                if (edad < 18) {
                    throw new IllegalArgumentException("Menores de 18 años no pueden inscribirse en el Circuito Avanzado.");
                }
                return 2800;
            default:
                throw new IllegalArgumentException("ID de categoría desconocida.");
        }
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Inscripcción " + numeroInscripcion + ": Categoría: " + categoria.getNombre() + " - Participante: " + participante.getNombre() + " " + participante.getApellido() + " - Monto: " + monto;
    }

}
