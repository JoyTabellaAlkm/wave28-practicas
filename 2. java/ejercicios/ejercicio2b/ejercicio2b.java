package ejercicios.ejercicio2b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ejercicio2b {

    private static Map<String, Map<String, Object>> categorias = new HashMap<>();
    private static Map<Integer, Map<String, Object>> inscripciones = new HashMap<>();


    public static void inicializarCategorias() {
        Map<String, Object> categoriaChico = new HashMap<>();
        categoriaChico.put("nombre", "Chico");
        categoriaChico.put("descripcion", "2 km por selva y arroyos");
        categoriaChico.put("inscriptos", new ArrayList<>());
        categorias.put("chico", categoriaChico);

        Map<String, Object> categoriaMedio = new HashMap<>();
        categoriaMedio.put("nombre", "Medio");
        categoriaMedio.put("descripcion", "5 km por selva, arroyos y barro");
        categoriaMedio.put("inscriptos", new ArrayList<>());
        categorias.put("medio", categoriaMedio);

        Map<String, Object> categoriaAvanzado = new HashMap<>();
        categoriaAvanzado.put("nombre", "Avanzado");
        categoriaAvanzado.put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra");
        categoriaAvanzado.put("inscriptos", new ArrayList<>());
        categorias.put("avanzado", categoriaAvanzado);
    }

    public static void inscribirParticipante(int numeroInscripcion, String nombre, String apellido,
                                              int edad, String dni, String celular, String grupoSanguineo,
                                              String categoria) {
        if (categoria.equals("avanzado") && edad < 18) {
            System.out.println("ENo se permite la inscripcion al circuito avanzado a menores de 18");
        }
        else {
            Map<String, Object> inscripcion = new HashMap<>();
            inscripcion.put("numeroInscripcion", numeroInscripcion);
            inscripcion.put("nombre", nombre);
            inscripcion.put("apellido", apellido);
            inscripcion.put("edad", edad);
            inscripcion.put("dni", dni);
            inscripcion.put("celular", celular);
            inscripcion.put("grupoSanguineo", grupoSanguineo);
            inscripcion.put("categoria", categoria);

            int abono = 0;
            if (edad > 18) {
                switch (categoria) {
                    case "chico":
                        abono = 1500;
                    case "medio":
                        abono = 2300;
                    case "avanzado":
                        abono = 2800;
                }
            } else {
                switch (categoria) {
                    case "chico":
                        abono = 1300;
                    case "medio":
                        abono = 2000;
                    case "avanzado":
                        abono = 2800;
                }
            }
            inscripcion.put("monto", abono);
            inscripciones.put(numeroInscripcion, inscripcion);

            List<Map<String, Object>> inscriptos = (List<Map<String, Object>>)categorias.get(categoria).get("inscriptos");
            inscriptos.add(inscripcion);
        }
    }

    public static void mostrarInscriptos(String categoria) {
        List<Map<String, Object>> inscriptos = (List<Map<String, Object>>) categorias.get(categoria).get("inscriptos");
        System.out.println("Inscriptos en la categoría " + categoria + ":");
        for (Map<String, Object> participante : inscriptos) {
            System.out.println("Número de inscripción: " + participante.get("numeroInscripcion"));
            System.out.println("Nombre: " + participante.get("nombre") + " " + participante.get("apellido"));
            System.out.println("Edad: " + participante.get("edad"));
            System.out.println("Monto a abonar: $" + participante.get("monto"));
            System.out.println("-----------------------------------");
        }
    }

    public static void desinscribirParticipante(int numeroInscripcion, String categoria) {
        if (!inscripciones.containsKey(numeroInscripcion)) {
            System.out.println("Participante no encontrado.");
        }
        else {
            List<Map<String, Object>> inscriptos = (List<Map<String, Object>>)categorias.get(categoria).get("inscriptos");
            inscriptos.removeIf(participante -> participante.get("numeroInscripcion").equals(numeroInscripcion));
            inscripciones.remove(numeroInscripcion);
            System.out.println("Participante eliminado con exito.");
        }
    }

    public static void calcularTotalRecaudado(){
        int totalRecaudado = 0;
        for (Map.Entry<String, Map<String, Object>> entry : categorias.entrySet()) {
            List<Map<String, Object>> inscritos = (List<Map<String, Object>>) entry.getValue().get("inscriptos");
            int montoCategoria = 0;

            for (Map<String, Object> participante : inscritos) {
                montoCategoria += (int) participante.get("monto");
            }

            System.out.println("Monto recaudado en la categoría " + entry.getValue().get("nombre") + ": $" + montoCategoria);
            totalRecaudado += montoCategoria;
        }

        System.out.println("Monto total recaudado: $" + totalRecaudado);
    }

    public static void main(String[] args) {

        inicializarCategorias();

        // Crear algunos participantes e inscribirlos
        inscribirParticipante(1, "Carlos", "Perez", 21, "123456789", "11223344", "A+", "chico");
        inscribirParticipante(2, "Laura", "Gomez", 17, "987654321", "22334455", "O-", "medio");
        inscribirParticipante(3, "Juan", "Martinez", 22, "1122334455", "33445566", "B+", "avanzado");

        // Mostrar todos los inscriptos en una categoría
        mostrarInscriptos("chico");

        // Desinscribir un participante
        desinscribirParticipante(2, "medio");

        // Mostrar los inscriptos después de la desinscripción
        mostrarInscriptos("medio");

        // Calcular los montos recaudados
        calcularTotalRecaudado();

    }
}
