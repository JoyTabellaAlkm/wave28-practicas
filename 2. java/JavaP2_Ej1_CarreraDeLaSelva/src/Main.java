import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<String>> categories = cargarCategorias();
        List<Map<String, String>> participantes = cargarParticipantes();
        Map<Integer, List<Object>> inscripciones = new HashMap<>();
        inscripciones.put(100, List.of(1, "1",
                calcularMontoAbonar(1, Integer.parseInt(participantes.getFirst().get("edad")))));
        inscripciones.put(101, List.of(1, "2",
                calcularMontoAbonar(1, Integer.parseInt(participantes.get(1).get("edad")))));
        inscripciones.put(102, List.of(2, "3",
                calcularMontoAbonar(1, Integer.parseInt(participantes.get(2).get("edad")))));
        inscripciones.put(103, List.of(3, "4",
                calcularMontoAbonar(1, Integer.parseInt(participantes.get(3).get("edad")))));

        imprimirParticipantes(participantes, inscripciones);


    }

    public static Map<Integer, List<String>> cargarCategorias() {
        Map<Integer, List<String>> categories = new HashMap<Integer, List<String>>();
        categories.put(1, new ArrayList<String>(List.of("chico", "2 km por selva y arroyos")));
        categories.put(2, new ArrayList<String>(List.of("medio", "5 km por selva, arroyos y barro")));
        categories.put(3, new ArrayList<String>(List.of("avanzado", "10 km por selva, arroyos, barro y escalada en piedra.")));
        return categories;
    }

    public static List<Map<String, String>> cargarParticipantes() {
        List<Map<String, String>> participantes = new ArrayList<>();
        participantes.add(new HashMap<String, String>(Map.of("numero", "1",
                "dni", "1", "nombre", "1", "apellido", "1", "edad",
                "20", "celular", "1",
                "numEmergencia", "123123123", "grupoSanguineo",
                "A+")));

        participantes.add(new HashMap<String, String>(Map.of("numero", "2",
                "dni", "1", "nombre", "1", "apellido", "1", "edad",
                "17", "celular", "1",
                "numEmergencia", "123123123", "grupoSanguineo",
                "A+")));

        participantes.add(new HashMap<String, String>(Map.of("numero", "3",
                "dni", "1", "nombre", "1", "apellido", "1", "edad",
                "15", "celular", "1",
                "numEmergencia", "123123123", "grupoSanguineo",
                "A+")));

        participantes.add(new HashMap<String, String>(Map.of("numero", "4",
                "dni", "1", "nombre", "1", "apellido", "1", "edad",
                "27", "celular", "1",
                "numEmergencia", "123123123", "grupoSanguineo",
                "A+")));

        return participantes;
    }

    public static void imprimirParticipantes(List<Map<String, String>> participantes, Map<Integer, List<Object>> Inscripciones) {
        List<String> part1= new ArrayList<>();
        List<String> part2= new ArrayList<>();
        List<String> part3= new ArrayList<>();
        for(Map.Entry<Integer, List<Object>> inscripcion : Inscripciones.entrySet()) {
            if(inscripcion.getValue().getFirst().equals(1)) {
                part1.add(inscripcion.getValue().get(1).toString());
            }else if(inscripcion.getValue().getFirst().equals(2)) {
                part2.add(inscripcion.getValue().get(1).toString());
            }else if(inscripcion.getValue().getFirst().equals(3)) {
                part3.add(inscripcion.getValue().get(1).toString());
            }
        }

        System.out.println("Participantes categoria chico:");
        for (String p : part1) {
            for (Map<String, String> part : participantes) {
                if(part.get("numero").equals(p)) {
                    imprimirParticipante(part);
                    break;
                };
            };
        };

        System.out.println("------------------------------------");

        System.out.println("Participantes categoria mediano:");
        for (String p : part2) {
            for (Map<String, String> part : participantes) {
                if(part.get("numero").equals(p)) {
                    imprimirParticipante(part);
                    break;
                };
            };
        };

        System.out.println("------------------------------------");

        System.out.println("Participantes categoria avanzado:");
        for (String p : part3) {
            for (Map<String, String> part : participantes) {
                if(part.get("numero").equals(p)) {
                    imprimirParticipante(part);
                    break;
                };
            };
        };

    }

    public static void imprimirParticipante(Map<String, String> participante)
    {
        System.out.println();
        System.out.println("numero: " + participante.get("numero"));
        System.out.println("dni: " + participante.get("dni"));
        System.out.println("edad: " + participante.get("edad"));
        System.out.println("nombre: " + participante.get("nombre"));
        System.out.println("apellido: " + participante.get("apellido"));
        System.out.println("numero emergencias: " + participante.get("numEmergencia"));
        System.out.println("grupo sanguineo: " + participante.get("grupoSanguineo"));

    }


    public static Integer calcularMontoAbonar(int categoria, int edad) {
        if (edad >= 18) {
            return switch (categoria) {
                case 1 -> 1500;
                case 2 -> 2300;
                case 3 -> 2800;
                default -> 0;
            };
        } else {
            return switch (categoria) {
                case 1 -> 1300;
                case 2 -> 2000;
                case 3 -> 0;
                default -> 0;
            };
        }

    }

    }



