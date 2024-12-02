import java.util.ArrayList;
import java.util.HashMap;

class Carrera {
    public static void main(String[] args) {
        // Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
        HashMap<Integer, HashMap<String, String>> circuitos = new HashMap<>();
        HashMap<String, String> circuitoChico = new HashMap<>();
        circuitoChico.put("Nombre", "Circuito chico");
        circuitoChico.put("Descripcion", "2 km por selva y arroyos");
        circuitos.put(1, circuitoChico);

        HashMap<String, String> circuitoMedio = new HashMap<>();
        circuitoMedio.put("Nombre", "Circuito medio");
        circuitoMedio.put("Descripcion", "5 km por selva, arroyos y barro");
        circuitos.put(2, circuitoMedio);

        HashMap<String, String> circuitoAvanzado = new HashMap<>();
        circuitoAvanzado.put("Nombre", "Circuito avanzado");
        circuitoAvanzado.put("Descripcion", "0 km por selva, arroyos, barro y escalada en piedra");
        circuitos.put(3, circuitoAvanzado);

        // Crear un nuevo participante e inscribirlo en una categoría.
        // Calcular el monto de inscripción que deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500).
        HashMap<Integer, HashMap<String, String>> participantes = new HashMap<>();
        HashMap<String, String> participante = new HashMap<>();
        participante.put("dni", "43567890");
        participante.put("nombre", "John");
        participante.put("apellido", "Doe");
        participante.put("edad", "21");
        participante.put("celular", "11324354");
        participante.put("nroEmergencia", "11324354");
        participante.put("grupoSanguineo", "BH+");
        participantes.put(1, participante);

        // Cada inscripción debe contar con un número de inscripción, una categoría, un participante y el monto a abonar por el participante.
        HashMap<String, String> inscripcion = new HashMap<>();
        inscripcion.put("numero", "4");
        inscripcion.put("categoria", "3");
        inscripcion.put("participante", "1");
    }
}