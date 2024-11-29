package MapasPractica;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String[]> categorias = new HashMap<>();

        Map<Integer, String[]> participantes = new HashMap<>();

        Map <Integer, Map<Object, Object>> inscripciones = new HashMap<>();

        categorias.put(1, new String[] {"chico", "2km", "selva y arroyos"});
        categorias.put(2, new String[] {"mediano", "5km", "selva, arroyos y barro"});
        categorias.put(3, new String[] {"avanzado", "10km", "selva, arroyos, barro y escalada en piedra"});

        participantes.put(100213895, new String[] {"123", "15", "Juan Perea"});
        participantes.put(200056778, new String[] {"124", "18", "Maria Navarro"});
        participantes.put(567890235, new String[] {"125", "22", "Juan de Oro"});



        InscribeParticipate();

    }

    public static void InscribeParticipate(){
        inscripciones.put(123, Map.of(categorias.get(1), participantes.get(100213895)));
        inscripciones.put(123, Map.of(categorias.get(2), participantes.get(200056778)));
        inscripciones.put(123, Map.of(categorias.get(3), participantes.get(567890235)));
    }
}
