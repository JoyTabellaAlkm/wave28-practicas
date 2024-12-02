import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Map<String, String>> categorias = inicializarCategorias();
        Map<Integer, List<Map<String, Object>>> inscripcionesPorCategoria = inicializarInscripciones();
        agregarIncripciones(inscripcionesPorCategoria, categorias);

        // Mostrar inscripciones agrupadas por categorias
        mostrarInscripcionesPorCategoria(inscripcionesPorCategoria);

        // Eliminar participantes
        Map<Integer, List<Map<String, Object>>> inscripcionesActualizadas = eliminarInscriptosYMostrar(inscripcionesPorCategoria);

        // Mostrar totales por categoría
        mostrarTotalesPorCategoria(inscripcionesActualizadas);
    }

    public static Map<Integer, Map<String, String>> inicializarCategorias() {
        return Map.of(
                1, Map.of("nombre", "Circuito chico", "descripcion", "2 km por selva y arroyos"),
                2, Map.of("nombre", "Circuito medio", "descripcion", "5 km por selva, arroyos y barro"),
                3, Map.of("nombre", "Circuito avanzado", "descripcion", "10 km por selva, arroyos, barro y escalada en piedra")
        );
    }

    public static Map<Integer, List<Map<String, Object>>> inicializarInscripciones() {
        Map<Integer, List<Map<String, Object>>> mapInscripciones = new HashMap<>();
        mapInscripciones.put(1, new ArrayList<>());
        mapInscripciones.put(2, new ArrayList<>());
        mapInscripciones.put(3, new ArrayList<>());
        return mapInscripciones;
    }

    public static void agregarIncripciones(Map<Integer, List<Map<String, Object>>> inscripcionesPorCategoria, Map<Integer, Map<String, String>> categorias) {
        Scanner scanner = new Scanner(System.in);
        String continuarAgregandoInscriptos = "s";
        int numeroInscripcion = 1;

        while (continuarAgregandoInscriptos.equals("s")) {
            Map<String, Object> participante = new HashMap<>();

            System.out.print("Ingrese el número de participante: ");
            participante.put("numeroParticipante", scanner.nextInt());
            scanner.nextLine();

            System.out.print("Ingrese el nombre: ");
            participante.put("nombre", scanner.nextLine());

            System.out.print("Ingrese la edad: ");
            participante.put("edad", scanner.nextInt());
            scanner.nextLine();

            System.out.print("Id de categoría de circuito: ");
            int categoriaId = scanner.nextInt();
            scanner.nextLine();

            double montoAbonar = calcularMonto(categoriaId, (int) participante.get("edad"));
            if (montoAbonar == -1) {
                System.out.println("Inscripción no permitida para este circuito y edad.");
                continue;
            }

            inscripcionesPorCategoria.get(categoriaId).add(Map.of(
                    "numeroInscripcion", numeroInscripcion,
                    "categoria", categorias.get(categoriaId),
                    "participante", participante,
                    "monto", montoAbonar
            ));
            System.out.print("¿Desea realizar otra inscripción? (s/n): ");
            continuarAgregandoInscriptos = scanner.nextLine();
            numeroInscripcion++;
        }
    }

    public static double calcularMonto(int categoriaId, int edad) {
        switch (categoriaId) {
            case 1:
                return (edad < 18) ? 1300 : 1500;
            case 2:
                return (edad < 18) ? 2000 : 2300;
            case 3:
                return (edad >= 18) ? 2800 : -1;
            default:
                return -1;
        }
    }

    public static Map<Integer, List<Map<String, Object>>> eliminarInscriptosYMostrar(Map<Integer, List<Map<String, Object>>> inscripcionesPorCategoria) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("¿Desea quitar participantes? (s/n):");
            if (!scanner.nextLine().equals("s"))
                break;

            System.out.println("Ingrese número de participante a desinscribir:");
            int nroParticipanteADesinscribir = scanner.nextInt();
            scanner.nextLine();

            eliminarParticipanteDeCategorias(inscripcionesPorCategoria, nroParticipanteADesinscribir);

            System.out.println("Participante eliminado correctamente.");
        }

        mostrarInscripcionesPorCategoria(inscripcionesPorCategoria);
        return inscripcionesPorCategoria;
    }

    public static void eliminarParticipanteDeCategorias(Map<Integer, List<Map<String, Object>>> inscripcionesPorCategoria,
                                                        int nroParticipanteADesinscribir) {
        for (List<Map<String, Object>> listaInscripciones : inscripcionesPorCategoria.values()) {
            for (int i = 0; i < listaInscripciones.size(); i++) {
                Map<String, Object> inscripcion = listaInscripciones.get(i);
                Map<String, Object> participante = (Map<String, Object>) inscripcion.get("participante");

                if (participante.get("numeroParticipante").equals(nroParticipanteADesinscribir)) {
                    listaInscripciones.remove(i);
                    break;
                }
            }
        }
    }

    public static void mostrarInscripcionesPorCategoria(Map<Integer, List<Map<String, Object>>> inscripcionesPorCategoria) {
        for (Map.Entry<Integer, List<Map<String, Object>>> entry : inscripcionesPorCategoria.entrySet()) {
            List<Map<String, Object>> listaInscripciones = entry.getValue();
            Map<String, String> categoria = inicializarCategorias().get(entry.getKey());

            System.out.println("-------------------------------------");
            System.out.println("CATEGORÍA: " + categoria.get("nombre"));
            System.out.println("-------------------------------------");

            for (Map<String, Object> inscripcion : listaInscripciones) {
                Map<String, Object> participante = (Map<String, Object>) inscripcion.get("participante");
                System.out.println("Participante: " + participante.get("nombre"));
                System.out.println("Número de participante: " + participante.get("numeroParticipante"));
                System.out.println("Edad: " + participante.get("edad"));
                System.out.println("Monto: " + inscripcion.get("monto"));
                System.out.println("---");
            }
        }
    }

    public static void mostrarTotalesPorCategoria(Map<Integer, List<Map<String, Object>>> inscripcionesPorCategoria) {
        for (Map.Entry<Integer, List<Map<String, Object>>> entry : inscripcionesPorCategoria.entrySet()) {
            List<Map<String, Object>> listaInscripciones = entry.getValue();
            Map<String, String> categoria = inicializarCategorias().get(entry.getKey());

            System.out.println("-------------------------------------");
            System.out.println("CATEGORÍA: " + categoria.get("nombre"));

            double total = 0;
            for (Map<String, Object> inscripcion : listaInscripciones) {
                total += (double) inscripcion.get("monto");
            }

            System.out.println("TOTAL RECAUDADO: " + total);
            System.out.println("-------------------------------------");
        }
    }
}