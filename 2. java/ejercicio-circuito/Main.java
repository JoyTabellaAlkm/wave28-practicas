import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<HashMap<String, Object>> inscriptions = new HashSet<>();

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
        advanceCircuit.put("name", "Circuito Medio");
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

        HashMap<String, Object> participant4 = new HashMap<>();
        participant4.put("dni", 35776761);
        participant4.put("name", "Pepe");
        participant4.put("lastname", "Lopez");
        participant4.put("age", 24);
        participant4.put("phone", 1130313273);
        participant4.put("emergencyNumber", 1130325643);
        participant4.put("bloodGroup", "A");

        inscriptions.add(registerParticipants(participant2, midCircuit));
        inscriptions.add(registerParticipants(participant3, advanceCircuit));
        inscriptions.add(registerParticipants(participant1, smallCircuit));
        inscriptions.add(registerParticipants(participant4, midCircuit));

        showParticipants(inscriptions, 2);
    }

    public static HashMap<String, Object> registerParticipants(HashMap<String, Object> participant, HashMap<String, Object> category) {
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
        inscription.put("idInscription", System.currentTimeMillis());
        inscription.put("category", category);
        inscription.put("participant", participant);
        inscription.put("cost", cost);

        return inscription;
    }

    public static void showParticipants(HashSet<HashMap<String, Object>> inscriptions, int categoryId) {
        for (HashMap<String, Object> map : inscriptions) {
            HashMap<String, Object> retrievedCategory = (HashMap<String, Object>) map.get("category");
            if ((int) retrievedCategory.get("id") == categoryId) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }
    }


}
