import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Map<String, String>> categorias = Map.of(
                1, Map.of("nombre", "Circuito chico",
                        "descripcion", "2 km por selva y arroyos"),
                2, Map.of("nombre", "Circuito medio",
                        "descripcion", "5 km por selva, arroyos y barro"),
                3, Map.of("nombre", "Circuito avanzado",
                        "descripcion", "10 km por selva, arroyos, barro y escalada en piedra")
        );

        Map<Integer, Map<String, Object>> inscripciones = new HashMap<>();
        Map<String, List<Map<String, Object>>> inscripcionesPorCategoria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String continuar = "s";
        int numeroInscripcion = 1;
        while (continuar.equals("s")) {
            Map<String, Object> participante = new HashMap<>();

            System.out.print("Ingrese el número de participante: ");
            participante.put("numeroParticipante", scanner.nextInt());
            scanner.nextLine();

            System.out.print("Ingrese el nombre: ");
            participante.put("nombre", scanner.nextLine());

            System.out.print("Ingrese la edad: ");
            participante.put("edad", scanner.nextInt());
            scanner.nextLine();

            //hago la inscripcion
            System.out.print("Id de categoria de circuito: ");
            int categoriaId = scanner.nextInt();
            scanner.nextLine();

            double montoAbonar = calcularMonto(categoriaId, (int)participante.get("edad"));
            if (montoAbonar == -1) {
                System.out.println("Inscripción no permitida para este circuito y edad.");
                continue;
            }

            Map<String,Object> inscripcion = Map.of(
                    "categoria", categorias.get(categoriaId),
                    "participante", participante,
                    "monto", montoAbonar);
            inscripciones.put(numeroInscripcion, inscripcion);

            String categoriaNombre = categorias.get(categoriaId).get("nombre");
            if (!inscripcionesPorCategoria.containsKey(categoriaNombre))
                inscripcionesPorCategoria.put(categoriaNombre, new ArrayList<>());
            inscripcionesPorCategoria.get(categoriaNombre).add(inscripcion);

            System.out.print("¿Desea realizar otra inscripcion? (s/n): ");
            continuar = scanner.nextLine();
            numeroInscripcion++;
        }

        // muestreo
        mostrarInscripcionesPorCategoria(inscripcionesPorCategoria);
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

    public static void mostrarInscripcionesPorCategoria(Map<String, List<Map<String, Object>>> mapInscripcionesPorCategoria){
        for (Map.Entry<String, List<Map<String, Object>>> entrada : mapInscripcionesPorCategoria.entrySet()) {
            List<Map<String, Object>> listaInscripciones = entrada.getValue();

            System.out.println("CATEGORIA: " + entrada.getKey());
            for (Map<String, Object> inscripcion : listaInscripciones) {
                Map<String, Object> participante = (Map<String, Object>) inscripcion.get("participante");
                System.out.println("Participante: " + participante.get("nombre"));
                System.out.println("Número de participante: " + participante.get("numeroParticipante"));
                System.out.println("Edad: " + participante.get("edad"));
                System.out.println("Monto: " + inscripcion.get("monto"));
                System.out.println("-------------------------------------");
            }
        }
    }
}