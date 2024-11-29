import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solucion {
    public static void main(String[] args) {
        // a)
        Map<Integer, List<Object>> circuitos = new HashMap<>();
        circuitos.put(1, new ArrayList<>(List.of("Chico", "2 km por selva y arroyos")));
        circuitos.put(2, new ArrayList<>(List.of("Medio", "5 km por selva, arroyos y barro")));
        circuitos.put(3, new ArrayList<>(List.of("Avanzado", "10 km por selva, arroyos, barro y escalada en piedra")));

        // b) y c)
        List<List<Object>> participantes = new ArrayList<>();
        participantes.add(new ArrayList<>(List.of(1, "123", "Pepe", "Juarez", 12, "151515", "101010", "A")));
        participantes.add(new ArrayList<>(List.of(2, "421", "Juan", "Perez", 19, "133331", "4124", "B")));
        participantes.add(new ArrayList<>(List.of(3, "421", "Esteban", "Quito", 22, "133331", "4124", "B")));

        Map<Integer, List<Object>> inscripciones = new HashMap<>();

        int montoInscripcionPepe = calcularInscripcion(participantes.get(0), "Chico");
        int montoInscripcionJuan= calcularInscripcion(participantes.get(1), "Avanzado");

        inscripciones.put(1, new ArrayList<>(List.of(circuitos.get(1), participantes.get(0), montoInscripcionPepe)));
        inscripciones.put(2, new ArrayList<>(List.of(circuitos.get(3), participantes.get(1), montoInscripcionJuan)));
        inscripciones.put(3, new ArrayList<>(List.of(circuitos.get(3), participantes.get(2), calcularInscripcion(participantes.get(2), "Avanzado"))));

        // d)
        imprimirInscripcionesEn("Chico", inscripciones);
        imprimirInscripcionesEn("Avanzado", inscripciones);

        // e)
        inscripciones.remove(2);
        System.out.println("Luego de desinscribir al participante Juan");
        imprimirInscripcionesEn("Avanzado", inscripciones);

        //f)
        int montoChico = calcularMontoRecaudado("Chico", inscripciones);
        int montoMedio = calcularMontoRecaudado("Medio", inscripciones);
        int montoAvanzado = calcularMontoRecaudado("Avanzado", inscripciones);
        System.out.println("RECAUDACIONES:");
        System.out.println(String.format("Chico: %d, Medio: %d, Avanzado: %d", montoChico, montoMedio, montoAvanzado));
        System.out.println("TOTAL: " + (montoChico+montoMedio+montoAvanzado));
    }

    public static int calcularInscripcion(List<Object> participante, String categoria) {

        int edad = (int) participante.get(4);
        return switch(categoria) {
            case "Chico" -> edad < 18 ? 1300 : 1500;
            case "Medio" -> edad < 18 ? 2000 : 2300;
            case "Avanzado" -> {
                if (edad < 18)
                    throw new RuntimeException("No se permite inscribir menores en la categoria avanzado");
                yield 2800;
            }
            default -> throw new RuntimeException("Categoria invaldia");
        };
    }

    public static void imprimirInscripcionesEn(String categoria, Map<Integer, List<Object>> inscripciones) {
        if (!List.of("Chico", "Medio", "Avanzado").contains(categoria)) {
            throw new RuntimeException("Categoria invaldia");
        }

        System.out.println("Inscripciones a la categoria " + categoria + ":");
        inscripciones.entrySet().forEach(entry -> {
            if (!((List<Object>) entry.getValue().get(0)).get(0).equals(categoria))
                return;
            List<Object> p = (List<Object>) entry.getValue().get(1);
            System.out.println(String.format("NroInscripcion: %d, Inscripto: %s %s, monto: %d",
                    entry.getKey(), p.get(2), p.get(3), entry.getValue().get(2)));
        });
    }

    public static int calcularMontoRecaudado(String categoria, Map<Integer, List<Object>> inscripciones) {
        if (!List.of("Chico", "Medio", "Avanzado").contains(categoria)) {
            throw new RuntimeException("Categoria invaldia");
        }

        return inscripciones.values().stream()
                .filter(i -> ((List<Object>) i.get(0)).get(0).equals(categoria))
                .map(i -> (int) i.get(2))
                .reduce((acum, m) -> acum + m).orElse(0);
    }
}
