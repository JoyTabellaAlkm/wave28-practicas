import java.util.*;

public class ejercitacion {
    public static void main(String[] args) {
        HashSet<HashMap<String, Object>> inscriptions = new HashSet<>();
        HashSet<Integer> registeredParticipantsDni = new HashSet<>();

        //VERIFICAR NO PARTICIPANTES DUPLICADOS
        HashMap<String, Object> smallCircuit = new HashMap<>();
        smallCircuit.put("id", 1);
        smallCircuit.put("name", "Circuito Chico");
        smallCircuit.put("description", "2 km por selva y arroyos.");
        smallCircuit.put("costUnder18", 1300);
        smallCircuit.put("costOver18", 1500);

        HashMap<String, Object> midCircuit = new HashMap<>();
        midCircuit.put("id", 2);
        midCircuit.put("name", "Circuito Medio");
        midCircuit.put("description", "5 km por selva, arroyos y barro.");
        midCircuit.put("costUnder18", 2000);
        midCircuit.put("costOver18", 2300);

        HashMap<String, Object> advanceCircuit = new HashMap<>();
        advanceCircuit.put("id", 3);
        advanceCircuit.put("name", "Circuito Dificil");
        advanceCircuit.put("description", "10 km por selva, arroyos, barro y escalada en piedra.");
        advanceCircuit.put("costUnder18", null);
        advanceCircuit.put("costOver18", 2800);

        HashMap<String, Object> participant1 = new HashMap<>();
        participant1.put("dni", 35776760);
        participant1.put("name", "Pablo");
        participant1.put("lastname", "García");
        participant1.put("age", 34);
        participant1.put("phone", 1130313273);
        participant1.put("emergencyNumber", 1130325643);
        participant1.put("bloodGroup", "A");

        HashMap<String, Object> participant2 = new HashMap<>();
        participant2.put("dni", 49144324);
        participant2.put("name", "Jose");
        participant2.put("lastname", "Perez");
        participant2.put("age", 16);
        participant2.put("phone", 1172664567);
        participant2.put("emergencyNumber", 1139325567);
        participant2.put("bloodGroup", "A");

        HashMap<String, Object> participant3 = new HashMap<>();
        participant3.put("dni", 39349942);
        participant3.put("name", "María");
        participant3.put("lastname", "Villagra");
        participant3.put("age", 28);
        participant3.put("phone", 1130325643);
        participant3.put("emergencyNumber", 1130313273);
        participant3.put("bloodGroup", "B");

        register(inscriptions, registeredParticipantsDni, participant2, midCircuit);
        register(inscriptions, registeredParticipantsDni, participant2, advanceCircuit);
        register(inscriptions, registeredParticipantsDni, participant3, smallCircuit);
        register(inscriptions, registeredParticipantsDni, participant1, midCircuit);
        register(inscriptions, registeredParticipantsDni, participant1, advanceCircuit);
        register(inscriptions, registeredParticipantsDni, participant3, smallCircuit);


        inscriptions.stream().forEach(System.out::println);
    }

    public static HashMap<String, Object> registeredParticipants(HashMap<String, Object> participant, HashMap<String, Object> category, int id) {
        int age = (int) participant.get("age");
        int cost;

        if (age >= 18) {
            cost = (int) category.get("costOver18");
        } else {
            if (category.get("costUnder18") == null) {
                return null;
            }

            cost = (int) category.get("costUnder18");
        }

        HashMap<String, Object> inscription = new HashMap<>();
        inscription.put("idInscription", id);
        inscription.put("category", category);
        inscription.put("participant", participant);
        inscription.put("cost", cost);

        return inscription;
    }

    //Metodo para verificar si ya se encuentra registrado o no, permitiendo que no haya duplicados.
    public static void register(HashSet<HashMap<String, Object>> inscriptions,
                                HashSet<Integer> registeredParticipantsDni,
                                HashMap<String, Object> participant,
                                HashMap<String, Object> category) {
        int dni = (int) participant.get("dni");

        if (registeredParticipantsDni.contains(dni)) {
            System.out.println("El participante con DNI " + dni + " ya está inscrito y no puede inscribirse en otra categoría.");
            return;
        }

        int id = inscriptions.size() + 1;
        HashMap<String, Object> inscription = registeredParticipants(participant, category, id);

        if (inscription != null) {
            inscriptions.add(inscription);
            registeredParticipantsDni.add(dni);
        }
    }

}

