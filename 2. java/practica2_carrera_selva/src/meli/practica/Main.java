package meli.practica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Map<String, String>> categorias = new HashMap<>();
        Map<String, String> categoria1 = new HashMap<>();
        Map<String, String> categoria2 = new HashMap<String, String>();
        Map<String, String> categoria3 = new HashMap<String, String>();

        categoria1.put("nombre", "Circuito Chico");
        categoria1.put("descripcion", "2km");

        categoria2.put("nombre", "Circuito Medio");
        categoria2.put("descripcion", "5km");

        categoria3.put("nombre", "Circuito Avanzado");
        categoria3.put("descripcion", "10km");

        categorias.put(1, categoria1);
        categorias.put(2, categoria2);
        categorias.put(3, categoria3);

        List<Map<String, Object>> participantes = new ArrayList<Map<String, Object>>();

        Map<String, Object> participante1 = new HashMap<String, Object>();
        Map<String, Object> participante2 = new HashMap<String, Object>();
        Map<String, Object> participante3 = new HashMap<String, Object>();

        participante1.put("id", 1);
        participante1.put("dni", 123456);
        participante1.put("nombre", "juan");
        participante1.put("apellido", "perez");
        participante1.put("edad", 17);
        participante1.put("telefono", 123456789);
        participante1.put("telefono_emergencia", 123456789);
        participante1.put("grupo_sanguineo", "O+");

        participante2.put("id", 2);
        participante2.put("dni", 123455);
        participante2.put("nombre", "pedro");
        participante2.put("apellido", "gomez");
        participante2.put("edad", 19);
        participante2.put("telefono", 123456789);
        participante2.put("grupo_sanguineo", "O-");

        participante3.put("id", 3);
        participante3.put("dni", 123454);
        participante3.put("nombre", "carla");
        participante3.put("apellido", "gonzalez");
        participante3.put("edad", 27);
        participante3.put("telefono", 123456789);
        participante3.put("grupo_sanguineo", "AB+");

        participantes.add(participante1);
        participantes.add(participante2);
        participantes.add(participante3);

        List<Map<String, Object>> inscripciones = new ArrayList<>();

        System.out.println("Inscripciones");
        inscribirParticipante(inscripciones, categorias, participante1, 3);
        inscribirParticipante(inscripciones, categorias, participante1, 1);
        inscribirParticipante(inscripciones, categorias, participante2, 3);
        inscribirParticipante(inscripciones, categorias, participante3, 2);
        System.out.println();

        System.out.println("Mostrar por categorias");
        mostrarParticipantesPorCategoria(inscripciones, categorias, participantes, 1);
        mostrarParticipantesPorCategoria(inscripciones, categorias, participantes, 2);
        mostrarParticipantesPorCategoria(inscripciones, categorias, participantes, 3);

        eliminarInscripcion(inscripciones, 1);
        System.out.println("Se elimina la inscripcion 1");
        mostrarParticipantesPorCategoria(inscripciones, categorias, participantes, 1);

        calcularRecaudacionTotal(inscripciones);

        System.out.println("Recaudación total: $" + calcularRecaudacionTotal(inscripciones));
    }

    public static void inscribirParticipante(List<Map<String, Object>> inscripciones,
                                       Map<Integer, Map<String, String>> categorias,
                                       Map<String, Object> participante,
                                       int idCategoria) {
        int edadParticipante = (int)participante.get("edad");
        double montoInscripcion;

        if (idCategoria == 1) {
            montoInscripcion = edadParticipante > 18 ? 1300 : 1500;
        }
        else if (idCategoria == 2) {
            montoInscripcion = edadParticipante > 18 ? 2000 : 2300;
        }
        else if (idCategoria == 3) {
            if (edadParticipante < 18) {
                System.out.println("El edad debe ser mayor que 18");
                return;
            }
            else {
                montoInscripcion = 2800;
            }
        }
        else {
            System.out.println("La categoria no existe");
            return;
        }

        Map<String, Object> inscripcion = new HashMap<>();
        inscripcion.put("numeroInscripcion", inscripciones.size() + 1);
        inscripcion.put("idCategoria", idCategoria);
        inscripcion.put("idParticipante", participante.get("id"));
        inscripcion.put("monto", montoInscripcion);
        inscripciones.add(inscripcion);

        System.out.println("Participante inscrito: " + participante.get("nombre") + " en " + categorias.get(idCategoria).get("nombre"));
    }

    public static void mostrarParticipantesPorCategoria(List<Map<String, Object>> inscripciones,
                                                        Map<Integer, Map<String, String>> categorias,
                                                        List<Map<String, Object>> participantes,
                                                        int idCategoria) {
        Map<String, String> categoria = categorias.get(idCategoria);

        for (Map<String, Object> inscripcion : inscripciones) {
            if ((int)inscripcion.get("idCategoria") == idCategoria) {
                int idParticipante = (int) inscripcion.get("idParticipante");
                Map<String, Object> participante = participantes.stream()
                        .filter(p -> (int) p.get("id") == idParticipante)
                        .findFirst()
                        .orElse(null);

                System.out.println("Nro de inscripcion: " + inscripcion.get("numeroInscripcion") + " Nombre: " + participante.get("nombre") + " en " + categoria.get("nombre") + " con el monto: " + inscripcion.get("monto"));
            }
        }
    }

    public static void eliminarInscripcion(List<Map<String, Object>> inscripciones, int idInscripcion) {
        inscripciones.removeIf(inscripcion -> (int) inscripcion.get("numeroInscripcion") == idInscripcion);
    }

    public static double calcularRecaudacionTotal(List<Map<String, Object>> inscripciones) {
        return inscripciones.stream()
                .mapToDouble(inscripcion -> (double) inscripcion.get("monto"))
                .sum();
    }
}