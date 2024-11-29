package practica_carrera_selva.src.meli.practica.services;

import java.util.ArrayList;
import java.util.List;

import practica_carrera_selva.src.meli.practica.models.Categoria;
import practica_carrera_selva.src.meli.practica.models.Inscripcion;
import practica_carrera_selva.src.meli.practica.models.Participante;

public class CarreraService {
    private List<Categoria> categorias;
    private List<Inscripcion> inscripciones;

    public CarreraService(){
        categorias = new ArrayList<>();
        inscripciones = new ArrayList<>();

        categorias.add(new Categoria(1, "Circuito chico", "2 km por selva y arroyos."));
        categorias.add(new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro."));
        categorias.add(new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra."));
    }

    public void inscribirParticipante(Participante participante, int categoriaId){
        Categoria categoriaSeleccionada = null;
        for (Categoria categoria : categorias) {
            if (categoria.getId() == categoriaId) {
                categoriaSeleccionada = categoria;
                break;
            }
        }

        if (categoriaSeleccionada == null) {
            System.out.println("------------------------------------------");
            System.err.println("Categoría no encontrada.");
            return;
        }

        if (categoriaId ==  3 && participante.getEdad() < 18) {
            System.out.println("------------------------------------------");
            System.err.println("No se permiten menores de 18 años en el Circuito Avanzado.");
            return;
        }

        int numeroInscripcion = inscripciones.size() + 1;
        Inscripcion inscripcion = new Inscripcion(numeroInscripcion, categoriaSeleccionada, participante);
        inscripciones.add(inscripcion);

        System.out.println("------------------------------------------");
        System.out.println("Participante inscrito exitosamente.");
    }

    public void mostrarInscripcionesPorCategoria(int categoriaId) {
        System.out.println("Inscripciones para categoría ID " + categoriaId + ":");
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == (categoriaId)) {
                System.out.println(inscripcion);
            }
        }
    }

    public void desinscribirParticipante(int numeroInscripcion) {
        Inscripcion inscripcionAEliminar = null;
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getNumeroInscripcion() == numeroInscripcion) {
                inscripcionAEliminar = inscripcion;
                break;
            }
        }

        if (inscripcionAEliminar != null) {
            inscripciones.remove(inscripcionAEliminar);
            System.out.println("------------------------------------------");
            System.out.println("Participante desinscrito exitosamente.");
        } else {
            System.out.println("------------------------------------------");
            System.err.println("Número de inscripción no encontrado.");
        }
    }

    public double calcularTotalRecaudadoPorCategoria(int categoriaId) {
        double total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == categoriaId) {
                total += inscripcion.getMonto();
            }
        }
        return total;
    }

    public double calcularTotalRecaudado() {
        double total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            total += inscripcion.getMonto();
        }
        return total;
    }


}
