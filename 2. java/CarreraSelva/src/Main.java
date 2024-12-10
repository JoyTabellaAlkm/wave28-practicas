import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, List<Object>> circuito = new HashMap<>();
        circuito.put(1, new ArrayList<>(List.of("Circuito chico", "2 km por selva y arroyos.")));
        circuito.put(2, new ArrayList<>(List.of("Circuito medio", "5 km por selva, arroyos y barro.")));
        circuito.put(3, new ArrayList<>(List.of("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.")));

        List<Object> participantes = new ArrayList<>();
//        dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo.
        participantes.add(new ArrayList<>(List.of(12345678, "Juan", "Perez", 25, 300123456, 311987654, "O+")));
        participantes.add(new ArrayList<>(List.of(87654321, "Ana", "Gomez", 30, 300765432, 310876543, "A-")));
        participantes.add(new ArrayList<>(List.of(45678912, "Pedro", "Lopez", 28, 300654321, 312345678, "B+")));
        participantes.add(new ArrayList<>(List.of(98765432, "Laura", "Martinez", 35, 300876543, 314567890, "AB+")));
        participantes.add(new ArrayList<>(List.of(65432198, "Maria", "Rodriguez", 22, 300567890, 316789012, "O-")));
        //un número de inscripción, una categoría, un participante y el monto a abonar por el participante.
        HashMap<Integer, List<Object>> inscripcion = new HashMap<>();
        Random random = new Random();
        Set <Integer> participanteInscrito = new HashSet<>();
        System.out.println("Lista de inscripciones:");
        for (int i = 0;i < participantes.size(); i++ ){
            int randomCircuito = random.nextInt(circuito.size())+1;
            int randomParticipante;
            do{
                randomParticipante = random.nextInt(participantes.size());
            }while (participanteInscrito.contains(randomParticipante));
            participanteInscrito.add(randomParticipante);
            List<Object> participante = (List<Object>) participantes.get(randomParticipante);
            Object abono = 0;
            if (randomCircuito == 1 ){
                abono = ((int) participante.get(3) > 17) ? 1500 : 1300;
            } else {
                if (randomCircuito == 2 ){
                    abono = ((int) participante.get(3) > 17) ? 2300 : 2000;
                } else {
                    if (randomCircuito == 3 ){
                        abono = ((int) participante.get(3) > 17) ? 2800 : "No se permite inscripciones a menores de 18 años";
                    }
                }
            }
            inscripcion.put(i, new ArrayList<>(List.of(randomCircuito, randomParticipante, abono)));
        }
        int totalAbonos = 0;
        HashMap<Integer, Integer> sumaPorCircuito = new HashMap<>();
        for(Map.Entry<Integer, List<Object>> entry : inscripcion.entrySet()){
            int numeroInscripcion = entry.getKey();
            List<Object> detalle = entry.getValue();
            int circuitoSeleccionado = (int) detalle.get(0);
            int participanteIndice = (int) detalle.get(1);
            List<Object> datosParticipante = (List<Object>) participantes.get(participanteIndice);
            Object abono = detalle.get(2);

            System.out.println("Inscripción Número: " + numeroInscripcion);
            System.out.println("Circuito: " + circuitoSeleccionado);
            System.out.println("  Detalles: " + circuito.get(circuitoSeleccionado).get(0) + " - " + circuito.get(circuitoSeleccionado).get(1));
            System.out.println("Participante:");
            System.out.println("  DNI: " + datosParticipante.get(0));
            System.out.println("  Nombre: " + datosParticipante.get(1) + " " + datosParticipante.get(2));
            System.out.println("  Edad: " + datosParticipante.get(3));
            System.out.println("  Celular: " + datosParticipante.get(4));
            System.out.println("  Número de Emergencia: " + datosParticipante.get(5));
            System.out.println("  Grupo Sanguíneo: " + datosParticipante.get(6));
            System.out.println("Monto a Abonar: " + abono);
            System.out.println("----------------------");

            if (abono instanceof Integer) {
                totalAbonos += (int) abono;

                sumaPorCircuito.put(circuitoSeleccionado,
                        sumaPorCircuito.getOrDefault(circuitoSeleccionado, 0) + (int) abono);
            }

        }
        //System.out.println(inscripcion);


        System.out.println("Total de todos los abonos: " + totalAbonos);
        System.out.println("Total por circuito:");
        for (Map.Entry<Integer, Integer> circuitoEntry : sumaPorCircuito.entrySet()) {
            System.out.println("  Circuito " + circuitoEntry.getKey() + ": " + circuitoEntry.getValue());
        }

    }
}