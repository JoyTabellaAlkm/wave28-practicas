import java.util.HashMap;
import java.util.Map;

public class EstructurasDinamicas {
    public class Inscripcion {
        int numeroInscripcion;
        String categoria;
        String participante;
        Double montoAPagar;
    }
    public Inscripcion inscribir (int numeroInscripcion, String categoria, String participante){

        //Inscripcion inscripcion = new Inscripcion( numeroInscripcion, categoria, participante);
        return null;
    }
    public static void main(String[] args) {

        Map<String, HashMap<String, String>> circuitos = new HashMap<>();
        HashMap<String, String> circuitoChico = new HashMap<>();
        HashMap<String, String> circuitoMedio = new HashMap<>();
        HashMap<String, String> circuitoAvanzado = new HashMap<>();

        circuitoChico.put("id", "chico");
        circuitoChico.put("nombre", "circuito chico");
        circuitoChico.put("descripcion", "2 km por selva y arroyos.");

        circuitoMedio.put("id", "medio");
        circuitoMedio.put("nombre", "circuito medio");
        circuitoMedio.put("descripcion", "5 km por selva, arroyos y barro.");

        circuitoAvanzado.put("id", "avanzado");
        circuitoAvanzado.put("nombre", "circuito avanzado");
        circuitoAvanzado.put("descripcion", "5 km por selva, arroyos y barro.");

        circuitos.put("chico", circuitoChico);
        circuitos.put("medio", circuitoMedio);
        circuitos.put("avanzado", circuitoAvanzado);


    }
}