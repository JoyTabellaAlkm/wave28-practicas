import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<Integer, List<Object>> circuitos = new HashMap<>();
        circuitos.put(1, new ArrayList<>(List.of("Chico", "2 km por selva y arroyos")));
        circuitos.put(2, new ArrayList<>(List.of("Medio", "5 km por selva, arroyos y barro")));
        circuitos.put(3, new ArrayList<>(List.of("Avanzado", "10 km por selva, arroyos, barro y escalada en piedra")));

        List<List<Object>> participantes = new ArrayList<>();
        participantes.add(new ArrayList<>(List.of(1, "123", "Pepe", "Juarez", 12, "151515", "101010", "A")));
        participantes.add(new ArrayList<>(List.of(2, "421", "Juan", "Perez", 19, "133331", "4124", "B")));

        Map<Integer, List<Object>> inscripciones = new HashMap<>();

        double montoInscripcionPepe = calcularInscripcion(participantes.get(0));
        double montoInscripcionJuan= calcularInscripcion(participantes.get(1));


        inscripciones.put(1, new ArrayList<>(List.of(circuitos.get(1), participantes.get(0))));
        inscripciones.put(2, new ArrayList<>(List.of(circuitos.get(3), participantes.get(1))));

    }

    public static double calcularInscripcion(List<Object> participante, String categoria) {
        double montoInscripcion = 0.0,
        switch (categoria) {
            case "Chico":
                montoInscripcion = 1500;
        }
    }
}