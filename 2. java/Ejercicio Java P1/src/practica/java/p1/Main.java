package practica.java.p1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Map<String, String>> circuitos = new HashMap<>();
        //circuito 1
        circuitos.put(1, Map.of("name", "circuito 1",
                "description", "2 km por selva y arroyos."
        ));
        //circuito2
        circuitos.put(2, Map.of(
                "name", "Circuito medio",
                "description", "5 km por selva, arroyos y barro."
        ));
        //circuito3
        circuitos.put(3, Map.of(
                "name", "Circuito avanzado",
                "description", "10 km por selva, arroyos, barro y escalada en piedra."
        ));

        Map<Integer, Map<String, String>> participantes = new HashMap<>();
        participantes.put(1, Map.of(
                "dni", "12345678",
                "nombre", "Juan",
                "apellido", "Pérez",
                "edad", "12",
                "celular", "555-1234",
                "numeroEmergencia", "555-5678",
                "grupoSanguineo", "A+"
        ));

        participantes.put(2, Map.of(
                "dni", "23456789",
                "nombre", "Ana",
                "apellido", "González",
                "edad", "25",
                "celular", "555-2345",
                "numeroEmergencia", "555-6789",
                "grupoSanguineo", "B-"
        ));

        participantes.put(3, Map.of(
                "dni", "34567890",
                "nombre", "Pedro",
                "apellido", "Rodríguez",
                "edad", "22",
                "celular", "555-3456",
                "numeroEmergencia", "555-7890",
                "grupoSanguineo", "O+"
        ));

        participantes.put(4, Map.of(
                "dni", "45678901",
                "nombre", "Lucía",
                "apellido", "Martínez",
                "edad", "28",
                "celular", "555-4567",
                "numeroEmergencia", "555-8901",
                "grupoSanguineo", "AB+"
        ));
        Map<Integer, Map<String, Integer>> inscripciones = new HashMap<>();
        inscribirParticipante(inscripciones,participantes,1,2);
        System.out.println(inscripciones);
}
    public static void inscribirParticipante(Map<Integer, Map<String, Integer>> inscripciones ,Map<Integer, Map<String, String>> participantes,Integer idParticipante,Integer idCircuito){
        Map<String, String> participante = participantes.get(idParticipante);
        int edad = Integer.parseInt(participante.get("edad"));
        int monto = 0;
        switch (idCircuito) {
            case 1:
                monto = (edad < 18) ? 1300 : 1500;
                break;
            case 2:
                monto = (edad < 18) ? 2000 : 2300;
                break;
            case 3:
                if (edad < 18) {
                    System.out.println(participante.get("nombre") + " " + participante.get("apellido") + " no puede inscribirse en el Circuito avanzado. Debe tener 18 años o más.");
                    return;
                } else {
                    monto = 2800;
                }
                break;
            default:
                System.out.println("Categoría no válida.");
                return;
        }
        inscripciones.put(inscripciones.size()+1,Map.of("participante",idParticipante,"circuito", idCircuito,"monto",monto));
    }
}
