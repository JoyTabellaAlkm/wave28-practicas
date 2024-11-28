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
        categoriaCircuitoMedio.put("valorMenoresDeEdad", 2000);
        categoriaCircuitoMedio.put("valorMayoresDeEdad", 2300);

        // Setteo categoria circuito avanzado
        categoriaCircuitoAvanzado.put("nombre", "Circuito Avanzado");
        categoriaCircuitoAvanzado.put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra.");
        categoriaCircuitoAvanzado.put("valorMayoresDeEdad", 2800);

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

        System.out.println(calcularPrecioInscripcion(participante1));

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
