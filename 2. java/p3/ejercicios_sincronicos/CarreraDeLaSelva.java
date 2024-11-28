package p3.ejercicios_sincronicos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarreraDeLaSelva {
    public static void main(String[] args) {

        // Categorias
        Map<String, Object> categoriaCircuitoChico = new HashMap<>();
        Map<String, Object> categoriaCircuitoMedio = new HashMap<>();
        Map<String, Object> categoriaCircuitoAvanzado = new HashMap<>();

        // Setteo categoria circuito chico
        categoriaCircuitoChico.put("nombre", "Circuito Chico");
        categoriaCircuitoChico.put("descripcion", "2 km por selva y arroyos.");

        // Setteo categoria circuito medio
        categoriaCircuitoMedio.put("nombre", "Circuito Medio");
        categoriaCircuitoMedio.put("descripcion", "5 km por selva, arroyos y barro.");

        // Setteo categoria circuito avanzado
        categoriaCircuitoAvanzado.put("nombre", "Circuito Avanzado");
        categoriaCircuitoAvanzado.put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra.");

        // Participantes
        Map<String, Object> participante1 = new HashMap<>();
        participante1.put("participanteID", 1);
        participante1.put("dni", "11222333");
        participante1.put("nombre", "Andres");
        participante1.put("apellido", "Gonzales");
        participante1.put("edad", 21);
        participante1.put("celular", "1122334455");
        participante1.put("nroEmergencia", "1199887766");
        participante1.put("grupoSanguineo", "A+");
        participante1.put("categoria", categoriaCircuitoMedio);

        Map<String, Object> participante2 = new HashMap<>();
        participante2.put("participanteID", 2);
        participante2.put("dni", "11222334");
        participante2.put("nombre", "Julio");
        participante2.put("apellido", "Verne");
        participante2.put("edad", 14);
        participante2.put("celular", "1122334456");
        participante2.put("nroEmergencia", "1199887767");
        participante2.put("grupoSanguineo", "B-");
        participante2.put("categoria", categoriaCircuitoChico);

        Map<String, Object> participante3 = new HashMap<>();
        participante3.put("participanteID", 3);
        participante3.put("dni", "11222335");
        participante3.put("nombre", "Juan");
        participante3.put("apellido", "Perez");
        participante3.put("edad", 20);
        participante3.put("celular", "1122334457");
        participante3.put("nroEmergencia", "1199887768");
        participante3.put("grupoSanguineo", "B+");
        participante3.put("categoria", categoriaCircuitoAvanzado);

        System.out.println(calcularPrecioInscripcion(participante1));
        System.out.println(calcularPrecioInscripcion(participante2));
        System.out.println(calcularPrecioInscripcion(participante3));

    }

    public static int calcularPrecioInscripcion(Map<String, Object> participante) {
        Map<String, Object> categoria = (Map<String, Object>) participante.get("categoria");
        switch((String) categoria.get("nombre")){
            case "Circuito Chico" -> {
                if((int) participante.get("edad") < 18) {
                    return 1300;
                }
                return 1500;
            }
            case "Circuito Medio" -> {
                if((int) participante.get("edad") < 18) {
                    return 2000;
                }
                return 2300;
            }
            case "Circuito Avanzado" -> {
                if((int) participante.get("edad") < 18) {
                    System.out.println("No cumples con la edad para anotarte, vuelve en unos años.");
                    return 0;
                }
                return 2800;
            }
            default -> {
                System.out.println("Error al calcular ganancia");
                return 0;
            }
        }
    }
}
